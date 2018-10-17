package com.micronaut.bookrecommendation;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;

import javax.inject.Singleton;

@Requires(env = Environment.TEST)
@Fallback
@Singleton
public class BookCatalogueClientSub implements BookCatalogueOperations {

    @Override
    public Flowable<Book> findAll() {
        Book buildingMiroservices = new Book("1491950358", "Microservices");
        Book releaseIt = new Book("1491950358", "Release It");
        return Flowable.just(buildingMiroservices, releaseIt);
    }
}
