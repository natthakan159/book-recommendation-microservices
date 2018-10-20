package com.micronaut.bookrecommendation;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Maybe;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;

@Requires(env = Environment.TEST)
@Fallback
@Singleton
public class BookInventoryClientSub implements BookInventoryOperations {

    @Override
    public Maybe<Boolean> stock(@NotBlank Integer isbn) {
        if (Integer.valueOf(1491950358).equals(isbn)) {
            return Maybe.just(Boolean.TRUE);
        } else if (Integer.valueOf(1680502395).equals(isbn)) {
            return Maybe.just(Boolean.FALSE);
        }
        return Maybe.empty();
    }

}
