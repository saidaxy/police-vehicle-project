package kz.reself.advproject.service.interfaces;

import kz.reself.advproject.models.Incident;
import kz.reself.advproject.models.IncidentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncidentService {
    List<IncidentDTO> findAllIncidents();

    List<IncidentDTO> getByUserId(Long userId);

    List<IncidentDTO> getByPolicyId(Integer userId);

    IncidentDTO findIncidentById(Long id);

    Incident createIncident(Incident incident);

    void take(Long id, Integer userId);

    void done(Long id);

    Incident changeIncidentToProgress(Long id);

    Incident changeIncidentToDone(Long id);

    void deleteIncident(Long id);
}
