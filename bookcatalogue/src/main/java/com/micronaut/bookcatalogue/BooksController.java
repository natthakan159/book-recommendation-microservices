package com.micronaut.bookcatalogue;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.Arrays;
import java.util.List;

@Controller("/books")
public class BooksController {

    @Get("/")
    List<Book> index() {
        Book buildingMicroservices = new Book("1491950358", "Microservices");
        Book releaseIt = new Book("1680502395", "Release It");
        Book cideLivery = new Book("0321601912", "Continuous Delivery:");
        return Arrays.asList(buildingMicroservices, releaseIt, cideLivery);
    }
}