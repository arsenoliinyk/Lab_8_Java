package ua.lviv.iot.manager;

import ua.lviv.iot.enums.DeviceType;
import ua.lviv.iot.enums.SortOrder;
import ua.lviv.iot.models.Devices;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class DeviceManager {

    public List<Devices> constractionManagers = new ArrayList<>();


    public final void addDevice(Devices ConstractionManager) {
        this.constractionManagers.add(ConstractionManager);
    }


    public List<Devices> searchByType(DeviceType type) {
        return constractionManagers.stream()
                .filter(managers -> managers.getType().equals(type))
                .collect(Collectors.toList());
    }


    public List<Devices> sortByPrice(SortOrder order) {
        if (order == SortOrder.DSC) {
            constractionManagers.stream().sorted(Comparator.comparing(Devices::getPrice)).forEach(System.out::println);
        }else if (order == SortOrder.ASC){
            constractionManagers.stream().sorted(Comparator.comparing(Devices::getPrice).reversed()).forEach(System.out::println);
        }
        return constractionManagers;
    }


    public List<Devices> sortByWeight(SortOrder order) {
        if (order == SortOrder.DSC) {
            constractionManagers.stream().sorted(Comparator.comparing(Devices::getWeightInGrams)).forEach(System.out::println);
        }else if (order == SortOrder.ASC){
            constractionManagers.stream().sorted(Comparator.comparing(Devices::getWeightInGrams).reversed()).forEach(System.out::println);
        }
        return constractionManagers;
    }


    public void printManagersList(List<Devices> managers) {
        managers.forEach(System.out::println);
    }
}
