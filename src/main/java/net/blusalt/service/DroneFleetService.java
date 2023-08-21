package net.blusalt.service;

import net.blusalt.entity.DroneRequest;
import net.blusalt.entity.DroneResponse;

public interface DroneFleetService {

	long addFleet(DroneRequest dronerequest);
	DroneResponse getDroneById (long droneId);
}
