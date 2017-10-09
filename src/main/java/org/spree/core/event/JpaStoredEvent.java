package org.spree.core.event;

import org.spree.core.entities.JpaEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.Calendar;

public class JpaStoredEvent implements StoredEvent {

    private JpaEvent event;
    private CrudRepository<JpaEvent, JpaEvent.EventId> repository;

    public JpaStoredEvent(JpaEvent event, CrudRepository<JpaEvent, JpaEvent.EventId> repository) {
        this.event = event;
        this.repository = repository;
    }

    @Override
    public String getName() {
        return event.getName();
    }

    @Override
    public String getDescription() {
        return event.getDescription();
    }

    @Override
    public Calendar getStartDate() {
        return event.getStartDate();
    }

    @Override
    public Calendar getFinishDate() {
        return event.getFinishDate();
    }

    @Override
    public String getImageUrl() {
        return event.getImageUrl();
    }

    @Override
    public String getExtId() {
        return event.getExtId();
    }

    @Override
    public String getSystemId() {
        return event.getSystemId();
    }

    @Override
    public void save() {
        repository.save(event);
    }

    @Override
    public void reread() {
        event = repository.findOne(event.getId());
    }
}
