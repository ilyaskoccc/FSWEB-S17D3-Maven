package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKoalaValidation{
    public static void isIdValid(Integer id) {
        if(id == null || id < 0) {
            throw new ZooException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKoalaExistence(Map<Integer, Koala> koalas, Integer id, boolean existence) {
        if(existence) {
            if(!koalas.containsKey(id)) {
                throw new ZooException("Record is not exist: " + id, HttpStatus.NOT_FOUND);
            }
        } else {
            if(koalas.containsKey(id)) {
                throw new ZooException("Record is allready exist: " + id, HttpStatus.BAD_REQUEST);
            }
        }
    }


    public static void checkKoalaId(Integer id) {
        if(id == null || id <= 0) {
            throw new ZooException("Id shouldn't be null or less then zero: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKoalaName(String name) {
        if(name == null || name.isEmpty()) {
            throw new ZooException("Name shouldn't be null or is empty: " + name, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKoalaSleepHour(Double sleepHour) {
        if(sleepHour == null || sleepHour <= 0) {
            throw new ZooException("Sleep hour shouldn't be null or less then zero: " + sleepHour, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKoalaWeight(Double weight) {
        if(weight == null || weight <= 0) {
            throw new ZooException("Weight shouldn't be null or less then zero: " + weight, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKoalaGender(String gender) {
        if(gender == null || (!gender.equals("Male") && !gender.equals("Female"))) {
            throw new ZooException("Gender shouldn't be null or invalid: " + gender, HttpStatus.BAD_REQUEST);
        }
    }
}
