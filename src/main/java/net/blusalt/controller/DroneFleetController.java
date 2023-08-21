package net.blusalt.controller;

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
import net.blusalt.service.DroneFleetService;
@RestController
@RequestMapping("/drone")
public class DroneFleetController {

	@Autowired
	DroneFleetService droneFleetService;
	
	@PostMapping
	public ResponseEntity<Long> addDrone(@Valid @RequestBody DroneRequest droneRequest ){
		long droneId = droneFleetService.addFleet(droneRequest);
		return new ResponseEntity<>(droneId, HttpStatus.CREATED);
	}
	
	 @GetMapping("/{id}")
	public ResponseEntity<DroneResponse> getDroneById(@PathVariable("id") long droneId){
		DroneResponse droneResponse = droneFleetService.getDroneById(droneId);
		return new ResponseEntity<>(droneResponse,HttpStatus.OK);
	}
}
