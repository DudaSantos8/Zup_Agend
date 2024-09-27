package com.myCalendar.agend.service;

import com.myCalendar.agend.controller.agend.AgendCreateDTO;
import com.myCalendar.agend.controller.agend.AgendResponseDTO;
import com.myCalendar.agend.repository.Agend;

public interface AgendService {

    Agend save(AgendCreateDTO agendCreateDTO);

    void update(String idEvent);

    void delete(String idEvent);

    AgendResponseDTO getAllAgendOfNextDays(Integer numberOfDays);

    AgendResponseDTO getAgendOfPreviusDays(Integer numberOfDays);

    AgendResponseDTO getAgendOfNextDays(Integer numberOfDays);

}
