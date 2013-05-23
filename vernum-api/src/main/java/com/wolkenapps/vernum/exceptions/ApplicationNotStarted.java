package com.wolkenapps.vernum.exceptions;

public class ApplicationNotStarted extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApplicationNotStarted() {
        super("Application not started. Remember to call ApplicationContext.start method!");
    }

}
