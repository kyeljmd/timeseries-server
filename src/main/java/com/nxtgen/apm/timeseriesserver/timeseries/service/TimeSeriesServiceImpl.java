package com.nxtgen.apm.timeseriesserver.timeseries.service;

import com.nxtgen.apm.timeseriesserver.timeseries.dtos.EventData;
import com.nxtgen.apm.timeseriesserver.timeseries.model.Event;
import com.nxtgen.apm.timeseriesserver.timeseries.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class TimeSeriesServiceImpl implements TimeSeriesService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventData save(EventData eventData) {
        LocalDateTime timeOfCollection = LocalDateTime.parse(eventData.getTimeOfCollection());
        Event event = new Event();
        event.setMetricName(eventData.getMetricName());
        event.setMetricValue(eventData.getMetricValue());
        event.setTimeOfCollection(timeOfCollection);
        Event eventModel = eventRepository.save(event);
        return eventData;
    }

    @Override
    public List<EventData> save(List<EventData> eventList) {

        List<Event> events = eventList
                .stream()
                .map(eventData -> {
                    LocalDateTime timeOfCollection = LocalDateTime
                                    .parse(eventData.getTimeOfCollection());
                    Event event = new Event();
                    event.setMetricName(eventData.getMetricName());
                    event.setMetricValue(eventData.getMetricValue());
                    event.setTimeOfCollection(timeOfCollection);
                    return event;
                })
                .collect(Collectors.toList());

        eventRepository.saveAll(events);

        return eventList;
    }

    //TODO
    @Override
    public List<EventData> retrieveEvent(LocalDateTime start, LocalDateTime end, Pagination page) {
        return null;
    }

    @Override
    public EventData retrieveEvent(String id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            Event e = event.get();
            EventData eventData = new EventData();
            eventData.setId(e.getId());
            eventData.setMetricName(e.getMetricName());
            eventData.setTimeOfCollection(e.getTimeOfCollection().toString());
            eventData.setMetricValue(e.getMetricValue());
            System.out.println("Retrieved object: " + e);
            return eventData;
        } else {
            return new EventData();
        }
    }
}
