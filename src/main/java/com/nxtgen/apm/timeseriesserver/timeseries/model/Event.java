package com.nxtgen.apm.timeseriesserver.timeseries.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "Event_Datas")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metric_name")
    private String metricName;

    @Column(name = "time_of_collection")
    private LocalDateTime timeOfCollection;

    @Column(name = "metric_value")
    private Long metricValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
