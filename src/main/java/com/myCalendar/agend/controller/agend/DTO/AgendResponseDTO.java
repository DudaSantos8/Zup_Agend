package com.myCalendar.agend.controller.agend.DTO;

import com.myCalendar.agend.repository.Event;

import java.time.LocalDate;
import java.util.List;

public class AgendResponseDTO {
    private LocalDate startDate;
    private List<Event> events;

    public AgendResponseDTO() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
