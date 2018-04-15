package com.nxtgen.apm.timeseriesserver.timeseries.repository;

import com.nxtgen.apm.timeseriesserver.timeseries.model.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, String>{
}
