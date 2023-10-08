package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private static final int KITTENS_COUNT = 1;

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        String actualResult = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();

        String expectedResult = "Кошачьи";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetKittens() {
        int actualResult = feline.getKittens();
        Mockito.verify(feline).getKittens(KITTENS_COUNT);

        assertEquals(KITTENS_COUNT, actualResult);
    }

    @Test
    public void testGetKittensWithKittensCount() {
        int kittensCount = 5;
        int actualResult = feline.getKittens(kittensCount);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals(kittensCount, actualResult);
    }
}

