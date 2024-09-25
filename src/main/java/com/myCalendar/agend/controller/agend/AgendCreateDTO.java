package com.myCalendar.agend.controller.agend;

import com.myCalendar.agend.controller.event.EventCreateDTO;

import java.sql.Date;
import java.sql.Time;

public class AgendCreateDTO {

    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private EventCreateDTO eventDTO;

    public AgendCreateDTO() {
    }


    public EventCreateDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventCreateDTO eventDTO) {
        this.eventDTO = eventDTO;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


}
