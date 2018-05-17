package com.randomcarnumbers.RUS.service;

import com.randomcarnumbers.RUS.model.CarNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratedNumbersTest {

    @Test
    public void generate() {
    }

    @Test
    public void next() {
        final CarNumber carNumber = new CarNumber('A', 'A', 9, 9,9,'A');

        assertTrue('E' == carNumber.getThirdLetter());
    }

}