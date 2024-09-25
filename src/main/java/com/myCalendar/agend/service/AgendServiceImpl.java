package com.myCalendar.agend.service;

import com.myCalendar.agend.controller.agend.AgendCreateDTO;
import com.myCalendar.agend.controller.agend.AgendResponseDTO;
import com.myCalendar.agend.repository.Agend;
import com.myCalendar.agend.service.mappers.AgendMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class AgendServiceImpl implements AgendService{

    List<Agend> agendList = new ArrayList<>();

    @Override
    public void save(AgendCreateDTO agendCreateDTO) {
        Agend agend = AgendMapper.createEvent(agendCreateDTO);
        agendList.add(agend);
    }

    @Override
    public void update(String idEvent) {
        Agend agend = AgendMapper.activationEvent(idEvent, agendList);
    }

    @Override
    public void delete(String idEvent) {
        AgendMapper.deleteEvent(idEvent, agendList);
    }

    @Override
    public List<Agend> getAllAgend() {
        return agendList;
    }

    @Override
    public AgendResponseDTO getAgendByDate(String startDate){
        return AgendMapper.getAgendByDate(startDate, agendList);
    }
}