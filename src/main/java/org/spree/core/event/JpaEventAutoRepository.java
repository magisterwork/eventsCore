package org.spree.core.event;

import org.spree.core.entities.JpaEvent;
import org.springframework.data.repository.CrudRepository;

public interface JpaEventAutoRepository extends CrudRepository<JpaEvent, JpaEvent.EventId>, EventStorage {
}
