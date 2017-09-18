package org.spree.core.parameter;

public interface Parameter<T> {

    T getValue();

    void setValue(T value);
}
