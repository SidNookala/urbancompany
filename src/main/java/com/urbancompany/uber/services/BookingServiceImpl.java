package com.urbancompany.uber.services;

import com.urbancompany.uber.database.CabsStorage;
import com.urbancompany.uber.exceptions.CabsNotAvailableException;
import com.urbancompany.uber.models.*;

import java.util.HashMap;
import java.util.UUID;

public class BookingServiceImpl implements BookingService {
    @Override
    public Booking bookARide(User user, Location target) {
        HashMap<String, Cab> allCabs = CabsStorage.getAllCabs();
        int minDistance = Integer.MAX_VALUE;

        Cab cabToBeBooked = null;
        for (String i : allCabs.keySet()) {
//            minDistance = Math.min(minDistance, allCabs.get(i).getCurrentLocation().getRadius());

            if (minDistance > allCabs.get(i).getCurrentLocation().getRadius() ) {
                minDistance = allCabs.get(i).getCurrentLocation().getRadius();
                cabToBeBooked = allCabs.get(i).isAvailable()? allCabs.get(i): null;
            }
        }

        if(cabToBeBooked == null){
            throw new CabsNotAvailableException();
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setCab(cabToBeBooked);
        booking.setId(UUID.randomUUID().toString());
        booking.setFromLocation(user.getLocation());
        booking.setToLocation(target);
        cabToBeBooked.setAvailable(false);
            booking.getCab().setAvailable(false);
        return booking;
    }

    @Override
    public Payment endRide(Booking booking) {
        booking.getCab().setAvailable(true);
        Payment payment = new Payment();
        int price = payment.calculatePrice(booking);
        payment.setId(UUID.randomUUID().toString());
        payment.setPrice(price);
        return payment;
    }
}
