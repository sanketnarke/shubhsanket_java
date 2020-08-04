package com.app.dao;

import com.app.pojos.Booking;
import com.app.pojos.Provider;

public interface IBooking {
public String booking(Booking b);

public Provider sentmail(Booking b);
}
