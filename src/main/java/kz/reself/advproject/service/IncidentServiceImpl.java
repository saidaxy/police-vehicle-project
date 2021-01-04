package kz.reself.advproject.service;

import kz.reself.advproject.models.Incident;
import kz.reself.advproject.models.IncidentStatus;
import kz.reself.advproject.models.User;
import kz.reself.advproject.repo.IncidentRepository;
import kz.reself.advproject.service.interfaces.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {
    @Autowired
    IncidentRepository incidentRepository;
    @Override
    public List<Incident> findAllIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public Incident findIncidentById(Long id) {
        return incidentRepository.findById(id).get();
    }

    @Override
    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public Incident changeIncidentToProgress(Long id) {
        Incident incident = incidentRepository.findById(id).get();
        incident.setIncidentStatus(IncidentStatus.INPROGRESS);
        return incidentRepository.save(incident);
    }

    @Override
    public Incident changeIncidentToDone(Long id) {
        Incident incident = incidentRepository.findById(id).get();
        incident.setIncidentStatus(IncidentStatus.DONE);
        return  incidentRepository.save(incident);
    }

    @Override
    public void deleteIncident(Long id) {
        incidentRepository.delete(incidentRepository.findById(id).get());
        incidentRepository.flush();
    }
}
