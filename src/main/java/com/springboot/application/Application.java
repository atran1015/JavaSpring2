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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation marks the main class of a Sring Boot application
@SpringBootApplication
public class Application {
    // Program is being ran in this main function
    public static void main(String[] args) {
      // Runs the application    
      SpringApplication.run(Application.class, args);
    }
}