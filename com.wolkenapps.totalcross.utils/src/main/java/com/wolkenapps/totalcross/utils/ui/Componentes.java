package com.wolkenapps.totalcross.utils.ui;

import totalcross.ui.Button;
import totalcross.ui.Control;
import totalcross.ui.ToolTip;

public class Componentes {

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
