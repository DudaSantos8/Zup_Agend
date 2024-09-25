package com.myCalendar.agend.controller.agend;

import com.myCalendar.agend.repository.Event;

import java.util.Date;
import java.util.List;

public class AgendResponseDTO {
    private Date dataInicio;
    private List<Event> events;

    public AgendResponseDTO() {
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
