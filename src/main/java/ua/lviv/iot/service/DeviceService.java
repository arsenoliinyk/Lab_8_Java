package ua.lviv.iot.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import ua.lviv.iot.models.DevicesOfOptics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@ApplicationScope
public class DeviceService {

    private AtomicInteger id = new AtomicInteger(0);
    private Map<Integer, DevicesOfOptics> devicesMap = new HashMap<Integer, DevicesOfOptics>();

    public DevicesOfOptics addDeviceOfOptics(DevicesOfOptics deviceOfOptics){
        Integer deviceOfOpticsId = id.incrementAndGet();
        deviceOfOptics.setId(deviceOfOpticsId);
        devicesMap.put(deviceOfOpticsId, deviceOfOptics);
        return deviceOfOptics;
    }

    public DevicesOfOptics updateDeviceOfOptics(DevicesOfOptics deviceOfOptics){
        return devicesMap.put(deviceOfOptics.getId(), deviceOfOptics);
    }

    public List<DevicesOfOptics> getDevicesOfOptics(){
        return devicesMap.values().stream().collect(Collectors.toList());
    }

    public DevicesOfOptics getDeviceOfOptics(Integer id) {
        return devicesMap.get(id);
    }

    public DevicesOfOptics deleteDeviceOfOptics(Integer id) {
        return devicesMap.remove(id);
    }
}
