package com.springboot.application.service;
import com.springboot.application.model.Helicopter;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class HelicopterService {

    private final List<Helicopter> helicopters = new ArrayList<>();
    
    public List<Helicopter> getHelicopters() {
        return helicopters;
    }

    public Helicopter getOneHelicopter(String tailNumber) {
        Helicopter aHelicopter = new Helicopter();
        boolean helicopterExists = false;
        for (Helicopter helicopter : helicopters) {
            if (helicopter.getTailNumber().equals(tailNumber)) {
                aHelicopter = helicopter;
                helicopterExists = true;
            } 
        }

        if (!helicopterExists) {
            throw new NullPointerException();
        }
        
        return aHelicopter;
    }


    public void createHelicopter(String tailNum, int wheelsNum, int length, int rpm) {
        // TODO: check if rpm is null
        if (tailNum.isEmpty()) {
            throw new NullPointerException();
        }
        
        Helicopter myHelicopter = new Helicopter(tailNum, wheelsNum, length, rpm);
        helicopters.add(myHelicopter);
    }


    public boolean deleteHelicopter(String tailNumber) {
        var isRemoved = helicopters.removeIf(helicopter -> helicopter.getTailNumber().equals(tailNumber));
        return isRemoved;
    }

    // Find glider by tail number and then update old glider's information to new glider's information
    public boolean updateHelicopter(String tailNumber, Helicopter newHelicopterDetails) {
        boolean helicopterExists = false;
        // For-each loop
        for (Helicopter helicopter : helicopters) {
            if (helicopter.getTailNumber().equals(tailNumber)) {
                helicopterExists = true;
                // Using model's functions
                helicopter.setTailNumber(newHelicopterDetails.getTailNumber());
                helicopter.setNumberOfWheels(newHelicopterDetails.getNumberOfWheels());
                helicopter.setLength(newHelicopterDetails.getLength());
                helicopter.setRotorRpm(newHelicopterDetails.getRotorRpm());
            }
        }

        return helicopterExists;
    }
}
