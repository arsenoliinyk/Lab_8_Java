package ua.lviv.iot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.enums.Country;
import ua.lviv.iot.enums.DeviceType;
import ua.lviv.iot.enums.Equipment;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Devices {

    private float price;
    private String matherial;
    private Country originCountry;
    private Equipment category;
    private int weightInGrams;
    private DeviceType type;

}
