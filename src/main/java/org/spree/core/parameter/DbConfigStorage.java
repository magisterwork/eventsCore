package org.spree.core.parameter;

import org.spree.core.exception.DbConfigException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DbConfigStorage implements ConfigStorage {

    private static final String SELECT_QUERY = "select CONFIG_VALUE from CONFIG where CONFIG_KEY = ?";
    private static final String SAVE_QUERY = "INSERT INTO CONFIG (CONFIG_KEY, CONFIG_VALUE) VALUES (?, ?)" +
            " ON DUPLICATE KEY UPDATE CONFIG_VALUE = ?";

    private JdbcTemplate jdbc;

    public DbConfigStorage(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public String getString(String key) {
        List<String> results = jdbc.queryForList(SELECT_QUERY, new Object[]{key}, String.class);
        if (results.size() != 1) {
            throw new DbConfigException("count of results of config " + key + " = " + results.size());
        }
        return results.get(0);
    }

    public int getInt(String key) {
        return 0;
    }

    public double getDouble(String key) {
        return 0;
    }

    public Object getValue(String key) {
        return null;
    }

    @Transactional
    public void save(String key, String value) {
        jdbc.update(SAVE_QUERY, key, value, key);
    }

    public void save(String key, int value) {

    }

    @Transactional
    public void save(String key, double value) {
        jdbc.update(SAVE_QUERY, key, value, key);
    }

    public void save(String key, Object value) {

    }
}
