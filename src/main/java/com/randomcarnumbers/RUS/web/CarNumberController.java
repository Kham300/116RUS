package com.randomcarnumbers.RUS.web;

import com.randomcarnumbers.RUS.model.CarNumber;
import com.randomcarnumbers.RUS.service.GeneratedNumbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarNumberController {

    @Autowired
    GeneratedNumbers generatedNumbers;

    @GetMapping("number/generate")
    public ResponseEntity<String> generate(){
        CarNumber carNumber = generatedNumbers.generate();
        if (carNumber == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      return new ResponseEntity<>(carNumber.toString(), HttpStatus.OK);
    }

    @GetMapping("number/next")
    public ResponseEntity<String> next(){
        CarNumber carNumber = generatedNumbers.next();
        if (carNumber == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      return new ResponseEntity<>(carNumber.toString(), HttpStatus.OK);
    }


}
