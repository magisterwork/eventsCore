package org.spree.core.event;

import org.spree.core.category.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Deprecated
public class JdbcEvent implements StoredEvent {

    private final String UPDATE_QUERY = "UPDATE EVENTS SET name = :name, description = :desctiption, start_time = : startDate," +
            " finish_time = :finishTime, image_url = :imageUrl, ext_id = :extId, system_id = :externalSystemId";
    private final static Logger LOG = Logger.getLogger(JdbcEvent.class.getCanonicalName());


    private JdbcTemplate jdbc;
    private Event event;

    public JdbcEvent(JdbcTemplate jdbc, Event event) {
        this.jdbc = jdbc;
        this.event = event;
    }

    @Transactional
    public void save() {
        LOG.info("saving event" + toString());
        jdbc.update(UPDATE_QUERY,
                event.getName(),
                event.getDescription(),
                event.getStartDate(),
                event.getFinishDate(),
                event.getImageUrl(),
                event.getExtId(),
                event.getSystemId());

    }

    public void reread() {

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

    @Override
    public int getMembersCount() {
        return 0;
    }

    @Override
    public List<Category> getCategories() {
        return Collections.emptyList();
    }
}
