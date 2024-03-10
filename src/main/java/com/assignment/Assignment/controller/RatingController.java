package com.assignment.Assignment.controller;

import com.assignment.Assignment.model.Rating;
import com.assignment.Assignment.model.User;
import com.assignment.Assignment.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RatingController {
    @Autowired
    private RatingRepo ratingRepo;
    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getAllRatings(){
        try {
            List<Rating> ratingList = new ArrayList<>(ratingRepo.findAll());
            if(ratingList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ratingList,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/getUserById/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id){
//        Optional<User> user = userRepo.findById(id);
//        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping("/addUser")
//    public ResponseEntity<User> addUser(@RequestBody User user){
//        User userObj = userRepo.save(user);
//        return new ResponseEntity<>(userObj,HttpStatus.OK);
//    }

}


