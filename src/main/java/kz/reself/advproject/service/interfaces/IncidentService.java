package kz.reself.advproject.service.interfaces;

import kz.reself.advproject.models.Incident;
import kz.reself.advproject.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncidentService {
    List<Incident> findAllIncidents();

    Incident findIncidentById(Long id);

    Incident createIncident(Incident incident);

    Incident changeIncidentToProgress(Long id);

    Incident changeIncidentToDone(Long id);

    void deleteIncident(Long id);
}
