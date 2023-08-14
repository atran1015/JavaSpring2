/* Task 2:
  Implement REST controllers that does CRUD operations
    -create a Glider, Jet, and Helicopter objects to simulate persistence layer
  Can execute the following via Postman that exercises the Controller
    -Create/populate an instance of Glider, Jet, and Helicopter
    -Update the Jet and Helicopter
    -Delete the Jet
    -Read the Glider, Jet, and Heli to verify completion of the above tasks
      -The controller should return a list of objects
  Cover the following cases and implement REST appropriately
      -Create something with bad data
      -Update something with bad data
      -Attempt to read non-existent data
*/
package com.springboot.application;
import com.springboot.application.model.Aircraft;
import com.springboot.application.model.Glider;
import com.springboot.application.model.Jet;
import com.springboot.application.model.Helicopter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation marks the main class of a Sring Boot application
@SpringBootApplication
public class Application {
    // Program is being ran in this main function
    public static void main(String[] args) {
      // Creating objects - Aircraft itself is an abstract class, therefore, it can't be instantiated
      Aircraft myGlider = new Glider();
      
      // Aircraft myGlider = new Glider("YX2000", "Front", "50 ft", 1, 30, 15, "Beagle Husky");
      // Aircraft myJet = new Jet("N904DE", "Front", "38.7 ft", 2, 13, 24, "Jet A-1", "Turbojet");
      // Aircraft myHelicopter = new Helicopter("N721AF", "Front", "20 ft", 3, 45, 33, 14, 500);

      // Printing instances to console
      System.out.println("---------- Glider's details ----------");
      myGlider.printDetails();
      // System.out.println("---------- Jet's details ----------");
      // myJet.printDetails();
      // System.out.println("---------- Helicopter's details ----------");
      // myHelicopter.printDetails();

      // Runs the application    
      SpringApplication.run(Application.class, args);
    }
}