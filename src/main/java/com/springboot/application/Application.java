/* Task 1: Implement an OOD that features:
    A generic Aircraft that has common features
    A Glider with commonalities with Aircraft as well as unique things
    A Jet with commonalities with Aircraft as well as unique things
    A Helicopter with commonalities with Aircraft as well as unique things
    Print instances of the above objects in console
*/
package com.springboot.application;
import com.springboot.application.objects.Aircraft;
import com.springboot.application.objects.Glider;
import com.springboot.application.objects.Jet;
import com.springboot.application.objects.Helicopter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation marks the main class of a Sring Boot application
@SpringBootApplication
public class Application {
    // Program is being ran in this main function
    public static void main(String[] args) {
      // Creating objects - Aircraft itself is an abstract class, therefore, it can't be instantiated
      Aircraft myGlider = new Glider("YX2000", "Front", "50 ft", 1, 30, 15, "Beagle Husky");
      Aircraft myJet = new Jet("N904DE", "Front", "38.7 ft", 2, 13, 24, "Jet A-1", "Turbojet");
      Aircraft myHelicopter = new Helicopter("N721AF", "Front", "20 ft", 3, 45, 33, 14, 500);

      // Printing instances to console
      System.out.println("---------- Glider's details ----------");
      myGlider.printDetails();
      System.out.println("---------- Jet's details ----------");
      myJet.printDetails();
      System.out.println("---------- Helicopter's details ----------");
      myHelicopter.printDetails();

      // Runs the application    
      SpringApplication.run(Application.class, args);
    }
}