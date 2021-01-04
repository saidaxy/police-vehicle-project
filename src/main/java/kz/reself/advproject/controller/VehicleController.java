package kz.reself.advproject.controller;

import kz.reself.advproject.models.Incident;
import kz.reself.advproject.models.IncidentType;
import kz.reself.advproject.models.Vehicle;
import kz.reself.advproject.service.interfaces.IncidentService;
import kz.reself.advproject.service.interfaces.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> findAllVehicles(){
        return vehicleService.findAllIncidents();
    }

    @GetMapping("/vehicleId={id}")
    public Vehicle findVehicleById(@PathVariable Long id){
        return vehicleService.findVehicleById(id);
    }

    @PostMapping("/createVehicle")
    public String createVehicle(@RequestBody Vehicle vehicle){
        if(vehicleService.createVehicle(vehicle) != null) {
            return "Created Vehicle";
        } return "Error";
    }

    @PostMapping("/deleteVehicle={id}")
    public String deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return "Deleted Vehicle";
    }

}
