package com.myCalendar.agend.controller.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;

public class EventCreateDTO {

    private String idEvent;

    @NotBlank(message = "This field cannot be blank")
    @NotNull(message = "This field cannot be null ")
    private String nameEvent;

    @NotBlank(message = "This field cannot ne blank")
    @NotNull(message = "This field cannot be null ")
    private String description;

    private Time startTime;
    private boolean activeEvent;

    public EventCreateDTO() {
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public boolean isActiveEvent() {
        return activeEvent;
    }

    public void setActiveEvent(boolean activeEvent) {
        this.activeEvent = activeEvent;
    }
}
