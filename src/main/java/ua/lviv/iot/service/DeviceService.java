package ua.lviv.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import ua.lviv.iot.dal.DeviceRepository;
import ua.lviv.iot.exeptions.DevicesOfOpticsNotFoundExeption;
import ua.lviv.iot.models.DevicesOfOptics;

@Service
@ApplicationScope
public class DeviceService {
    @Autowired
    private DeviceRepository repository;

    public DevicesOfOptics addDeviceOfOptics(DevicesOfOptics deviceOfOptics) {
        return repository.save(deviceOfOptics);
    }

    public DevicesOfOptics updateDeviceOfOptics(DevicesOfOptics deviceOfOptics) throws DevicesOfOpticsNotFoundExeption {
        if (repository.existsById(deviceOfOptics.getId())) {
            return repository.save(deviceOfOptics);
        }
        throw new DevicesOfOpticsNotFoundExeption("DevicesOfOptics with id:" + deviceOfOptics.getId() + " npt found in the system.");
    }

    public List<DevicesOfOptics> getDevicesOfOptics() {
        return repository.findAll();
    }

    public DevicesOfOptics getDeviceOfOptics(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public DevicesOfOptics deleteDeviceOfOptics(Integer id) {
        DevicesOfOptics deviceOfOptics = repository.findById(id).orElseThrow();
        if (deviceOfOptics == null) {
            return null;
        }
        repository.deleteById(id);
        return deviceOfOptics;
    }

}
