package com.nxtgen.apm.timeseriesserver.timeseries;

import com.nxtgen.apm.timeseriesserver.timeseries.dtos.EventData;
import com.nxtgen.apm.timeseriesserver.timeseries.service.TimeSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private TimeSeriesService timeSeriesService;

    @RequestMapping(value = "/timeseries",method = RequestMethod.POST)
    public EventData save(@RequestBody EventData eventData) {
        return  timeSeriesService.save(eventData);
    }


    @RequestMapping(value = "/timeseries/batch-save/",method = RequestMethod.POST)
    public List<EventData> save(@RequestBody List<EventData> eventDatas) {
        timeSeriesService.save(eventDatas);
        return eventDatas;
    }

    @RequestMapping(value = "/timeseries/{id}",method = RequestMethod.GET)
    public EventData retrieveEvent(@PathVariable("id")String id) {
        return  timeSeriesService.retrieveEvent(id);
    }
}
