package com.myCalendar.agend.service.mapper;

import com.myCalendar.agend.controller.agend.DTO.AgendCreateDTO;
import com.myCalendar.agend.controller.agend.DTO.AgendResponseDTO;
import com.myCalendar.agend.repository.Agend;
import com.myCalendar.agend.repository.Event;

import java.time.LocalDate;
import java.time.ZonedDateTime;
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
        newEvent.setNameEvent(agendCreateDTO.getEvent().getNameEvent());
        newEvent.setDescription(agendCreateDTO.getEvent().getDescription());
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

    public static AgendResponseDTO getAllAgendOfNextDays(List<Agend> agendList){
        List<Event> listEvent = new ArrayList<>();
        AgendResponseDTO agendResponseDTO = new AgendResponseDTO();
        ZonedDateTime now = ZonedDateTime.now();
        LocalDate targetDate = now.toLocalDate();

        for(Agend agend : agendList){

            if(agend.getStartDate().equals(targetDate)){
                listEvent.add(agend.getEvent());
                if(agendResponseDTO.getStartDate() == null){
                    agendResponseDTO.setStartDate(agend.getStartDate());
                }
            } else if (agend.getStartDate().isAfter(targetDate)) {
                targetDate = agend.getStartDate();
                listEvent.add(agend.getEvent());

                if(agendResponseDTO.getStartDate() == null){
                    agendResponseDTO.setStartDate(agend.getStartDate());
                }
            }
        }

        if(listEvent.isEmpty()){
            throw new RuntimeException("no events in the next days");
        }else{
            agendResponseDTO.setEvents(listEvent);
        }

        return agendResponseDTO;
    }

    public static AgendResponseDTO getAgendOfPreviusDays(Integer numberOfDays, List<Agend> agendList){
        List<Event> listEvent = new ArrayList<>();
        AgendResponseDTO agendResponseDTO = new AgendResponseDTO();
        ZonedDateTime now = ZonedDateTime.now();
        for (int j = 0; j >= numberOfDays; j--){
                LocalDate targetDate = now.plusDays(j).toLocalDate();

                Optional<Agend> optional = agendList.stream().filter(agend -> agend.getStartDate()
                        .equals(targetDate)).findFirst();

                if (optional.isPresent()) {
                    Agend agend = optional.get();

                    listEvent.add(agend.getEvent());
                    if(agendResponseDTO.getStartDate() == null){
                        agendResponseDTO.setStartDate(agend.getStartDate());
                    }

                }
            }

        if(listEvent.isEmpty()){
            throw new RuntimeException("no previus events");
        }else{
            agendResponseDTO.setEvents(listEvent);
        }

        return agendResponseDTO;
    }

    public static AgendResponseDTO getAgendOfNextDays(Integer numberOfDays, List<Agend> agendList){
        List<Event> listEvent = new ArrayList<>();
        AgendResponseDTO agendResponseDTO = new AgendResponseDTO();
        ZonedDateTime now = ZonedDateTime.now();

        for(int i = 0; i < numberOfDays; i++){
            LocalDate targetDate = now.plusDays(i).toLocalDate();

            Optional<Agend> optional = agendList.stream().filter(agend -> agend.getStartDate()
                    .equals(targetDate)).findFirst();

            if (optional.isPresent()) {
                Agend agend = optional.get();

                listEvent.add(agend.getEvent());
                if(agendResponseDTO.getStartDate() == null){
                    agendResponseDTO.setStartDate(agend.getStartDate());
                }

            }
        }

        if(listEvent.isEmpty()){
            throw new RuntimeException("no events in the next " + numberOfDays + " days");
        }else{
            agendResponseDTO.setEvents(listEvent);
        }

        return agendResponseDTO;
    }

}
