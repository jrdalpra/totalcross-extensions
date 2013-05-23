package com.wolkenapps.totalcross.utils.lang;

public class Booleans {
   private Booleans() {
   }

   public static boolean fromInt(int value) {
      return value == 0 ? false : true;
   }

}
