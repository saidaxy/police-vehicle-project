package kz.reself.advproject.controller;

import kz.reself.advproject.models.Incident;
import kz.reself.advproject.models.IncidentType;
import kz.reself.advproject.service.interfaces.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncidentController {

    @Autowired
    IncidentService incidentService;

    @GetMapping("/incidents")
    public List<Incident> findAllIncidents(){
        return incidentService.findAllIncidents();
    }

    @GetMapping("/incidentId={id}")
    public Incident findIncidentById(@PathVariable Long id){
        return incidentService.findIncidentById(id);
    }

    @GetMapping("/incidentTypes")
    public IncidentType[] findIncidentTypes(){
        return IncidentType.values();
    }

    @PostMapping("/createIncident")
    public String createIncident(@RequestBody Incident incident){
        if(incidentService.createIncident(incident) != null) {
            return "Created Incident";
        } return "Error";
    }
    @PostMapping("/deleteIncident={id}")
    public void deleteUser(Long id) {
        incidentService.deleteIncident(id);
    }

    @PostMapping("/changeToProgress={id}")
    public String changeToProgress(@PathVariable Long id){
        if(incidentService.changeIncidentToProgress(id) != null){
            return "Change to progress";
        }
        return "Error";
    }

    @PostMapping("/changeToDone={id}")
    public String changeToDone(@PathVariable Long id){
        if(incidentService.changeIncidentToDone(id) != null){
            return "Change to done";
        }
        return "Error";
    }
}
