package com.wolkenapps.vernum.factory.config;

import com.wolkenapps.vernum.factory.Creator;
import com.wolkenapps.vernum.utils.ClassUtils;

/**
 * Holds a definitions to create beans
 * 
 * @author jose.junior
 * 
 */
public class BeanDefinition {

    public static final String SCOPE_PROTOTYPE = "prototype";

    public static final String SCOPE_SINGLETON = "singleton";

    public final String        name;

    public final String        scope;

    public final Class         type;

    private Creator            creator;

    public BeanDefinition(String name, String scope, Class type) {
        this.name = name;
        this.scope = scope;
        this.type = type;
    }

    public BeanDefinition(String name, String scope, String type) {
        this(name, scope, ClassUtils.silentLoad(type));
    }

    public BeanDefinition(String name, String scope, Class type, Creator creator) {
        this(name, scope, type);
        this.creator = creator;
    }

    public BeanDefinition(String name, String scope, String type, Creator creator) {
        this(name, scope, type);
        this.creator = creator;
    }

    public boolean isPrototype() {
        return scope != null && scope.equalsIgnoreCase(SCOPE_PROTOTYPE);
    }

    public boolean isSingleton() {
        return scope != null && scope.equalsIgnoreCase(SCOPE_SINGLETON);
    }

    public Creator getCreator() {
        return creator;
    }

}
