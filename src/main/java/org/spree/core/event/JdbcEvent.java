package org.spree.core.event;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

public class JdbcEvent implements StoredEvent {

    private final String INSERT_QUERY = "insert into EVENTS (name, description, start_time, finish_time, image_url) "
            + "VALUES (:name, :description, :startTime, :finishTime, :imageUrl)";
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
        Object[] params = {
                event.getName(),
                event.getDescription(),
                event.getStartDate(),
                event.getFinishDate(),
                event.getImageUrl()
        };
        if (event.getId() == null) {
            jdbc.update(INSERT_QUERY, params);
        } else {
            jdbc.update(UPDATE_QUERY, params);
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
}
