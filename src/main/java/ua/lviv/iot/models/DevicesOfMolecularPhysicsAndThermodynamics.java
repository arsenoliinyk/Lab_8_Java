package ua.lviv.iot.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.lviv.iot.enums.Country;
import ua.lviv.iot.enums.DeviceType;
import ua.lviv.iot.enums.Equipment;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DevicesOfMolecularPhysicsAndThermodynamics extends Devices{
    private String power;


    public DevicesOfMolecularPhysicsAndThermodynamics() {}


    public DevicesOfMolecularPhysicsAndThermodynamics(float price, String matherial, Country originCountry, Equipment category,
                                                      int weightInGrams, DeviceType ELECTRICITY_AND_MAGNETISM, String power) {
        super(price, matherial, originCountry, category, weightInGrams, ELECTRICITY_AND_MAGNETISM);
        this.power = power;
    }
}
