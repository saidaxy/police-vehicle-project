package kz.sai_ven.advproject.service.interfaces;

import kz.sai_ven.advproject.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    List<Vehicle> findAllIncidents();

    Vehicle findVehicleById(Long id);

    Vehicle createVehicle(Vehicle vehicle);

    void deleteVehicle(Long id);
}
