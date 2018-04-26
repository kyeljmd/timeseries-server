package com.nxtgen.apm.timeseriesserver.timeseries.service;

import com.nxtgen.apm.timeseriesserver.timeseries.dtos.EventData;
import com.nxtgen.apm.timeseriesserver.timeseries.model.Event;
import com.nxtgen.apm.timeseriesserver.timeseries.repository.EventRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class TimeSeriesServiceImpl implements TimeSeriesService {

    private final EventRepository eventRepository;

    private static final Logger LOGGER = LogManager.getLogger(TimeSeriesServiceImpl.class);

    public TimeSeriesServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventData save(EventData eventData) {
        LOGGER.info("Parsing Data Point Time Of Collection: {}", eventData.getTimeOfCollection());

        LocalDateTime timeOfCollection = LocalDateTime.parse(eventData.getTimeOfCollection());
        Event event = new Event();
        event.setMetricName(eventData.getMetricName());
        event.setMetricValue(eventData.getMetricValue());
        event.setTimeOfCollection(timeOfCollection);

        Event eventModel = eventRepository.save(event);
        LOGGER.info("Successfully Saved Event Data Point {}", eventModel);
        eventData.setId(eventModel.getId());
        return eventData;
    }

    @Override
    public List<EventData> save(List<EventData> eventList) {
        LOGGER.info("Saving {} Batch Event Data Points", eventList.size());
        List<Event> events = eventList
                .stream()
                .map(eventData -> {
                    LOGGER.debug("Converting EventDataDTO = {} to Entity Model", eventData);
                    LocalDateTime timeOfCollection = LocalDateTime.parse(eventData.getTimeOfCollection());
                    Event event = new Event();
                    event.setMetricName(eventData.getMetricName());
                    event.setMetricValue(eventData.getMetricValue());
                    event.setTimeOfCollection(timeOfCollection);
                    LOGGER.debug("Successfully Converted DTO = {} to Model = {}",eventData, event);
                    return event;
                })
                .collect(Collectors.toList());
        List<Event> eventResult = eventRepository.saveAll(events);
        LOGGER.info("Successfully Saved {} items Event Data Points", eventResult.size());
        return eventList;
    }

    @Override
    public List<EventData> retrieveEvent(LocalDateTime start, LocalDateTime end) {
        List<Event> events = eventRepository.findByTimeOfCollectionBetween(end,start);
        return events.stream().map(e -> {
            LOGGER.debug("Converting Event Data Model to DTO");
            EventData eventData = new EventData();
            eventData.setId(e.getId());
            eventData.setMetricName(e.getMetricName());
            eventData.setTimeOfCollection(e.getTimeOfCollection().toString());
            eventData.setMetricValue(e.getMetricValue());
            LOGGER.debug("Successfuly Converted {} to {}",e,eventData);
            return eventData;
        }).collect(Collectors.toList());
    }

    @Override
    public EventData retrieveEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            Event e = event.get();
            LOGGER.debug("Converting Event Data Model to DTO");
            EventData eventData = new EventData();
            eventData.setId(e.getId());
            eventData.setMetricName(e.getMetricName());
            eventData.setTimeOfCollection(e.getTimeOfCollection().toString());
            eventData.setMetricValue(e.getMetricValue());
            LOGGER.debug("Successfully Converted {} to {}",e,eventData);
            return eventData;
        } else {
            return new EventData();
        }
    }
}
