package com.wolkenapps.vernum.factory.config;

import totalcross.util.Hashtable;

import com.wolkenapps.vernum.context.ApplicationContext;
import com.wolkenapps.vernum.context.stereotypes.DestroyableBean;

public class DestroyableBeanProcessor {

   private boolean accepts(Object target) {
      return target != null && target instanceof DestroyableBean;
   }

   public void destroy(Hashtable beans, ApplicationContext context) {
      Object any = null;
      for (int i = 0, size = beans.size(); i < size; i++) {
         any = beans.get(i);
         if (accepts(any))
            ((DestroyableBean) any).destroy();
      }
   }

}
