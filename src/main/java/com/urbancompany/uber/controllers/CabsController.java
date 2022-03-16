package com.urbancompany.uber.controllers;

import com.urbancompany.uber.models.*;
import com.urbancompany.uber.services.BookingService;
import com.urbancompany.uber.services.BookingServiceImpl;
import com.urbancompany.uber.services.CabService;
import com.urbancompany.uber.services.CabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class CabsController {


    public void registerCab(Cab cab){
        CabService cabService = new CabServiceImpl();
        cabService.registerCab(cab);
    }

    public Booking bookRide(User user, Location target){
        BookingService bookingService = new BookingServiceImpl();
        Booking booking = bookingService.bookARide(user, target);
        booking.getCab().setAvailable(false);
        return booking;
    }


    public Payment endRide(Booking booking){
        BookingService bookingService = new BookingServiceImpl();
        Payment payment = bookingService.endRide(booking);
        return payment;

    }
}
