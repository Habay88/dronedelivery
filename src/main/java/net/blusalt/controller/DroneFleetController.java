package net.blusalt.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.blusalt.entity.DroneRequest;
import net.blusalt.entity.DroneResponse;
import net.blusalt.model.DroneFleet;
import net.blusalt.model.DroneState;
import net.blusalt.model.Medication;
import net.blusalt.repository.DroneRepository;
import net.blusalt.repository.MedicationRepository;
import net.blusalt.service.DroneFleetService;
@RestController
@RequestMapping("/drone")
public class DroneFleetController {

	@Autowired
	DroneFleetService droneFleetService;
	@Autowired
	MedicationRepository medicationRepository;
	@Autowired
	DroneRepository droneRepository;
	public DroneFleetController(DroneFleetService droneFleetService, MedicationRepository medicationRepository,DroneRepository droneRepository) {
		
		this.droneFleetService = droneFleetService;
		this.medicationRepository = medicationRepository;
		this.droneRepository =  droneRepository;
	}



	@PostMapping
	public ResponseEntity<Long> addDrone(@Valid @RequestBody DroneRequest droneRequest ){
		long droneId = droneFleetService.addFleet(droneRequest);
		return new ResponseEntity<>(droneId, HttpStatus.CREATED);
	}
	
	 @PostMapping("/{droneId}/load-medication/{medicationId}")
	    public ResponseEntity<String> loadMedication(@PathVariable Long droneId, @PathVariable Long medicationId) {
	        DroneFleet droneRequest = droneRepository.findById(droneId).orElse(null);
	        Medication medication = medicationRepository.findById(medicationId).orElse(null);

	        if (droneRequest == null || medication == null) {
	            return ResponseEntity.badRequest().body("Drone or medication not found.");
	        }

	        droneRequest.getLoadedMedications().add(medication);
	        droneRepository.save(droneRequest);

	        return ResponseEntity.ok("Medication loaded successfully.");
	    }
	 @GetMapping("/{droneId}/loaded-medications")
	    public ResponseEntity<List<Medication>> getLoadedMedications(@PathVariable Long droneId) {
	        DroneFleet droneResponse = droneRepository.findById(droneId).orElse(null);

	        if (droneResponse == null) {
	            return ResponseEntity.notFound().build();
	        }

	        List<Medication> loadedMedications = droneResponse.getLoadedMedications();
	        return ResponseEntity.ok(loadedMedications);
	    }
	
	 @GetMapping("/{id}")
	public ResponseEntity<DroneResponse> getDroneById(@PathVariable("id") long droneId){
		DroneResponse droneResponse = droneFleetService.getDroneById(droneId);
		return new ResponseEntity<>(droneResponse,HttpStatus.OK);
	}
	  @GetMapping("/available-for-loading")
	    public ResponseEntity<List<DroneFleet>> getDronesAvailableForLoading() {
	        List<DroneFleet> availableDrones = droneRepository.findAll().stream()
	                .filter(drone -> drone.getDroneState() == DroneState.IDLE)
	                .collect(Collectors.toList());

	        return ResponseEntity.ok(availableDrones);
	    }
}
