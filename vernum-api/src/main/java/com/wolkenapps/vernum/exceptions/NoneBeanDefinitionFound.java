package com.wolkenapps.vernum.exceptions;

public class NoneBeanDefinitionFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoneBeanDefinitionFound(String name) {
        super("None bean definition with name " + name + " not found!");
    }

}
