package kz.sai_ven.advproject.repo;

import kz.sai_ven.advproject.models.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> getAllByUserId(Integer id);

    List<Incident> getAllByPoliceUserId(Integer id);
}
