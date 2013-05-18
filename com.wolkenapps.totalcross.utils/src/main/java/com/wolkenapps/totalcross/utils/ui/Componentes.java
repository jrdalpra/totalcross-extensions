package com.wolkenapps.totalcross.utils.ui;

import totalcross.ui.Button;
import totalcross.ui.Control;
import totalcross.ui.ToolTip;
import totalcross.ui.dialog.MessageBox;

public class Componentes {

   public static class Mensagem {

      /**
       * Retora a resposta a pergunta
       *
       * @param titulo
       * @param mensagem
       * @return true quando reponser sim e false quando response nao
       */
      public static boolean fazPergunta(String titulo, String mensagem) {
         MessageBox tela = new MessageBox(titulo, mensagem, new String[] { "Sim", "Não" });
         tela.popup();
         return tela.getPressedButtonIndex() == 0;
      }

   }

   public static int retornaAMaiorAlturaEntreOsControles(Control[] controles) {
      int maior = 0;
      for (int atual = 0, tamanho = controles.length; atual < tamanho; atual++)
         maior = Math.max(maior, controles[atual].getPreferredHeight());
      return maior;
   }

   public static void defineOToolTipParaOControle(Button controle, String mensagem) {
      new ToolTip(controle, mensagem);
   }

}
