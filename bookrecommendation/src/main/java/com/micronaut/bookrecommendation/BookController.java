package com.micronaut.bookrecommendation;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.reactivex.Flowable;

@Controller("/books")
public class BookController {

    private final BookInventoryOperations bookInventoryOperations;
    private final BookCatalogueOperations bookCatalogueOperations;

    public BookController(BookInventoryOperations bookInventoryOperations,
                          BookCatalogueOperations bookCatalogueOperations) {
        this.bookCatalogueOperations = bookCatalogueOperations;
        this.bookInventoryOperations = bookInventoryOperations;

    }

    @Get("/")
    public Flowable<BookRecommendation> index() {
        return bookCatalogueOperations.findAll()
                .flatMapMaybe(b -> bookInventoryOperations.stock(b.getIsbn())
                .filter(Boolean::booleanValue)
                .map(rsp -> b)
                ).map(book -> new BookRecommendation(book.getName()));
    }
}