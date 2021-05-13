package ua.lviv.iot.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.lviv.iot.enums.Country;
import ua.lviv.iot.enums.DeviceType;
import ua.lviv.iot.enums.Equipment;
import ua.lviv.iot.enums.Sensivity;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DevicesOfElectricityAndMagnetism extends Devices{
    private Sensivity sensivity;


    public DevicesOfElectricityAndMagnetism() {}


    public DevicesOfElectricityAndMagnetism(float price, String matherial, Country originCountry, Equipment category,
                                            int weightInGrams, DeviceType ELECTRICITY_AND_MAGNETISM, Sensivity sensivity) {
        super(price, matherial, originCountry, category, weightInGrams, ELECTRICITY_AND_MAGNETISM);
        this.sensivity = sensivity;
    }
}
