package kz.reself.advproject.service;

import kz.reself.advproject.models.Vehicle;
import kz.reself.advproject.repo.VehicleRepository;
import kz.reself.advproject.service.interfaces.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Override
    public List<Vehicle> findAllIncidents() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findVehicleById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.delete(vehicleRepository.findById(id).get());
        vehicleRepository.flush();
    }
}
