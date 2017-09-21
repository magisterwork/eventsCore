package org.spree.core.parameter;

public interface ConfigStorage {

    String getString(String key);

    int getInt(String key);

    double getDouble(String key);

    Object getValue(String key);

    void save(String key, String value);

    void save(String key, int value);

    void save(String key, double value);

    void save(String key, Object value);
}
