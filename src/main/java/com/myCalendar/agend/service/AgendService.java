package com.myCalendar.agend.service;

import com.myCalendar.agend.controller.agend.AgendCreateDTO;
import com.myCalendar.agend.controller.agend.AgendResponseDTO;
import com.myCalendar.agend.repository.Agend;

import java.text.ParseException;
import java.util.List;

public interface AgendService {

    void save(AgendCreateDTO agendCreateDTO);

    void update(String idEvent);

    void delete(String idEvent);

    List<Agend> getAllAgend();

    AgendResponseDTO getAgendByDate(String startDate);
}
