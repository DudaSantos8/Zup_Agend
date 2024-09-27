package com.myCalendar.agend.controller.event;

import com.myCalendar.agend.repository.Event;

import java.util.Date;

public class EventResponseDTO {
    private Date startDate;
    private Event events;

    public EventResponseDTO() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Event getEvents() {
        return events;
    }

    public void setEvents(Event events) {
        this.events = events;
    }
}
