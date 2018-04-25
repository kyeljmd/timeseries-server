package com.nxtgen.apm.timeseriesserver.timeseries;

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
public class Controller {

    @Autowired
    private TimeSeriesService timeSeriesService;

    @RequestMapping(value = "/timeseries",method = RequestMethod.POST)
    public EventData save(@RequestBody EventData eventData) {
        return  timeSeriesService.save(eventData);
    }

    @RequestMapping(value = "/timeseries/batch-save",method = RequestMethod.POST)
    public List<EventData> save(@RequestBody List<EventData> eventDatas) {
        timeSeriesService.save(eventDatas);
        return eventDatas;
    }


    @RequestMapping(value = "/history", method =  RequestMethod.GET)
    public List<EventData> fetchEventsWithDateRange(@RequestParam("to") String to, @RequestParam("from") String from) {
        LocalDateTime toDate = LocalDateTime.parse(to);
        LocalDateTime fromDate = LocalDateTime.parse(from);
        return timeSeriesService.retrieveEvent(toDate,fromDate);
    }


    @RequestMapping(value = "/timeseries/{id}",method = RequestMethod.GET)
    public EventData retrieveEvent(@PathVariable("id")Long  id) {
        return  timeSeriesService.retrieveEvent(id);
    }
}
