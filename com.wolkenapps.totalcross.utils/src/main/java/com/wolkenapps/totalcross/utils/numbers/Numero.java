package com.wolkenapps.totalcross.utils.numbers;

import totalcross.sys.InvalidNumberException;
import totalcross.util.BigDecimal;

public class Numero {

   private Numero() {
   }

   public static final class BigDecimal_ {

      public static boolean naoEhIgual(BigDecimal este, BigDecimal outro) {
         return !ehIgual(este, outro);
      }

      public static boolean ehIgual(BigDecimal este, BigDecimal outro) {
         return este.compareTo(outro) == 0;
      }

      public static boolean ehMaior(BigDecimal este, BigDecimal outro) {
         return este.compareTo(outro) > 0;
      }

      public static boolean ehMaiorOuIgual(BigDecimal este, BigDecimal outro) {
         return ehIgual(este, outro) || ehMaior(este, outro);
      }

      public static boolean ehMenor(BigDecimal este, BigDecimal outro) {
         return este.compareTo(outro) < 0;
      }

      public static boolean ehMenorOuIgual(BigDecimal este, BigDecimal outro) {
         return ehIgual(este, outro) || ehMenor(este, outro);
      }

      public static boolean ehMenorOuIgualAZero(BigDecimal este) {
         return ehMenorOuIgual(este, BigDecimal.ZERO);
      }

      public static boolean ehMaiorQueZero(BigDecimal este) {
         return ehMaior(este, BigDecimal.ZERO);
      }

      public static boolean ehMaiorOuIgualAZero(BigDecimal este) {
         return ehMaiorOuIgual(este, BigDecimal.ZERO);
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

      public static BigDecimal valueOf(String este) {
         try {
            return este.isEmpty() ? BigDecimal.valueOf(0) : new BigDecimal(este);
         } catch (InvalidNumberException e) {
            throw new RuntimeException("Erro ao converter " + este + " para BigDecimal");
         }
      }

      public static boolean ehNuloOuZero(BigDecimal este) {
         return este == null || ehIgual(este, BigDecimal.ZERO);
      }

      public static boolean ehMenorQueZero(BigDecimal este) {
         return ehMenor(este, BigDecimal.ZERO);
      }

      public static double double_(BigDecimal este) {
         try {
            return este.doubleValue();
         } catch (InvalidNumberException e) {
            throw new RuntimeException(e.getMessage());
         }
      }

   }
}
