package org.spree.core.event;

import org.spree.core.category.Category;

import java.util.Calendar;
import java.util.List;

public interface Event {

    String getName();

    String getDescription();

    Calendar getStartDate();

    Calendar getFinishDate();

    String getImageUrl();

    String getExtId();

    String getSystemId();

    int getMembersCount();

    List<? extends Category> getCategories();
}