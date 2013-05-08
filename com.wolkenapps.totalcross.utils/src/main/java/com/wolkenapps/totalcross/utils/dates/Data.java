package com.wolkenapps.totalcross.utils.dates;

import totalcross.util.Date;
import totalcross.util.InvalidDateException;

public class Data {

   public static class Invalida extends RuntimeException {
      private static final long serialVersionUID = 1L;

      public Invalida(String message) {
         super(message);
      }
   }

   /**
    * Nova data
    *
    * @param data que será utilizada na soma
    * @param dias para somar
    * @return nova data com os dias somados
    */
   public static Date somaDias(Date data, int dias) {
      Date nova = nova(data.getDay(), data.getMonth(), data.getYear());
      nova.advance(dias);
      return nova;
   }

   /**
    *
    * @param dia de 1 até o última dia do mês
    * @param mes de 1 até 12
    * @param ano de 1000 até 2999
    * @return uma nova {@link Date}
    */
   public static Date nova(int dia, int mes, int ano) {
      try {
         return new Date(dia, mes, ano);
      } catch (InvalidDateException e) {
         throw new Data.Invalida(e.getMessage());
      }
   }

}
