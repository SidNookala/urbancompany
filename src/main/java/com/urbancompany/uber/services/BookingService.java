package com.urbancompany.uber.services;

import com.urbancompany.uber.models.Booking;
import com.urbancompany.uber.models.Location;
import com.urbancompany.uber.models.Payment;
import com.urbancompany.uber.models.User;

public interface BookingService {
    Booking bookARide(User user, Location target);
    Payment endRide(Booking booking);
}
