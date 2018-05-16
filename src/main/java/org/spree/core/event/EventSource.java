package org.spree.core.event;

public interface EventSource<T extends Event> {

    Iterable<T> getNew();
}
