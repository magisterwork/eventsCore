package org.spree.core.entities;

import org.spree.core.event.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "EVENTS", schema = "events")
@IdClass(JpaEvent.EventId.class)
public class JpaEvent implements Event {

    private String name;
    private String description;
    @Column(name = "start_time")
    private Calendar startDate;
    @Column(name = "finish_time")
    private Calendar finishDate;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "ext_id")
    @Id
    private String extId;
    @Column(name = "system_id")
    @Id
    private String systemId;

    public JpaEvent(Event event) {
        this.name = event.getName();
        this.description = event.getDescription();
        this.startDate = event.getStartDate();
        this.finishDate = event.getFinishDate();
        this.imageUrl = event.getImageUrl();
        this.extId = event.getExtId();
        this.systemId = event.getSystemId();
    }

    public EventId getId() {
        return new EventId(extId, systemId);
    }



    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    @Override
    public Calendar getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Calendar finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    @Override
    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public class EventId implements Serializable {

        private String systemId;
        private String extId;

        public EventId(String extId, String systemId) {
            this.extId = extId;
            this.systemId = systemId;
        }

        public String getSystemId() {
            return systemId;
        }

        public void setSystemId(String systemId) {
            this.systemId = systemId;
        }

        public String getExtId() {
            return extId;
        }

        public void setExtId(String extId) {
            this.extId = extId;
        }
    }
}
