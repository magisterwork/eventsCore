package org.spree.core.event;

import java.util.Calendar;

public interface Event {

    void save();

    String getName();

    String getDescription();

    Calendar getStartDate();

    Calendar getFinishDate();
}