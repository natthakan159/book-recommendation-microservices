package com.micronaut.bookrecommendation;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.reactivex.Flowable;

@Client("bookcatalogue")
public interface BookCatalogueClient extends BookCatalogueOperations {

    @Get("/books")
    Flowable<Book> findAll();
}