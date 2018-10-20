package com.micronaut.bookrecommendation;

import io.reactivex.Maybe;

import javax.validation.constraints.NotBlank;

public interface BookInventoryOperations {
    Maybe<Boolean> stock(@NotBlank Integer isbn);
}
