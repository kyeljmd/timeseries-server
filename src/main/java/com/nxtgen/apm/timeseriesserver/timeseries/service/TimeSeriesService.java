package com.nxtgen.apm.timeseriesserver.timeseries.service;

import com.nxtgen.apm.timeseriesserver.timeseries.dtos.EventData;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kyel on 4/15/2018.
 */
public interface TimeSeriesService {

    EventData save(EventData eventData);

    List<EventData> save(List<EventData> eventData);

    List<EventData> retrieveEvent(LocalDateTime start, LocalDateTime end, Pagination page);

    EventData retrieveEvent(String id);
}
