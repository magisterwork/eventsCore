package org.spree.core.exception;

public class DbConfigException extends RuntimeException {

    public DbConfigException() {
        super();
    }

    public DbConfigException(String s) {
        super(s);
    }

    public DbConfigException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DbConfigException(Throwable throwable) {
        super(throwable);
    }
}
