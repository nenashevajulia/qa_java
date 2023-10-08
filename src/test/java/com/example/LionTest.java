package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeExeption() {
        Throwable throwable = catchThrowable(() -> {
            Lion lion = new Lion("Самец/самка", feline);
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage("Используйте допустимые значения пола животного - самец или самка");
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);

        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}
