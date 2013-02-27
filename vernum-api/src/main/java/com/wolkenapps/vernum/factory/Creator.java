package com.wolkenapps.vernum.factory;

import com.wolkenapps.vernum.context.ApplicationContext;

public interface Creator {

    Object create(Class type, ApplicationContext context);

}
