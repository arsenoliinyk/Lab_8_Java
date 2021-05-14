package ua.lviv.iot.models;

import lombok.*;
import ua.lviv.iot.enums.Country;
import ua.lviv.iot.enums.DeviceType;
import ua.lviv.iot.enums.Equipment;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DevicesOfOptics extends Devices{
    private String lens;


    public DevicesOfOptics(float price, String matherial, Country originCountry, Equipment category,
                           int weightInGrams, DeviceType ELECTRICITY_AND_MAGNETISM, String lens) {
        super(price, matherial, originCountry, category, weightInGrams, ELECTRICITY_AND_MAGNETISM);
        this.lens = lens;
    }
}

