package com.myCalendar.agend.controller.agend;

import com.myCalendar.agend.controller.agend.DTO.AgendCreateDTO;
import com.myCalendar.agend.service.AgendService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/agend")
public class AgendController {

    @Autowired
    private AgendService agentService;

    @GetMapping("/{activeEvent}")
    public ResponseEntity<?> getAllEventsByActivation(@PathVariable String activeEvent){
        try{
            return ResponseEntity.ok().body(agentService.getAllEventsByActivation(activeEvent));
        }catch (Exception e){
            return ResponseEntity.status(400).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAgendOfNextDays( @RequestParam(name = "numberOfDays", required = false) Integer numberOfDays){
        if(numberOfDays == null){
            try{
                return ResponseEntity.ok().body(agentService.getAllAgendOfNextDays());
            }catch (Exception e){
                return ResponseEntity.status(400).body(Map.of("message", e.getMessage()));
            }
        }else if(numberOfDays > 0){
            try{
                return ResponseEntity.ok().body(agentService.getAgendOfNextDays(numberOfDays));
            }catch (Exception e){
                return ResponseEntity.status(400).body(Map.of("message", e.getMessage()));
            }
        } else if (numberOfDays < 0) {
            try{
                return ResponseEntity.ok().body(agentService.getAgendOfPreviusDays(numberOfDays));
            }catch (Exception e){
                return ResponseEntity.status(400).body(Map.of("message", e.getMessage()));
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<?> postNewEvent(@Valid @RequestBody AgendCreateDTO agendCreateDTO){
        try{
            agentService.save(agendCreateDTO);
            return ResponseEntity.status(201).body(Map.of("message", "Event created"));
        }catch (Exception e){
            return ResponseEntity.status(422).body(Map.of("message", e.getMessage()));
        }
    }

    @PatchMapping("/{idEvent}")
    public ResponseEntity<?> updateStateEvent(@PathVariable String idEvent){
        try{
            agentService.update(idEvent);
            return ResponseEntity.status(204).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{idEvent}")
    public ResponseEntity<?> deleteEvent(@PathVariable String idEvent){
        try{
            agentService.delete(idEvent);
            return ResponseEntity.status(204).build();
        }catch (Exception e){
            return ResponseEntity.status(400).body(Map.of("message", e.getMessage()));
        }
    }
}
