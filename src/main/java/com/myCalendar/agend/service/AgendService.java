package com.myCalendar.agend.service;

import com.myCalendar.agend.controller.agend.DTO.AgendCreateDTO;
import com.myCalendar.agend.controller.agend.DTO.AgendResponseDTO;
import com.myCalendar.agend.repository.Agend;

public interface AgendService {

    Agend save(AgendCreateDTO agendCreateDTO);

    void update(String idEvent);

    void delete(String idEvent);

    AgendResponseDTO getAllAgendOfNextDays();

    AgendResponseDTO getAgendOfPreviusDays(Integer numberOfDays);

    AgendResponseDTO getAgendOfNextDays(Integer numberOfDays);

}
