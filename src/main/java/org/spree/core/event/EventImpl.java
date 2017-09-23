package org.spree.core.event;

import java.util.Calendar;

public class EventImpl implements Event {

    private Long id;
    private String name;
    private String description;
    private Calendar startDate;
    private Calendar finishDate;
    private String imageUrl;

    public EventImpl(String name, String description, Calendar startDate, Calendar finishDate, String imageUrl) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getFinishDate() {
        return finishDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(Calendar finishDate) {
        this.finishDate = finishDate;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
