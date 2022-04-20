package test;

import java.util.ArrayList;
import java.util.Scanner;
import static com.app.core.Category.*;
import static utils.Validation.*;
import com.app.core.Category;
import com.app.core.Order;
import com.app.core.Pet;
import com.app.core.Status;
import static utils.CollectionUtils.*;
import pet_exception.AuthenticationException;
import pet_exception.AuthorizationException;
import pet_exception.OutOfStockException;

public class Menu {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			ArrayList<Pet> petList = populatedList();
			ArrayList<Order> orderList = new ArrayList<>();
			boolean flag = false;
			boolean access = false; // for admin functionality access
			boolean loginAccess = false; // for whole functionality access
			do {

				System.out.println("a. Login");
				System.out.println("b. Add New Pet(Admin only functionality)");
				System.out.println("c. Update Pet Details(Admin only functionality)");
				System.out.println("d. Display all available pet");
				System.out.println("e. Order Pet");
				System.out.println("f. Check order status by OrderId");
				System.out.println("g. Update Order Status(Admin only functionality)");
				System.out.println("h. Exit");

				try {

					switch (scan.next().charAt(0)) {
					case 'a':
						System.out.println("Enter login and password: ");
						String loginId = scan.next();
						String password = scan.next();
						char check = IsLoginValid(loginId, password);
						if (check == 'a') {
							access = true;
							loginAccess = true;
						}
						if (check == 'c') {
							access = false;
							loginAccess = true;
						}
						if (check == 'e') {
							throw new AuthorizationException("Invalid Login Credentials!!!!!");
						}
						break;

					case 'b':
						if (loginAccess) {
							if (access) {
								System.out.println("Enter Details(Name, Category, Unit Price, Stock):");
								petList.add(new Pet(scan.next(), valueOf(scan.next().toUpperCase()), scan.nextDouble(),
										scan.nextInt()));
								System.out.println("Successfully Added new Pet!!!!!!!");
							} else
								throw new AuthenticationException("Admin Only Functionality");
						} else
							throw new AuthenticationException("Login First !!!!!");
						break;

					case 'c':
						if (loginAccess) {
							if (access) {
								System.out.println("Enter Id: ");
								Pet p = getPet(scan.nextInt(), petList);
								System.out.println("Enter Details(Name, Category, Unit Price, Stock) to update:");
								p.setName(scan.next());
								p.setCategory(scan.next().toUpperCase());
								p.setUnitPrice(scan.nextDouble());
								p.setStock(scan.nextInt());
								System.out.println("Successfullly Updated Details!!!!!");
							} else
								throw new AuthenticationException("Admin Only Functionality");
						} else
							throw new AuthenticationException("Login First !!!!!");
						break;

					case 'd':
						if (loginAccess) {
							petList.stream().filter(p -> p.getStock() != 0).forEach(System.out::println);
						} else
							throw new AuthenticationException("Login First !!!!!");
						break;

					case 'e':
						if (loginAccess) {
							System.out.println("Enter PetId: ");
							Pet p = getPet(scan.nextInt(), petList);
							if (p.getStock() != 0) {
								System.out.println("Enter Quantity and Status: ");
								int quant = scan.nextInt();
								// Checking if quantity is more than stock
								if (p.getStock() < quant)
									throw new OutOfStockException("Don't have so much stock!!!!!");
								String status = scan.next().toUpperCase();

								// Placing order
								Order o = new Order(p.getPetId(), quant, status);
								orderList.add(o);

								// Updating stock
								p.setStock(p.getStock() - quant);
								System.out.println("Order Pet with id: " + o.getOrderId());
							} else
								throw new OutOfStockException("Sorry, Out Of Stock!!!!!!");
						} else
							throw new AuthenticationException("Login First !!!!!");
						break;

					case 'f':
						if (loginAccess) {
							System.out.println("Enter orderId: ");
							Order o = orderStatus(scan.nextInt(), orderList);
							System.out.println("Order Status is: " + o.getStatus());
						} else
							throw new AuthenticationException("Login First !!!!!");
						break;

					case 'g':
						if (loginAccess) {
							if (access) {
								System.out.println("Enter orderId: ");
								Order o = orderStatus(scan.nextInt(), orderList);
								o.setStatus(scan.next());
								System.out.println("Succesfully Updated Order Status!!!!");
							} else
								throw new AuthenticationException("Admin Only Functionality");
						} else
							throw new AuthenticationException("Login First !!!!!");
						break;

					case 'h':
						flag = true;
						break;

					default:
						System.out.println("Wrong Choice!!!");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				scan.nextLine();
			} while (!flag);
		}

	}

}
