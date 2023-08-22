package net.blusalt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.blusalt.entity.MedicationRequest;
import net.blusalt.service.MedicationService;

@RestController
@RequestMapping("/medication")
public class MedicationController {

	@Autowired
	MedicationService medicationService;

	public MedicationController(MedicationService medicationService) {
		this.medicationService = medicationService;
	}
	
	@PostMapping
	public ResponseEntity<Long> addDrone(@Valid @RequestBody MedicationRequest medicationRequest ){
		long Id = medicationService.addMedication(medicationRequest);
		return new ResponseEntity<>(Id, HttpStatus.CREATED);
	}
}
