package org.spree.core.external;

import org.spree.core.event.Event;
import org.spree.core.event.EventSource;

public interface ExternalEventSource<T extends Event> extends ExternalSystem, EventSource<T> {
}
