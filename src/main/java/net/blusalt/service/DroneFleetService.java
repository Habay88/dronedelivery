package net.blusalt.service;

import java.util.Optional;

import net.blusalt.entity.DroneRequest;
import net.blusalt.entity.DroneResponse;
import net.blusalt.model.Medication;

public interface DroneFleetService {

	long addFleet(DroneRequest dronerequest);
	DroneResponse getDroneById (long droneId);
	
}
