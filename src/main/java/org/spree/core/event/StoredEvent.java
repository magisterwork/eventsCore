package org.spree.core.event;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

public class StoredEvent implements Event {

    private final String SAVE_QUERY = "insert into EVENTS (NAME, DESC) VALUES (?, ?)" +
            " ON DUPLICATE KEY UPDATE CONFIG_VALUE = ?";

    private JdbcTemplate jdbc;

    public StoredEvent(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Transactional
    public void save() {
        jdbc.update(SAVE_QUERY)
    }

    public String getName() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public Calendar getStartDate() {
        return null;
    }

    public Calendar getFinishDate() {
        return null;
    }
}
