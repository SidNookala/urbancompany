package com.urbancompany.uber.models;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    private String id;
    private int price;

    public int calculatePrice(Booking booking){
        int price = Math.abs(booking.getFromLocation().getRadius()-booking.getToLocation().getRadius());
        return price;
    }

}
