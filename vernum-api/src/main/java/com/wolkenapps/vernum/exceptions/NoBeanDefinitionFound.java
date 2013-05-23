package com.wolkenapps.vernum.exceptions;

public class NoBeanDefinitionFound extends RuntimeException {

   private static final long serialVersionUID = 1L;

   public NoBeanDefinitionFound(String name) {
      super("No bean definition with name " + name + " was found!");
   }

}
