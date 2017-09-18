package org.spree.core.parameter;

public interface ParameterStorage {

    Parameter get(String key);

    String getValue(String key);

    void updateValue(String key, String value);
}
