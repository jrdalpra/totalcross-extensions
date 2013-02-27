package com.wolkenapps.vernum.factory;

import com.wolkenapps.vernum.context.ApplicationContext;
import com.wolkenapps.vernum.factory.Creator;

public class DefaultCreator implements Creator {

    public Object create(Class type, ApplicationContext context) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            new RuntimeException(e.getMessage());
        }
        return null;
    }

}
