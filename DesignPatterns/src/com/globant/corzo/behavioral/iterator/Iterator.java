package com.globant.corzo.behavioral.iterator;

public interface Iterator<E> {
    void reset();

    E next();

    E currentItem();

    boolean hasNext();
}

