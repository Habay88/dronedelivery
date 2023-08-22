package net.blusalt.entity;

import java.util.UUID;

import lombok.Data;
import net.blusalt.model.BatterytState;
import net.blusalt.model.DroneModel;
import net.blusalt.model.DroneState;


@Data
public class DroneRequest {

	private String serialNumber;
	private DroneModel model;
	private int weightLimit;
	private int batteryCapacityPercentage;
	private BatterytState batteryState;
	private DroneState droneState;
}
