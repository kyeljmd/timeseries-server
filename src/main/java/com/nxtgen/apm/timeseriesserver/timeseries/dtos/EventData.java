package com.nxtgen.apm.timeseriesserver.timeseries.dtos;


public class EventData {

    private String id;

    private String metricName;

    private String timeOfCollection;

    private Long metricValue;

    public void setId(String id) {
        this.id = id;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public void setTimeOfCollection(String timeOfCollection) {
        this.timeOfCollection = timeOfCollection;
    }

    public void setMetricValue(Long metricValue) {
        this.metricValue = metricValue;
    }

    public String getId() {
        return id;
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
