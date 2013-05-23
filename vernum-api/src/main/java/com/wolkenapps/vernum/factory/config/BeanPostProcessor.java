package com.wolkenapps.vernum.factory.config;

import com.wolkenapps.vernum.context.ApplicationContext;

public interface BeanPostProcessor {

    boolean accepts(Object target);

    void process(Object target, ApplicationContext context);

}
