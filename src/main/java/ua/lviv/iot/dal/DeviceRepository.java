package ua.lviv.iot.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.models.DevicesOfOptics;

@Repository
public interface DeviceRepository extends JpaRepository<DevicesOfOptics, Integer> {

}
