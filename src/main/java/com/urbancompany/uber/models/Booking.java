package com.urbancompany.uber.models;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Booking {
    String id;
    User user;
    Cab cab;
    Location fromLocation;
    Location toLocation;
}
