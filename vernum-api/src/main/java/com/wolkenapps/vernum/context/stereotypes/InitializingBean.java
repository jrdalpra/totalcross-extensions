package com.wolkenapps.vernum.context.stereotypes;

/**
 * Any bean that wants to be call after all properties has bean set must implement this interface
 * 
 * @author jose.junior
 * 
 */
public interface InitializingBean {

    /**
     * Called after all properties has been set (including all "Aware" interfaces).
     * 
     * Must not call "ui" code like add, paint, repaint, etc
     * 
     */
    void afterPropertiesSet();

}
