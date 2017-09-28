package org.spree.core.parameter;

import java.util.Date;

public interface ConfigStorage {

    String getString(ParameterName key);

    Integer getInt(ParameterName key);

    Double getDouble(ParameterName key);

    Date getDate(ParameterName key);

    Object getValue(ParameterName key);

    void save(ParameterName key, String value);

    void save(ParameterName key, Date value);

    void save(ParameterName key, int value);

    void save(ParameterName key, double value);

    void save(ParameterName key, Object value);

    void remove(ParameterName parameterName);
}
