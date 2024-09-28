package com.myCalendar.agend.service;

import com.myCalendar.agend.controller.agend.DTO.AgendCreateDTO;
import com.myCalendar.agend.controller.agend.DTO.AgendResponseDTO;

public interface AgendService {

    void save(AgendCreateDTO agendCreateDTO);

    void update(String idEvent);

    void delete(String idEvent);

    AgendResponseDTO getAllAgendOfNextDays();

    AgendResponseDTO getAgendOfPreviusDays(Integer numberOfDays);

    AgendResponseDTO getAgendOfNextDays(Integer numberOfDays);

    AgendResponseDTO getAllEventsByActivation(String activeEvent);
}
