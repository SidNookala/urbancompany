package com.urbancompany.uber.models;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cab {
    String id;
    String type;
    String driverName;
    Location currentLocation;
    boolean isAvailable;


}
