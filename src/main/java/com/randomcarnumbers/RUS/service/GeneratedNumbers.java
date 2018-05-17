package com.randomcarnumbers.RUS.service;

import com.randomcarnumbers.RUS.model.CarNumber;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GeneratedNumbers {

    public final static char[] LETTERS = new char[]{'А', 'Е', 'Т', 'О', 'Р', 'Н', 'У', 'К', 'Х', 'С', 'В', 'М'};

    private Random random = new Random();

    private LinkedList<CarNumber> generatedNumbers = new LinkedList<>();

    public CarNumber generate(){
        Character c1 = LETTERS[random.nextInt(12)];
        Character c2 = LETTERS[random.nextInt(12)];
        Character c3 = LETTERS[random.nextInt(12)];

        int rnd1 =  (int)(Math.random() * 10);
        int rnd2 =  (int)(Math.random() * 10);
        int rnd3 =  (int)(Math.random() * 10);
        CarNumber carNumber = new CarNumber(c1, c2, rnd1, rnd2, rnd3, c3);

        if (!generatedNumbers.contains(carNumber)) {
            generatedNumbers.add(carNumber);
        } else {
            generate();
        }

        return carNumber;
    }

    public CarNumber next(){
        CarNumber carNumber = generatedNumbers.getLast();

        if (carNumber != null){

            if(carNumber.getCore1() == 9 && carNumber.getCore2() == 9 && carNumber.getCore3() == 9){
                carNumber.setCore1(0);
                carNumber.setCore2(0);
                carNumber.setCore3(1);

                char c = carNumber.getThirdLetter();
                int pos=0;

                for (int i=0; i < LETTERS.length; i++) {
                    if (c == LETTERS[i]) {
                        pos = i;
                        break;
                    }
                }

                if (pos >= 11){
                    carNumber.setThirdLetter(LETTERS[0]);
                } else {
                    carNumber.setThirdLetter(LETTERS[pos+1]);
                }

            } else if (carNumber.getCore3() + 1 > 9){
                carNumber.setCore3(0);
                if (carNumber.getCore2() + 1 > 9) {
                    carNumber.setCore2(0);
                    if (carNumber.getCore1() + 1 > 9) {
                        carNumber.setCore1(0);
                    } else {
                        carNumber.setCore1(carNumber.getCore1() + 1);
                    }
                } else {
                    carNumber.setCore2(carNumber.getCore2() + 1);
                }
            } else {
                carNumber.setCore3(carNumber.getCore3() + 1);
            }
            return carNumber;
        }
        return null;
    }
}
