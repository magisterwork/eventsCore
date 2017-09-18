package org.spree.core.event;

import java.util.Collection;

public interface EventSource<T extends Event> {

    Collection<T> getNew();
}
