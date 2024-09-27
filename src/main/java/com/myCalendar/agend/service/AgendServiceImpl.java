package com.myCalendar.agend.service;

import com.myCalendar.agend.controller.agend.AgendCreateDTO;
import com.myCalendar.agend.controller.agend.AgendResponseDTO;
import com.myCalendar.agend.repository.Agend;
import com.myCalendar.agend.service.mapper.AgendMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AgendServiceImpl implements AgendService{

    List<Agend> agendList = new ArrayList<>();

    @Override
    public Agend save(AgendCreateDTO agendCreateDTO) {
        Agend agend = AgendMapper.createEvent(agendCreateDTO);
        agendList.add(agend);
        return agend;
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
    public AgendResponseDTO getAllAgendOfNextDays(Integer numberOfDays) {
        return AgendMapper.getAllAgendOfNextDays(numberOfDays, agendList);
    }

    @Override
    public AgendResponseDTO getAgendOfPreviusDays(Integer numberOfDays) {
        return AgendMapper.getAgendOfPreviusDays(numberOfDays, agendList);    }

    @Override
    public AgendResponseDTO getAgendOfNextDays(Integer numberOfDays) {
        return AgendMapper.getAgendOfNextDays(numberOfDays, agendList);
    }

}