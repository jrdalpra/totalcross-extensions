package com.wolkenapps.vernum.factory.config;

import com.wolkenapps.vernum.context.ApplicationContext;

/**
 * A set of bean definitions
 *
 * @author jose.junior
 *
 */
public interface BeansDefinitions {

    BeanDefinition[] get(ApplicationContext context);

}
