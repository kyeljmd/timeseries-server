package com.nxtgen.apm.timeseriesserver.timeseries.repository;

import com.nxtgen.apm.timeseriesserver.timeseries.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByTimeOfCollectionBetween(LocalDateTime from, LocalDateTime to);
}
