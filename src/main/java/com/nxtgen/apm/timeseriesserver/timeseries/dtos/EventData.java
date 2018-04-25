package com.nxtgen.apm.timeseriesserver.timeseries.dtos;


public class EventData {

    private Long id;

    private String metricName;

    private String timeOfCollection;

    private Long metricValue;

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public void setTimeOfCollection(String timeOfCollection) {
        this.timeOfCollection = timeOfCollection;
    }

    public void setMetricValue(Long metricValue) {
        this.metricValue = metricValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetricName() {
        return metricName;
    }

    public String getTimeOfCollection() {
        return timeOfCollection;
    }

    public Long getMetricValue() {
        return metricValue;
    }

    @Override
    public String toString() {
        return "EventData{" +
                "id='" + id + '\'' +
                ", metricName='" + metricName + '\'' +
                ", timeOfCollection='" + timeOfCollection + '\'' +
                ", metricValue=" + metricValue +
                '}';
    }
}
