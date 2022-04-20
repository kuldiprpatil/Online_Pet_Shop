package utils;

import java.util.ArrayList;
import java.util.Iterator;

import com.app.core.Order;
import com.app.core.Pet;

import pet_exception.AuthenticationException;

public class Validation {

	// Checking who has logged in
	public static char IsLoginValid(String loginId, String password) {

		// Admin login
		if (loginId.equals("admin") && password.equals("admin")) {
			System.out.println("Successfully logged as Admin!!!!!");
			return 'a';
		} 
		
		// Customer login
		else if (loginId.equals("c1") && password.equals("c1")) {
			System.out.println("Successfully logged as Customer!!!!!");
			return 'c';
		} 
		
		// Returning e for invalid login
		else
			return 'e';
	}

	// Returning pet 
	public static Pet getPet(int petId, ArrayList<Pet> petList) throws AuthenticationException {

		Iterator<Pet> itrPet = petList.iterator();
		while (itrPet.hasNext()) {
			Pet p = itrPet.next();
			if (p.getPetId() == petId)
				return p;
		}
		throw new AuthenticationException("Invalid PetId!!!!!");
	}

	// Returning order
	public static Order orderStatus(int orderId, ArrayList<Order> orderList) throws AuthenticationException {

		Iterator<Order> itrOrder = orderList.iterator();
		while (itrOrder.hasNext()) {
			Order o = itrOrder.next();
			if (o.getOrderId() == orderId)
				return o;
		}
		throw new AuthenticationException("Invalid Order Id!!!!!");
	}
}
