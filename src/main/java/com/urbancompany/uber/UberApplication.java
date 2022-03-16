package com.urbancompany.uber;

import com.urbancompany.uber.controllers.CabsController;
import com.urbancompany.uber.controllers.UserController;
import com.urbancompany.uber.database.CabsStorage;
import com.urbancompany.uber.database.UserStorage;
import com.urbancompany.uber.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.UUID;

@SpringBootApplication
public class UberApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberApplication.class, args);


		CabsController cabsController = new CabsController();
		Cab cab1 = new Cab(UUID.randomUUID().toString(),"X","SIdd", new Location(15), true);
//		Cab cab2 = new Cab(UUID.randomUUID().toString(),"X","SIddharth", new Location(32),true);
//		Cab cab3 = new Cab(UUID.randomUUID().toString(),"X","driver", new Location(32),true);
		cabsController.registerCab(cab1); //cabsController.registerCab(cab2);  cabsController.registerCab(cab3);

		HashMap<String, Cab> allCabs = CabsStorage.getAllCabs();
//		System.out.println(allCabs.keySet());

		UserController userController = new UserController();
		User user1 = new User(UUID.randomUUID().toString(), "custormer", new Location(35));
		User user2 = new User(UUID.randomUUID().toString(), "custormer2", new Location(40));
		userController.registerUser(user1); userController.registerUser(user2);

		UserStorage.getAllUsers().entrySet().stream().forEach(e-> System.out.println(e));

		Booking booking = cabsController.bookRide(user1, new Location(100));
		System.out.println("ride booked: "+booking);


//		Payment payment = cabsController.endRide(booking);
//		System.out.println(" ride ended: "+ payment);


		Booking booking1 = cabsController.bookRide(user2, new Location(100));
		System.out.println("ride booked: "+booking1);

	}

}
