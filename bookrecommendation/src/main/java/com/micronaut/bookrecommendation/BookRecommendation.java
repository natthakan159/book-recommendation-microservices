package com.micronaut.bookrecommendation;

import java.util.Objects;

public class BookRecommendation {
    private String name;

    public BookRecommendation() {}

    public BookRecommendation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookRecommendation bookRecommendation = (BookRecommendation) o;
        return Objects.equals(name, bookRecommendation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
