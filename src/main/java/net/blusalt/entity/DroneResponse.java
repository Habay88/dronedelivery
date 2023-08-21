package net.blusalt.entity;


import java.util.UUID;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.blusalt.model.BatterytState;
import net.blusalt.model.DroneModel;
import net.blusalt.model.DroneState;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneResponse {
	private UUID serialNumber;
	private DroneModel model;
	private int weightLimit;
	private int batteryCapacityPercentage;
	private BatterytState batteryState;
	private DroneState droneState;
}
