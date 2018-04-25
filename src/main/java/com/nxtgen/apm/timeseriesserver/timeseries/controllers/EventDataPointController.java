package com.nxtgen.apm.timeseriesserver.timeseries.controllers;

import com.nxtgen.apm.timeseriesserver.timeseries.dtos.EventData;
import com.nxtgen.apm.timeseriesserver.timeseries.service.TimeSeriesService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EventDataPointController {


    private final TimeSeriesService timeSeriesService;

    public EventDataPointController(TimeSeriesService timeSeriesService) {
        this.timeSeriesService = timeSeriesService;
    }

    @RequestMapping(value = "/timeseries",method = RequestMethod.POST)
    public EventData save(@RequestBody EventData eventData) {
        return  timeSeriesService.save(eventData);
    }

    @RequestMapping(value = "/timeseries/batch-save",method = RequestMethod.POST)
    public List<EventData> save(@RequestBody List<EventData> eventDatas) {
        timeSeriesService.save(eventDatas);
        return eventDatas;
    }

    @RequestMapping(value = "/timeseries/{id}",method = RequestMethod.GET)
    public EventData retrieveEvent(@PathVariable("id")Long  id) {
        return  timeSeriesService.retrieveEvent(id);
    }
}
