package org.spree.core.parameter;

public interface ConfigStorage {

    String getString(ParameterName key);

    Integer getInt(ParameterName key);

    Double getDouble(ParameterName key);

    Object getValue(ParameterName key);

    void save(ParameterName key, String value);

    void save(ParameterName key, int value);

    void save(ParameterName key, double value);

    void save(ParameterName key, Object value);
}
