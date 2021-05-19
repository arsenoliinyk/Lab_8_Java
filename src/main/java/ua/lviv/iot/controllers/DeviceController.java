package ua.lviv.iot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.models.Devices;
import ua.lviv.iot.models.DevicesOfOptics;
import ua.lviv.iot.service.DeviceService;


//localhost:8080/deviceofoptics
@RestController
@RequestMapping(path = "/deviceofoptics")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping(path = "/{id}")
    public DevicesOfOptics getDevice(@PathVariable(name = "id") Integer id) {
        return deviceService.getDeviceOfOptics(id);
    }

    @GetMapping
    public List<DevicesOfOptics> getDevices() {
        return deviceService.getDevicesOfOptics();
    }

    @PutMapping
    public ResponseEntity<Devices> updateDeviceOfOptics(@RequestBody DevicesOfOptics devicesOfOptics){
        if (deviceService.getDeviceOfOptics(devicesOfOptics.getId()) != null) {
            return new ResponseEntity<>(deviceService.updateDeviceOfOptics(devicesOfOptics), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public DevicesOfOptics createDeviceOfOptics(@RequestBody DevicesOfOptics devicesOfOptics){
        return deviceService.addDeviceOfOptics(devicesOfOptics);
    }


    @DeleteMapping(path = "/{id}")
    public DevicesOfOptics deleteDeviceOfOptics(@PathVariable(name = "id") Integer id){
        return deviceService.deleteDeviceOfOptics(id);
    }
}