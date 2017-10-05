package org.spree.core.event;

import java.util.Calendar;

public interface Event {

    String getName();

    String getDescription();

    Calendar getStartDate();

    Calendar getFinishDate();

    String getImageUrl();

    String getExtId();

    String getSystemId();
}