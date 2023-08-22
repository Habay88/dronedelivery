package net.blusalt.service;

import java.util.Optional;

import net.blusalt.entity.DroneRequest;
import net.blusalt.entity.DroneResponse;
import net.blusalt.entity.MedicationRequest;
import net.blusalt.entity.MedicationResponse;
import net.blusalt.model.Medication;

public interface MedicationService {

	long addMedication(MedicationRequest medicationRequest);
	MedicationResponse getById (long Id);
	
}
