package com.springboot.application.service;
import com.springboot.application.model.Glider;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class GliderService {
    // Creating an array list to hold glider objects with index numbers automatically assigned
    // Using List<Glider> over ArrayList<Glider> because it provides faster objects manipulation
    private final List<Glider> gliders = new ArrayList<>();
    
    // Return current list of gliders
    public List<Glider> getGliders() {
        return gliders;
    }

    // Return a glider object
    public Glider getOneGlider(String tailNumber) {
        Glider aGlider = new Glider();
        boolean gliderExists = false;
        for (Glider glider : gliders) {
            if (glider.getTailNumber().equals(tailNumber)) {
                aGlider = glider;
                gliderExists = true;
            } 
        }

        // Service throws error if glider with corresponding tail number cannot be found
        if (!gliderExists) {
            throw new NullPointerException();
        }
        
        return aGlider;
    }

    // Create a list of glider objects
    public void createGlider(String tailNum, int wheelsNum, int length, String towPlaneName) {
        if (towPlaneName.isEmpty() || tailNum.isEmpty()) {
            throw new NullPointerException();
        }
        
        Glider myGlider = new Glider(tailNum, wheelsNum, length, towPlaneName);
        gliders.add(myGlider);
    }

    // Returns a bool after removing the correct glider associated with the tail number
    public boolean deleteGlider(String tailNumber) {
        var isRemoved = gliders.removeIf(glider -> glider.getTailNumber().equals(tailNumber));
        return isRemoved;
    }

    // Find glider by tail number and then update old glider's information to new glider's information
    public boolean updateGlider(String tailNumber, Glider newGliderDetails) {
        boolean gliderExists = false;
        // For-each loop
        for (Glider glider : gliders) {
            if (glider.getTailNumber().equals(tailNumber)) {
                gliderExists = true;
                // Using model's functions
                glider.setTailNumber(newGliderDetails.getTailNumber());
                glider.setNumberOfWheels(newGliderDetails.getNumberOfWheels());
                glider.setLength(newGliderDetails.getLength());
                glider.setTowPlaneName(newGliderDetails.getTowPlaneName());
            }
        }

        return gliderExists;
    }
}
