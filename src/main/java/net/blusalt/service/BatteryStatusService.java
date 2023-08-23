package net.blusalt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import net.blusalt.model.BatteryStatusHistory;
import net.blusalt.model.DroneFleet;
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

	
    private void createBatteryHistoryLog(DroneFleet droneFleet) {
        BatteryStatusHistory batteryStatusHistory = new BatteryStatusHistory();
        batteryStatusHistory.setDronefleet(droneFleet);
        batteryStatusHistory.setBatteryPercentage(droneFleet.getBatteryCapacityPercentage());
        batteryStatusHistory.setTimestamp(new Date());
        batteryHistoryRepository.save(batteryStatusHistory);
    }

	@Scheduled(fixedRate = 30 * 60 * 1000) // 30 minutes interval
    public void checkBatteryLevels() {
        List<DroneFleet> drones = droneRepository.findAll();

        for (DroneFleet drone : drones) {
            if (drone.getBatteryCapacityPercentage() < 25) {
                createBatteryHistoryLog(drone);
            }
        }
    }
	
}
