package com.micronaut.bookrecommendation;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.reactivex.Maybe;

import javax.validation.constraints.NotBlank;

@Client("bookinventory")
public interface BookInventoryClient extends BookInventoryOperations{

    @Get("/books/stock/{isbn}")
    Maybe<Boolean> stock(@NotBlank String isbn);
}