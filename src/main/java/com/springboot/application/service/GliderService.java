package com.springboot.application.service;
import com.springboot.application.model.Glider;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class GliderService {
    // Creating an array list to hold glider objects with index numbers automatically assigned
    // using List<Glider> over ArrayList<Glider> because it provides faster objects manipulation
    private final List<Glider> gliders = new ArrayList<>();
    
    // Return current list of gliders
    public List<Glider> getGliders() {
        return gliders;
    }

    // Create a list of glider objects
    public void createGlider(String tailNum, String cockpitLoc, String wingsLength, int wheelsNum, int length, int width, String towPlaneName) {
        Glider myGlider = new Glider(tailNum, cockpitLoc, wingsLength, wheelsNum, length, width, towPlaneName);
        gliders.add(myGlider);
    }

    // TODO: currently fixing this
    public void deleteGlider(String tailNumber) {
        for (Glider glider : gliders) {
            if (tailNumber == glider.getTailNumber()) {
                
                gliders.remove(glider);
            }
        }
    }


    //public void findGliderByTailNum();
}
