package com.randomcarnumbers.RUS.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CarNumber {

    private static final String TAIL = "116RUS";

    private char firstLetter;
    private char secondLetter;
    private int core1, core2, core3;
    char thirdLetter;


    public CarNumber(char firstLetter, char secondLetter, int core1, int core2, int core3, char thirdLetter) {
        this.firstLetter = firstLetter;
        this.secondLetter = secondLetter;
        this.core1 = core1;
        this.core2 = core2;
        this.core3 = core3;
        this.thirdLetter = thirdLetter;
    }

    @Override
    public String toString() {
        return "CarNumber{" +
                 firstLetter +
                 secondLetter +
                 core1 +
                 core2 +
                 core3 +
                " " + thirdLetter +
                " " + TAIL +
                '}';
    }
}
