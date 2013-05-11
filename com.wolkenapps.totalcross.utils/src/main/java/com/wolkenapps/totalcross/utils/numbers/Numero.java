package com.wolkenapps.totalcross.utils.numbers;

import totalcross.sys.InvalidNumberException;
import totalcross.util.BigDecimal;

public class Numero {

   private Numero() {
   }

   public static final class BigDecimal_ {

      public static boolean ehIgual(BigDecimal um, BigDecimal outro) {
         return um.compareTo(outro) == 0;
      }

      public static boolean ehMaior(BigDecimal um, BigDecimal outro) {
         return um.compareTo(outro) > 0;
      }

      public static boolean ehMaiorOuIgual(BigDecimal um, BigDecimal outro) {
         return ehIgual(um, outro) || ehMaior(um, outro);
      }

      public static boolean ehMenor(BigDecimal um, BigDecimal outro) {
         return um.compareTo(outro) < 0;
      }

      public static boolean ehMenorOuIgual(BigDecimal um, BigDecimal outro) {
         return ehIgual(um, outro) || ehMenor(um, outro);
      }

      public static boolean ehMenorOuIgualAZero(BigDecimal um) {
         return ehMenorOuIgual(um, BigDecimal.ZERO);
      }

      public static boolean ehMaiorQueZero(BigDecimal numero) {
         return ehMaior(numero, BigDecimal.ZERO);
      }

      public static boolean ehMaiorOuIgualAZero(BigDecimal numero) {
         return ehMaiorOuIgual(numero, BigDecimal.ZERO);
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

      public static BigDecimal valueOf(String numero) {
         try {
            return numero.isEmpty() ? BigDecimal.valueOf(0) : new BigDecimal(numero);
         } catch (InvalidNumberException e) {
            throw new RuntimeException("Erro ao converter " + numero + " para BigDecimal");
         }
      }

   }

}
