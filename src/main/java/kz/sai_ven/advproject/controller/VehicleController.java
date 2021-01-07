package kz.sai_ven.advproject.controller;

import kz.sai_ven.advproject.models.Vehicle;
import kz.sai_ven.advproject.service.interfaces.VehicleService;
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
