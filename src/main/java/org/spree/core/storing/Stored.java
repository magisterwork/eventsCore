package org.spree.core.storing;

public interface Stored<T> {

    void save();

    void reread();
}
