package com.nxtgen.apm.timeseriesserver.timeseries.controllers;

import com.nxtgen.apm.timeseriesserver.timeseries.dtos.EventData;
import com.nxtgen.apm.timeseriesserver.timeseries.service.TimeSeriesService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class HistoricalDataPointController {

    private final TimeSeriesService timeSeriesService;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HistoricalDataPointController.class);

    public HistoricalDataPointController(TimeSeriesService timeSeriesService) {
        this.timeSeriesService = timeSeriesService;
    }

    @RequestMapping(value = "/history", method =  RequestMethod.GET)
    public List<EventData> fetchEventsWithDateRange(@RequestParam("from") String from, @RequestParam("to") String to) {
        LOGGER.info("Retrieving Historical Date Points From: {} to {}",from, to);
        LocalDateTime fromDate = LocalDateTime.parse(from);
        LocalDateTime toDate = LocalDateTime.parse(to);
        return timeSeriesService.retrieveEvent(fromDate,toDate);
    }
}
