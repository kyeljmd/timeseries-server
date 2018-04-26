package com.nxtgen.apm.timeseriesserver.timeseries.controllers;

import com.nxtgen.apm.timeseriesserver.timeseries.dtos.EventData;
import com.nxtgen.apm.timeseriesserver.timeseries.service.TimeSeriesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EventDataPointController {

    private final TimeSeriesService timeSeriesService;

    private static final Logger LOGGER = LogManager.getLogger(EventDataPointController.class);

    public EventDataPointController(TimeSeriesService timeSeriesService) {
        this.timeSeriesService = timeSeriesService;
    }

    @RequestMapping(value = "/timeseries",method = RequestMethod.POST)
    public EventData save(@RequestBody EventData eventData) {
        LOGGER.info("Received Request with Body : "+eventData);
        return  timeSeriesService.save(eventData);
    }

    @RequestMapping(value = "/timeseries/batch-save",method = RequestMethod.POST)
    public List<EventData> save(@RequestBody List<EventData> eventDatas) {
        LOGGER.info("Received Request with Body : "+ eventDatas);
        timeSeriesService.save(eventDatas);
        return eventDatas;
    }

    @RequestMapping(value = "/timeseries/{id}",method = RequestMethod.GET)
    public EventData retrieveEvent(@PathVariable("id")Long  id) {
        LOGGER.info("Retrieving Data Point with ID"+id);
        return  timeSeriesService.retrieveEvent(id);
    }
}
