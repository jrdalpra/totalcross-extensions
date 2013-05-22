package com.wolkenapps.totalcross.utils.lang;

public final class Strings {
   private Strings() {
   }

   public static String contains(String string) {
      return string == null ? null : starts(ends(string));
   }

   public static String starts(String string) {
      return string == null ? null : (string + (string.endsWith("%") ? "" : "%"));
   }

   public static String ends(String string) {
      return string == null ? null : ((string.startsWith("%") ? "" : "%") + string);
   }
}
