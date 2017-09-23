package org.spree.core.event;

import java.util.Calendar;

public interface Event {

    Long getId();

    String getName();

    String getDescription();

    Calendar getStartDate();

    Calendar getFinishDate();

    String getImageUrl();
}