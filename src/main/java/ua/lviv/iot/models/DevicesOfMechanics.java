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
public class DevicesOfMechanics extends Devices{
    private String speed;


    public DevicesOfMechanics() {}


    public DevicesOfMechanics(float price, String matherial, Country originCountry, Equipment category,
                              int weightInGrams, DeviceType MECHANICS, String speed) {
        super(price, matherial, originCountry, category, weightInGrams, MECHANICS);
        this.speed = speed;
    }
}
