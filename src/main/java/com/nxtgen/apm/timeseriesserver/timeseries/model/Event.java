package com.nxtgen.apm.timeseriesserver.timeseries.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash("EventData")
public class Event {

    @Id
    private String id;

    private String metricName;

    private LocalDateTime timeOfCollection;

    private Long metricValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public LocalDateTime getTimeOfCollection() {
        return timeOfCollection;
    }

    public void setTimeOfCollection(LocalDateTime timeOfCollection) {
        this.timeOfCollection = timeOfCollection;
    }

    public Long getMetricValue() {
        return metricValue;
    }

    public void setMetricValue(Long metricValue) {
        this.metricValue = metricValue;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", metricName='" + metricName + '\'' +
                ", timeOfCollection=" + timeOfCollection +
                ", metricValue=" + metricValue +
                '}';
    }
}
