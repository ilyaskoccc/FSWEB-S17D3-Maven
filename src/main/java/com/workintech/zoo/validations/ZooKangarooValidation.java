package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKangarooValidation {
    public static void isIdValid(Integer id) {
        if(id == null || id < 0) {
            throw new ZooException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangaroos, Integer id, boolean existence) {
        if(existence) {
            if(!kangaroos.containsKey(id)) {
                throw new ZooException("Record is not exist: " + id, HttpStatus.NOT_FOUND);
            }
        } else {
            if(kangaroos.containsKey(id)) {
                throw new ZooException("Record is allready exist: " + id, HttpStatus.BAD_REQUEST);
            }
        }
    }


    public static void checkKangarooId(Integer id) {
        if(id == null || id <= 0) {
            throw new ZooException("Id shouldn't be null or less then zero: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKangarooName(String name) {
        if(name == null || name.isEmpty()) {
            throw new ZooException("Name shouldn't be null or is empty: " + name, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKangarooHeight(Double height) {
        if(height == null || height <= 0) {
            throw new ZooException("Height shouldn't be null or less then zero: " + height, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKangarooWeight(Double weight) {
        if(weight == null || weight <= 0) {
            throw new ZooException("Weight shouldn't be null or less then zero: " + weight, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKangarooGender(String gender) {
        if(gender == null || (!gender.equals("Male") && !gender.equals("Female"))) {
            throw new ZooException("Gender shouldn't be null or invalid: " + gender, HttpStatus.BAD_REQUEST);
        }
    }
}
