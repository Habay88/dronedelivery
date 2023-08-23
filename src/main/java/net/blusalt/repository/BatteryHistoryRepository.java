package net.blusalt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.blusalt.model.BatteryStatusHistory;

public interface BatteryHistoryRepository extends JpaRepository<BatteryStatusHistory, Long> {

}
