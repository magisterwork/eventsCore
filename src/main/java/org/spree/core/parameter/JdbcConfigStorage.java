package org.spree.core.parameter;

import org.spree.core.exception.DbConfigException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class JdbcConfigStorage implements ConfigStorage {

    private final static Logger LOG = Logger.getLogger(JdbcConfigStorage.class.getCanonicalName());
    private static final String SELECT_QUERY = "select CONFIG_VALUE from CONFIG where CONFIG_KEY = ?";
    private static final String SAVE_QUERY = "INSERT INTO CONFIG (CONFIG_KEY, CONFIG_VALUE) VALUES (?, ?)" +
            " ON DUPLICATE KEY UPDATE CONFIG_VALUE = ?";
    private static final String DELETE_QUERY = "delete from CONFIG_VALUE where CONFIG_KEY = ?";

    private JdbcTemplate jdbc;
    private SimpleDateFormat dateFormat;

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
        List<String> results = jdbc.queryForList(SELECT_QUERY, new Object[]{parameter.name()}, String.class);
        if (results.size() != 1) {
            return null;
        }
        return Integer.valueOf(results.get(0));
    }

    public Double getDouble(ParameterName key) {
        return null;
    }

    public Date getDate(ParameterName key) {
        dateFormat = new SimpleDateFormat();
        try {
            return dateFormat.parse(getString(key));
        } catch (ParseException e) {
            throw new DbConfigException(e);
        }
    }

    public Object getValue(ParameterName key) {
        return null;
    }

    @Transactional
    public void save(ParameterName parameter, String value) {
        LOG.info("saving parameter " + parameter + " with value " + value);
        jdbc.update(SAVE_QUERY, parameter.name(), value, value);
    }

    public void save(ParameterName key, Date value) {
        LOG.info("saving parameter " + key + " with value " + value);
        jdbc.update(SAVE_QUERY, key.name(), value.toString(), key.name());
    }

    public void save(ParameterName parameter, int value) {

    }

    public void save(ParameterName parameter, double value) {

    }

    public void save(ParameterName parameter, Object value) {
        LOG.info("saving parameter " + parameter + " with value " + value);
        jdbc.update(SAVE_QUERY, parameter.name(), value, value);
    }

    public void remove(ParameterName parameterName) {
        jdbc.update(DELETE_QUERY, parameterName.name());
    }

}
