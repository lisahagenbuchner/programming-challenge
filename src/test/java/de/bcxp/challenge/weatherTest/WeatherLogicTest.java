package de.bcxp.challenge.weatherTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.bcxp.challenge.weatherProblem.WeatherDay;
import de.bcxp.challenge.weatherProblem.WeatherLogic;

import java.util.List;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherLogicTest {

    private ArrayList<WeatherDay> dailyWeather = new ArrayList<WeatherDay>();

    @BeforeEach
    public void setup() {
        WeatherDay day1 = new WeatherDay();
        WeatherDay day2 = new WeatherDay();
        day1.setDay(1);
        day1.setMinTemp(10);
        day1.setMaxTemp(20);
        day2.setDay(2);
        day2.setMinTemp(10);
        day2.setMaxTemp(15);

        dailyWeather.add(day1);
        dailyWeather.add(day2);

    }

    @Test
    public void testGetMinTempSpreadDay() {
        int expected = 2;
        int actual = new WeatherLogic().getMinTempSpreadDay(dailyWeather);

        assertEquals(expected, actual);
    }
    
   @Test
   public void testGetWeatherDays() {
        String filePath = "src/test/resources/de/bcxp/challenge/testWeather.csv";
        WeatherLogic weatherLogic = new WeatherLogic();
        List<WeatherDay> actual = weatherLogic.getDailyTemps(filePath);
        assertEquals(dailyWeather.size(), actual.size());
    }
    
 

}
