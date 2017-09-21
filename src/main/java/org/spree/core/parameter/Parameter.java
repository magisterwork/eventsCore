package org.spree.core.parameter;

public interface Parameter<T> {

    T value();

    void setValue(T value);
}
