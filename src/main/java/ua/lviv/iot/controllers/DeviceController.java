package ua.lviv.iot.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.exeptions.DevicesOfOpticsNotFoundExeption;
import ua.lviv.iot.models.DevicesOfOptics;
import ua.lviv.iot.service.DeviceService;


//localhost:8080/deviceofoptics
@RestController
@RequestMapping(path = "/deviceofoptics")
public class DeviceController {

    private static final Logger LOGGER = Logger.getLogger("ua.lviv.iot.controllers");

    @Autowired
    private DeviceService deviceService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<DevicesOfOptics> getDeviceOfOptics(@PathVariable(name = "id") Integer id) {
        try {
            return new ResponseEntity<DevicesOfOptics>(deviceService.getDeviceOfOptics(id), (HttpStatus.OK));
        }catch(NoSuchElementException e) {
            LOGGER.severe("Can't update a device with non-existing id" + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public List<DevicesOfOptics> getDevicesOfOptics() {
        return deviceService.getDevicesOfOptics();
    }

    @PutMapping
    public ResponseEntity<DevicesOfOptics> updateDeviceOfOptics(@RequestBody DevicesOfOptics devicesOfOptics) {

        if (devicesOfOptics.getId() == null){
            LOGGER.severe("Can't update a device without id - null value was passed instead of it");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<DevicesOfOptics>(deviceService.updateDeviceOfOptics(devicesOfOptics), HttpStatus.OK);
        } catch (DevicesOfOpticsNotFoundExeption devicesOfOpticsNotFoundExeption) {
            LOGGER.severe("Can't update a device with non-existing id: " + devicesOfOptics.getId());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DevicesOfOptics> createDeviceOfOptics(@RequestBody DevicesOfOptics devicesOfOptics){
        if (devicesOfOptics.getId() == null) {
            return new ResponseEntity<DevicesOfOptics>(deviceService.addDeviceOfOptics(devicesOfOptics), HttpStatus.OK);
        }

        LOGGER.severe("Tried to create a device with passed id. Device creation should not use external ids");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping(path = "/{id}")
    public DevicesOfOptics deleteDeviceOfOptics(@PathVariable(name = "id") Integer id){
        return deviceService.deleteDeviceOfOptics(id);
    }
}