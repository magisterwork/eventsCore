package org.spree.core.exception;

public class ExternalSystemException extends RuntimeException {

    public ExternalSystemException(String s) {
        super(s);
    }

    public ExternalSystemException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ExternalSystemException(Throwable throwable) {
        super(throwable);
    }
}
