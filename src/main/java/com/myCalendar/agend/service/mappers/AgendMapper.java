package com.myCalendar.agend.service.mappers;

import com.myCalendar.agend.controller.agend.AgendCreateDTO;
import com.myCalendar.agend.controller.agend.AgendResponseDTO;
import com.myCalendar.agend.repository.Agend;
import com.myCalendar.agend.repository.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

import java.util.*;

public class AgendMapper {

    public static Agend createEvent(AgendCreateDTO agendCreateDTO){
        Event newEvent = new Event();
        Agend newAgend = new Agend();

        newAgend.setStartDate(agendCreateDTO.getStartDate());
        newAgend.setEndDate(agendCreateDTO.getEndDate());
        newAgend.setStartTime(agendCreateDTO.getStartTime());
        newAgend.setEndTime(agendCreateDTO.getEndTime());

        newEvent.setIdEvent(generateCode());
        newEvent.setActiveEvent(true);
        newEvent.setNameEvent(agendCreateDTO.getEventDTO().getNameEvent());
        newEvent.setDescription(agendCreateDTO.getEventDTO().getDescription());
        newEvent.setStartTime(agendCreateDTO.getStartTime());

        newAgend.setEvent(newEvent);

        return newAgend;
    }

    public static String generateCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        int i = 0;
        while (i < 6) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
            i++;
        }
        return code.toString();
    }

    public static AgendResponseDTO getAgendByDate(String startDate, List<Agend> agendList){
        List<Event> listEvent = new ArrayList<>();
        AgendResponseDTO agendResponseDTO = new AgendResponseDTO();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date formattedStartDate;

        try {
            formattedStartDate = formatter.parse(startDate);
        } catch (ParseException e) {
            throw new RuntimeException("Date invalid");
        }

        for(Agend agend : agendList){
            Date agendStartDate = null;
            try {
                agendStartDate = formatter.parse(agend.getStartDate().toString());
            } catch (ParseException e) {
                throw new RuntimeException("Date invalid");
            }

            if (agendStartDate.equals(formattedStartDate)) {
                listEvent.add(agend.getEvent());
                agendResponseDTO.setDataInicio(agend.getStartDate());
            }
        }
        if(listEvent.isEmpty()){
            throw new RuntimeException("no events on this date");
        }
        agendResponseDTO.setEvents(listEvent);

        return agendResponseDTO;
    }

    public static Agend activationEvent(String idEvent, List<Agend> agendList){
        Optional<Agend> optional = agendList.stream().filter(agend -> agend.getEvent().getIdEvent().equals(idEvent)).findFirst();

        if(optional.isPresent()){
            if(optional.get().getEvent().getActiveEvent()){
                agendList.remove(optional.get());
                optional.get().getEvent().setActiveEvent(false);
            }else{
                agendList.remove(optional.get());
                optional.get().getEvent().setActiveEvent(true);
            }
            agendList.add(optional.get());
        }else {
            throw new RuntimeException("this event not exist");
        }

        return optional.get();
    }

    public static void deleteEvent(String idEvent, List<Agend> agendList){
        Optional<Agend> optional = agendList.stream().filter(agend -> agend.getEvent().getIdEvent().equals(idEvent)).findFirst();
        if (optional.isEmpty()) {
            throw new RuntimeException("This event not exist");
        }
        agendList.remove(optional.get());
    }

    public static List<Agend> getAgendOfNextDays(Integer startDate, List<Agend> agendList){
        List<Agend> agendListByDate = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        Date currentDate = Date.from(Instant.now());

        for (int i = 0;i < startDate; i++){
            calendar.setTime(currentDate);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), day+1);

            Optional<Agend> optional = agendList.stream().filter(agendParam -> agendParam.getStartDate()
                    .equals(currentDate)).findFirst();

            optional.ifPresent(agendListByDate::add);
        }
        return agendListByDate;
    }

}
