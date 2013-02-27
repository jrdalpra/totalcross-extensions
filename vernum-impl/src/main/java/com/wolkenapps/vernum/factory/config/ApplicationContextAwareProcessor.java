package com.wolkenapps.vernum.factory.config;

import com.wolkenapps.vernum.context.ApplicationContext;
import com.wolkenapps.vernum.context.stereotypes.ApplicationContextAware;
import com.wolkenapps.vernum.factory.config.BeanPostProcessor;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    public boolean accepts(Object target) {
        return target != null && ApplicationContextAware.class.isInstance(target);
    }

    public void process(Object target, ApplicationContext context) {
        ((ApplicationContextAware) target).setApplicationContext(context);
    }

}
