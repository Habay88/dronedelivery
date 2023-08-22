package net.blusalt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.blusalt.repository.BatteryHistoryRepository;
import net.blusalt.repository.DroneRepository;

@Service
public class BatteryStatusService {
   @Autowired
	 DroneRepository droneRepository;
   @Autowired
	 BatteryHistoryRepository batteryHistoryRepository;
	public BatteryStatusService(DroneRepository droneRepository, BatteryHistoryRepository batteryHistoryRepository) {
	
		this.droneRepository = droneRepository;
		this.batteryHistoryRepository = batteryHistoryRepository;
	}
	
}
