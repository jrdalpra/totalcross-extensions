package com.wolkenapps.vernum.factory.config;

import com.wolkenapps.vernum.context.ApplicationContext;
import com.wolkenapps.vernum.context.stereotypes.InitializingBean;

public class InitializingBeanProcessor implements BeanPostProcessor {

    public boolean accepts(Object target) {
        return target != null && InitializingBean.class.isInstance(target);
    }

    public void process(Object target, ApplicationContext context) {
        ((InitializingBean) target).afterPropertiesSet();
    }

}
