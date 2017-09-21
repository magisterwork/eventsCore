package org.spree.core.event;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcEventStorage implements EventStorage {

    public JdbcEventStorage(JdbcTemplate jdbc) {
    }

    public void save(Event event) {
        event.save();
    }
}
