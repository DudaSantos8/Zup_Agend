package com.myCalendar.agend.controller.agend;

import com.myCalendar.agend.service.AgendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/agend")
public class AgendController {

    @Autowired
    private AgendService agentService;

    @GetMapping()
    public ResponseEntity<?> getAgendOfNextDays( @RequestParam(name = "numberOfDays", required = false) Integer numberOfDays){
        if(numberOfDays == null){
            try{
                return ResponseEntity.ok().body(agentService.getAllAgendOfNextDays(null));
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
    public ResponseEntity<?> postNewEvent(@RequestBody AgendCreateDTO agendCreateDTO){
        try{

            return ResponseEntity.status(201).body(agentService.save(agendCreateDTO));
        }catch (Exception e){
            return ResponseEntity.status(400).body(Map.of("message", e.getMessage()));
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
