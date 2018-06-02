package org.spree.core.event;

import org.springframework.util.StringUtils;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class NotEmptyDescriptionEventSource<T extends Event> implements EventSource<T> {

    private final EventSource<T> inner;

    public NotEmptyDescriptionEventSource(EventSource<T> inner) {
        this.inner = inner;
    }

    @Override
    public Iterable<T> getNew() {
        return StreamSupport.stream(inner.getNew().spliterator(), false)
                .filter(new Predicate<T>() {
                    @Override
                    public boolean test(T t) {
                        return !StringUtils.isEmpty(t.getDescription());
                    }
                }).collect(Collectors.toList());
    }
}
