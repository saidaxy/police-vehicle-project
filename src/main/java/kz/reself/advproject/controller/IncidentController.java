package kz.reself.advproject.controller;

import kz.reself.advproject.models.Incident;
import kz.reself.advproject.models.IncidentDTO;
import kz.reself.advproject.models.IncidentType;
import kz.reself.advproject.service.interfaces.IncidentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncidentController {

    @Autowired
    IncidentService incidentService;

    @GetMapping("/incidents")
    public List<IncidentDTO> findAllIncidents() {
        return incidentService.findAllIncidents();
    }

    @GetMapping("/incident/{id}")
    public IncidentDTO findIncidentById(@PathVariable Long id) {
        return incidentService.findIncidentById(id);
    }

    @GetMapping("/incident/{id}/{userId}")
    public void take(@PathVariable Long id, @PathVariable Integer userId) {
        incidentService.take(id, userId);
    }

    @GetMapping("/incident/done/{id}")
    public void done(@PathVariable Long id) {
        incidentService.done(id);
    }

    @GetMapping("/incident/user/{userId}")
    public List<IncidentDTO> user(@PathVariable Long userId) {
        return incidentService.getByUserId(userId);
    }

    @GetMapping("/incident/policy/{userId}")
    public void policy(@PathVariable Integer userId) {
        incidentService.getByPolicyId(userId);
    }

    @GetMapping("/incidentTypes")
    public IncidentType[] findIncidentTypes() {
        return IncidentType.values();
    }

    @PostMapping("/createIncident")
    public String createIncident(@RequestBody Incident incident) {
        if (incidentService.createIncident(incident) != null) {
            return "Created Incident";
        }
        return "Error";
    }

    @PostMapping("/deleteIncident={id}")
    public void deleteUser(Long id) {
        incidentService.deleteIncident(id);
    }

    @PostMapping("/changeToProgress={id}")
    public String changeToProgress(@PathVariable Long id) {
        if (incidentService.changeIncidentToProgress(id) != null) {
            return "Change to progress";
        }
        return "Error";
    }

    @PostMapping("/changeToDone={id}")
    public String changeToDone(@PathVariable Long id) {
        if (incidentService.changeIncidentToDone(id) != null) {
            return "Change to done";
        }
        return "Error";
    }
}
