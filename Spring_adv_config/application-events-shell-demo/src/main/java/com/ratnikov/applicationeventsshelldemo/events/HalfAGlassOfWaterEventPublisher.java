package com.ratnikov.applicationeventsshelldemo.events;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HalfAGlassOfWaterEventPublisher implements EventsPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publish() {
        publisher.publishEvent(new HalfAGlassOfWaterEvent(this));
    }
}