package ua.lviv.iot;

import ua.lviv.iot.enums.*;
import ua.lviv.iot.manager.DeviceManager;
import ua.lviv.iot.models.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        DeviceManager manager = new DeviceManager();

        Devices firstDevice = new DevicesOfMechanics(500, "сплав Скло", Country.GERMANY,
                Equipment.FOR_DEMONSTRATION, 300, DeviceType.MECHANICS, "Not so well");
        Devices secondDevice = new DevicesOfElectricityAndMagnetism(6000, "сплав Скло", Country.CHINA,
                Equipment.FOR_LABORATORY, 1500, DeviceType.ELECTRICITY_AND_MAGNETISM, Sensivity.MEDIUM);
        Devices thirdDevice = new DevicesOfElectricityAndMagnetism(8999, "сплав Скло", Country.CHINA,
                Equipment.FOR_LABORATORY,1899, DeviceType.ELECTRICITY_AND_MAGNETISM, Sensivity.LIGHT);
        Devices fourthDevice = new DevicesOfMolecularPhysicsAndThermodynamics(7000, "сплав Скло", Country.GERMANY,
                Equipment.FOR_DEMONSTRATION, 8500, DeviceType.MOLECULAR_PHYSICS_AND_THERMODYNAMICS,
                "Enough for demonstrations");
        Devices fifthDevice = new DevicesOfOptics(200, "сплав Скло", Country.CHINA, Equipment.FOR_DEMONSTRATION,
                800, DeviceType.OPTICS, "Easy to replace",1);


        manager.addDevice(firstDevice);
        manager.addDevice(secondDevice);
        manager.addDevice(thirdDevice);
        manager.addDevice(fourthDevice);
        manager.addDevice(fifthDevice);

        manager.printManagersList(manager.searchByType(DeviceType.MECHANICS));
        System.out.println("--------------------------------------------------------------------------------------");
        manager.sortByPrice(SortOrder.ASC);
        System.out.println("--------------------------------------------------------------------------------------");
        manager.sortByWeight(SortOrder.DSC);

    }
}
