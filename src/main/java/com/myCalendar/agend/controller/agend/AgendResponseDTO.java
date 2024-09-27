package com.myCalendar.agend.controller.agend;

import com.myCalendar.agend.repository.Event;

import java.util.Date;
import java.util.List;

public class AgendResponseDTO {
    private Date startDate;
    private List<Event> events;

    public AgendResponseDTO() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
