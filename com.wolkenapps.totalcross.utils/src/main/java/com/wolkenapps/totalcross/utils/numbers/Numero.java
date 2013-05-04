package com.wolkenapps.totalcross.utils.numbers;

import totalcross.sys.InvalidNumberException;
import totalcross.util.BigDecimal;

public class Numero {

   private Numero() {
   }

   public static final class BigDecimal_ {

      public static boolean ehMaiorQueZero(BigDecimal numero) {
         return numero.compareTo(BigDecimal.ZERO) > 0;
      }

      public static BigDecimal novo(double value) {
         return novo(value, 3);
      }

      public static BigDecimal novo(double value, int scale) {
         try {
            BigDecimal big = BigDecimal.valueOf(value);
            return big.setScale(scale);
         } catch (InvalidNumberException erro) {
            throw new RuntimeException(erro);
         }
      }
   }

}
