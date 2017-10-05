package org.spree.core.event;

import org.spree.core.storing.Stored;

import java.io.Serializable;

public interface StoredEvent extends Event, Stored, Serializable {

}
