package org.spree.core.event;

import org.spree.core.category.Category;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

public class CatchedStoredEvent implements StoredEvent {

    private static final Logger LOG = Logger.getLogger(CatchedStoredEvent.class.getCanonicalName());
    private StoredEvent event;

    public CatchedStoredEvent(StoredEvent event) {
        this.event = event;
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
    public int getMembersCount() {
        return event.getMembersCount();
    }

    @Override
    public List<? extends Category> getCategories() {
        return event.getCategories();
    }

    @Override
    public double getLatitude() {
        return event.getLatitude();
    }

    @Override
    public double getLongitude() {
        return event.getLongitude();
    }

    @Override
    public void save() {
        try {
            event.save();
        } catch (Exception e) {
            LOG.warning("event saving error " + e.getMessage());
        }
    }

    @Override
    public void reread() {
        try {
            event.reread();
        } catch (Exception e) {
            LOG.warning("event reread error " + e.getMessage());
        }
    }
}
