package com.wolkenapps.totalcross.dsl;

public final class GaranteQue {
   private GaranteQue() {
   }

   public static void naoEhNulo(Object objeto) {
      naoEhNulo(objeto, "Objeto nao pode ser nulo");
   }

   public static void naoEhNulo(Object objeto, String mensagem) {
      ehVerdade(objeto == null, mensagem);
   }

   public static void ehVerdade(boolean check, String mensagem) {
      if (check)
         throw new RuntimeException(mensagem);
   }
}
