package com.wolkenapps.vernum.context;

import totalcross.util.Hashtable;
import totalcross.util.Vector;

import com.wolkenapps.vernum.exceptions.ApplicationNotStarted;
import com.wolkenapps.vernum.exceptions.NoBeanDefinitionFound;
import com.wolkenapps.vernum.factory.Creator;
import com.wolkenapps.vernum.factory.DefaultCreator;
import com.wolkenapps.vernum.factory.config.ApplicationContextAwareProcessor;
import com.wolkenapps.vernum.factory.config.BeanDefinition;
import com.wolkenapps.vernum.factory.config.BeanPostProcessor;
import com.wolkenapps.vernum.factory.config.BeansDefinitions;
import com.wolkenapps.vernum.factory.config.DestroyableBeanProcessor;
import com.wolkenapps.vernum.factory.config.InitializingBeanProcessor;

public class DefaultApplicationContext implements ApplicationContext {

   public final Hashtable definitions;

   public final Hashtable singletons;

   public final Vector    processors;

   private boolean        started = false;

   public DefaultApplicationContext(Hashtable definitions,
                                    Hashtable singletons,
                                    Vector processors) {
      this.definitions = definitions;
      this.singletons = singletons;
      this.processors = processors;

      register(new ApplicationContextAwareProcessor()); // defaults
      register(new InitializingBeanProcessor()); // defaults

   }

   public DefaultApplicationContext(int definitionsSize,
                                    int singletonsSize,
                                    int processorsSize) {
      this(new Hashtable(definitionsSize), new Hashtable(singletonsSize), new Vector(processorsSize));
   }

   public DefaultApplicationContext() {
      this(50, 50, 20);
   }

   public void register(BeanDefinition definition) {
      definitions.put(definition.name, definition);
   }

   public void append(BeansDefinitions beans) {
      BeanDefinition[] all = beans.get(this);
      if (all != null && all.length > 0)
         for (int i = 0, size = all.length; i < size; i++)
            register(all[i]);
   }

   public void append(BeansDefinitions[] arrayOfBeansDefinitions) {
      for (int i = 0, length = arrayOfBeansDefinitions.length; i < length; i++) {
         append(arrayOfBeansDefinitions[i]);
      }
   }

   public Object getBean(String name) {
      if (!started)
         throw new ApplicationNotStarted();
      if (!definitions.exists(name))
         throw new NoBeanDefinitionFound(name);
      BeanDefinition definition = (BeanDefinition) definitions.get(name);
      if (definition.isSingleton())
         return getSingletonOf(definition);
      return createUsing(definition);

   }

   private Object createUsing(BeanDefinition definition) {
      Object bean = creatorFor(definition).create(definition.type, this);
      postProcess(bean);
      return bean;
   }

   private Object getSingletonOf(BeanDefinition definition) {
      if (singletons.exists(definition.name))
         return singletons.get(definition.name);
      Object bean = createUsing(definition);
      singletons.put(definition.name, bean);
      return bean;
   }

   private void postProcess(Object target) {
      BeanPostProcessor processor = null;
      for (int i = 0, size = processors.items.length; i < size; i++) {
         processor = (BeanPostProcessor) processors.items[i];
         if (processor != null && processor.accepts(target)) {
            processor.process(target, this);
         }
      }
   }

   private Creator creatorFor(BeanDefinition definition) {
      return definition.getCreator() != null ? definition.getCreator() : getDefaultCreator();
   }

   private Creator getDefaultCreator() {
      return new DefaultCreator();
   }

   public Vector getBeansOfType(Class type) throws ApplicationNotStarted, NoBeanDefinitionFound {
      Vector all = definitions.getValues();
      Vector beansOfType = new Vector(all.size());
      for (int i = 0, size = all.size(); i < size; i++)
         if (((BeanDefinition) all.items[i]).type.equals(type))
            beansOfType.addElement(getBean(((BeanDefinition) all.items[i]).name));
      return beansOfType;
   }

   public void register(BeanPostProcessor processor) {
      processors.addElement(processor);
   }

   public void refresh() {
      stop();
      start();
   }

   public void start() {

      this.started = true;
   }

   public void stop() {
      new DestroyableBeanProcessor().destroy(singletons, this);
      this.started = false;
   }

   public boolean isStarted() {
      return started;
   }

}
