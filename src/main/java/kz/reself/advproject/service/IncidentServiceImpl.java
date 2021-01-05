package kz.reself.advproject.service;

import kz.reself.advproject.models.*;
import kz.reself.advproject.repo.IncidentRepository;
import kz.reself.advproject.repo.UserRepository;
import kz.reself.advproject.service.interfaces.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {
    @Autowired
    IncidentRepository incidentRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<IncidentDTO> findAllIncidents() {
        List<Incident> list = incidentRepository.findAll();
        List<IncidentDTO> incidentDTOList = new ArrayList<>();
        IncidentDTO incidentDTO;
        for (Incident incident : list) {
            incidentDTO = new IncidentDTO();
            incidentDTO.setIncident(incident);
            if (incident.getPoliceUserId() != null)
                incidentDTO.setPolicyUser(userRepository.getById((long) incident.getPoliceUserId()));
            incidentDTO.setUser(userRepository.getById((long) incident.getUserId()));
            incidentDTOList.add(incidentDTO);
        }
        return incidentDTOList;
    }

    @Override
    public List<IncidentDTO> getByUserId(Long userId) {
        User user = userRepository.getById(userId);
        List<Incident> list;
        if (user.getUserRole().equals(UserRole.USER)) {
            list = incidentRepository.getAllByUserId(Math.toIntExact(userId));
        } else {
            list = incidentRepository.getAllByPoliceUserId(Math.toIntExact(userId));
        }
        List<IncidentDTO> incidentDTOList = new ArrayList<>();
        IncidentDTO incidentDTO;
        for (Incident incident : list) {
            incidentDTO = new IncidentDTO();
            incidentDTO.setIncident(incident);
            if (incident.getPoliceUserId() != null)
                incidentDTO.setPolicyUser(userRepository.getById((long) incident.getPoliceUserId()));
            incidentDTO.setUser(userRepository.getById((long) incident.getUserId()));
            incidentDTOList.add(incidentDTO);
        }
        return incidentDTOList;
    }

    @Override
    public List<IncidentDTO> getByPolicyId(Integer userId) {
        List<Incident> list = incidentRepository.getAllByPoliceUserId(userId);
        List<IncidentDTO> incidentDTOList = new ArrayList<>();
        IncidentDTO incidentDTO;
        for (Incident incident : list) {
            incidentDTO = new IncidentDTO();
            incidentDTO.setIncident(incident);
            if (incident.getPoliceUserId() != null)
                incidentDTO.setPolicyUser(userRepository.getById((long) incident.getPoliceUserId()));
            incidentDTO.setUser(userRepository.getById((long) incident.getUserId()));
            incidentDTOList.add(incidentDTO);
        }
        return incidentDTOList;
    }

    @Override
    public IncidentDTO findIncidentById(Long id) {
        Incident incident = incidentRepository.findById(id).get();
        IncidentDTO incidentDTO = new IncidentDTO();
        incidentDTO.setIncident(incident);
        if (incident.getPoliceUserId() != null)
            incidentDTO.setPolicyUser(userRepository.getById((long) incident.getPoliceUserId()));
        incidentDTO.setUser(userRepository.getById((long) incident.getUserId()));

        return incidentDTO;
    }

    @Override
    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public void take(Long id, Integer userId) {
        Incident incident = incidentRepository.findById(id).get();
        incident.setPoliceUserId(userId);
        incident.setIncidentStatus(IncidentStatus.INPROGRESS);
        incidentRepository.save(incident);
    }

    @Override
    public void done(Long id) {
        Incident incident = incidentRepository.findById(id).get();
        incident.setIncidentStatus(IncidentStatus.DONE);
        incidentRepository.save(incident);
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
        return incidentRepository.save(incident);
    }

    @Override
    public void deleteIncident(Long id) {
        incidentRepository.delete(incidentRepository.findById(id).get());
        incidentRepository.flush();
    }
}
