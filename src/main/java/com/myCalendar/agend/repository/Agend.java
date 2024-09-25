package com.myCalendar.agend.repository;

import com.myCalendar.agend.controller.agend.AgendCreateDTO;

import java.sql.Date;
import java.sql.Time;

public class Agend {
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private Event event;

    public Agend() {
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
