package com.wolkenapps.vernum.context.stereotypes;

/**
 * Any bean that wants to be noticed on context destruction must implement this interface. The bean must be a SINGLETON.
 * 
 * @author jose.junior
 * 
 */
public interface DestroyableBean {

    /**
     * Call before the application context destruction. Good to release resources.
     */
    void destroy();

}
