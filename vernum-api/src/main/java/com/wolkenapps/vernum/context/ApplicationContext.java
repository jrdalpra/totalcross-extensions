package com.wolkenapps.vernum.context;

import totalcross.util.Vector;

import com.wolkenapps.vernum.exceptions.ApplicationNotStarted;
import com.wolkenapps.vernum.exceptions.NoneBeanDefinitionFound;
import com.wolkenapps.vernum.factory.config.BeanDefinition;
import com.wolkenapps.vernum.factory.config.BeansDefinitions;
import com.wolkenapps.vernum.factory.config.BeanPostProcessor;

/**
 * Based on Spring ApplicationContext
 * 
 * @author jose.junior
 * 
 */
public interface ApplicationContext {

    /**
     * Just a holder for current application context
     * 
     * @author jose.junior
     * 
     */
    public static final class Current {

        private static ApplicationContext CONTEXT;

        public static final ApplicationContext get() {
            return CONTEXT;
        }

        public static final ApplicationContext set(ApplicationContext context) {
            CONTEXT = context;
            return context;
        }

    }

    /**
     * Register a new bean managed by application context
     * 
     * @param definition bean definition
     */
    void register(BeanDefinition definition);

    /**
     * Append a set of bean definitions
     * 
     * @param beans definitions
     */
    void append(BeansDefinitions beansDefinitions);

    /**
     * Append array containing a set of bean definitions
     * 
     * @param array of beans definitions
     */
    void append(BeansDefinitions[] arrayOfBeansDefinitions);

    /**
     * Returns a bean instance
     * 
     * @param name bean name
     * @return instance based on {@link BeanDefinition}
     */
    Object getBean(String name) throws ApplicationNotStarted, NoneBeanDefinitionFound;

    /**
     * Returns all beans of type
     * 
     * @param type desired type
     * @return beans of desired type
     */
    Vector getBeansOfType(Class type) throws ApplicationNotStarted, NoneBeanDefinitionFound;

    /**
     * Register a bean post processor at end of processor lists
     * 
     * @param processor
     */
    void register(BeanPostProcessor processor);

    /**
     * Stops all beans and start this application context again
     */
    void refresh();

    /**
     * Starts this application context
     */
    void start();

    /**
     * Stops this application context. Also calls all stoppable
     */
    void stop();

}
