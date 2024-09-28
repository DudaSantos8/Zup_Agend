package com.myCalendar.agend.controller.agend.DTO;

import com.myCalendar.agend.controller.event.EventCreateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.time.LocalDate;

public class AgendCreateDTO {

    @NotNull(message = "This field cannot be null ")
    private LocalDate startDate;

    @NotNull(message = "This field cannot be null ")
    private LocalDate endDate;

    @NotNull(message = "This field cannot be null ")
    private Time startTime;

    @NotNull(message = "This field cannot be null ")
    private Time endTime;

    @NotNull(message = "The event cannot be null")
    @Valid
    private EventCreateDTO event;

    public AgendCreateDTO() {
    }


    public EventCreateDTO getEvent() {
        return event;
    }

    public void setEvent(EventCreateDTO eventDTO) {
        this.event = eventDTO;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


}
