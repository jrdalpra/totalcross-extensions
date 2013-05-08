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

      public static BigDecimal novo(double valor) {
         return novo(valor, BigDecimal.ROUND_HALF_DOWN);
      }

      public static BigDecimal novo(double valor, int arredondamento) {
         return novo(valor, 3, arredondamento);
      }

      public static BigDecimal novo(double valor, int casasDecimais, int arredondamento) {
         try {
            BigDecimal big = BigDecimal.valueOf(valor);
            return big.setScale(casasDecimais, arredondamento);
         } catch (InvalidNumberException erro) {
            throw new RuntimeException(erro);
         }
      }
   }

}
