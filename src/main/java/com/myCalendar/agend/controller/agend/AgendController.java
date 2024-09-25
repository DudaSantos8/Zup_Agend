package com.myCalendar.agend.controller.agend;

import com.myCalendar.agend.repository.Agend;
import com.myCalendar.agend.service.AgendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/agend")
public class AgendController {

    @Autowired
    private AgendService agentService;

    @GetMapping
    public List<Agend> getAgend(){
        return agentService.getAllAgend();
    }

    @GetMapping("/{startDate}")
    private ResponseEntity<?> getAgendByDay(@PathVariable String startDate){
        try{
            return ResponseEntity.ok(agentService.getAgendByDate(startDate));
        }catch (RuntimeException e){
            return ResponseEntity.status(422).body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> postNewEvent(@RequestBody AgendCreateDTO agendCreateDTO){
        try{
            agentService.save(agendCreateDTO);
            return ResponseEntity.ok().body(Map.of("message", "Event created"));
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
