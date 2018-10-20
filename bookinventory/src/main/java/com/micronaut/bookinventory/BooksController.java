package com.micronaut.bookinventory;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Options;
import io.micronaut.http.annotation.Produces;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.util.Optional;

@Controller("/books")
public class BooksController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/stock/{isbn}")
    public Boolean stock(@NotBlank Integer isbn){
        return bookInventoryByIsbn(isbn).map(bi -> bi.getStock() >0).orElse(null);
    }

    private Optional<BookInventory> bookInventoryByIsbn(Integer isbn) {
        if (Integer.valueOf(1491950358).equals(isbn)) {
            return Optional.of(new BookInventory(isbn, 4));
        } else if(Integer.valueOf(1680502395).equals(isbn)) {
            return Optional.of(new BookInventory(isbn, 0));
        }
        return Optional.empty();
    }
}
