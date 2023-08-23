import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.blusalt.model.DroneFleet;
import net.blusalt.repository.DroneRepository;

@Component
public class DataPreloader implements CommandLineRunner {

    private final DroneRepository droneRepository;

    public DataPreloader(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public void run(String... args) {
        DroneFleet drone = new DroneFleet();
        drone.setSerialNumber("genghis123454");
        drone.setModel(model.HEAVYWEIGHT);
        drone.setWeightLimit(500);
        drone.setBatteryCapacityPercentage(10);
        drone.setBatteryState(BatteryState.DRAINING);
        drone.setDroneState(DroneState.RETURNING);

        droneRepository.save(drone);
    }
}
