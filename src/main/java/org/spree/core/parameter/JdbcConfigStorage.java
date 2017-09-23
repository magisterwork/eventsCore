package org.spree.core.parameter;

import org.spree.core.exception.DbConfigException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JdbcConfigStorage implements ConfigStorage {

    private static final String SELECT_QUERY = "select CONFIG_VALUE from CONFIG where CONFIG_KEY = ?";
    private static final String SAVE_QUERY = "INSERT INTO CONFIG (CONFIG_KEY, CONFIG_VALUE) VALUES (?, ?)" +
            " ON DUPLICATE KEY UPDATE CONFIG_VALUE = ?";

    private JdbcTemplate jdbc;

    public JdbcConfigStorage(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public String getString(ParameterName parameter) {
        List<String> results = jdbc.queryForList(SELECT_QUERY, new Object[]{parameter.name()}, String.class);
        if (results.size() != 1) {
            return null;
        }
        return results.get(0);
    }

    public Integer getInt(ParameterName parameter) {
        List<Integer> results = jdbc.queryForList(SELECT_QUERY, new Object[]{parameter.name()}, Integer.class);
        if (results.size() != 1) {
            return null;
        }
        return results.get(0);
    }

    public Double getDouble(ParameterName key) {
        return null;
    }

    public Object getValue(ParameterName key) {
        return null;
    }

    @Transactional
    public void save(ParameterName parameter, String value) {
        jdbc.update(SAVE_QUERY, parameter.name(), value, parameter.name());
    }

    public void save(ParameterName parameter, int value) {

    }

    public void save(ParameterName parameter, double value) {

    }

    public void save(ParameterName parameter, Object value) {
        jdbc.update(SAVE_QUERY, parameter.name(), value, parameter.name());
    }

}
