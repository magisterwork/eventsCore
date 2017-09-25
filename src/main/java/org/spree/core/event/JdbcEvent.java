package org.spree.core.event;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

public class JdbcEvent implements StoredEvent {

    private final String INSERT_QUERY = "REPLACE EVENTS (name, description, start_time, finish_time, image_url, ext_id, ext_system_id) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_QUERY = "insert into EVENTS (name, description, start_time, finish_time, image_url) "
            + "VALUES (:name, :description, :startTime, :finishTime, :imageUrl)";

    private JdbcTemplate jdbc;
    private Event event;

    public JdbcEvent(JdbcTemplate jdbc, Event event) {
        this.jdbc = jdbc;
        this.event = event;
    }

    @Transactional
    public void save() {
        if (event.getId() == null) {
            jdbc.update(INSERT_QUERY,
                    event.getName(),
                    event.getDescription(),
                    event.getStartDate(),
                    event.getFinishDate(),
                    event.getImageUrl());
        } else {
            jdbc.update(UPDATE_QUERY,
                    event.getName(),
                    event.getDescription(),
                    event.getStartDate(),
                    event.getFinishDate(),
                    event.getImageUrl());
        }
    }

    public void reread() {

    }

    public Long getId() {
        return event.getId();
    }

    public String getName() {
        return event.getName();
    }

    public String getDescription() {
        return event.getDescription();
    }

    public Calendar getStartDate() {
        return event.getStartDate();
    }

    public Calendar getFinishDate() {
        return event.getFinishDate();
    }

    public String getImageUrl() {
        return getImageUrl();
    }

    public String getExtId() {
        return event.getExtId();
    }

    public String getSystemId() {
        return event.getSystemId();
    }
}
