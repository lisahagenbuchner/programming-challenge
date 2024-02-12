package de.bcxp.challenge.countryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.bcxp.challenge.countryProblem.Country;
import de.bcxp.challenge.countryProblem.CountryLogic;
import de.bcxp.challenge.reader.CSVreader;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountryLogicTest {
    

    private ArrayList<Country> countries = new ArrayList<Country>();

    @BeforeEach
    public void setup() {
        Country germany = new Country();
        Country spain = new Country();
        
        germany.setCountryName("Germany");
        germany.setPopulation(83000000);
        germany.setArea(357000 );

        spain.setCountryName("Spain");
        spain.setPopulation(47000000);
        spain.setArea(505000);

        countries.add(germany);
        countries.add(spain);
    }

    @Test
    public void testGetMaxPopulationDensityCountry() {
        String expected = "Germany";
        String actual = new CountryLogic().getMaxPopulationDensityCountry(countries);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetCountries() {
        String filePath = "src/test/resources/de/bcxp/challenge/testWeather.csv";
        CountryLogic countryLogic = new CountryLogic();
        assertThrows(IllegalArgumentException.class, () -> {
            countryLogic.getCountries(filePath);
        });
    }
    

}
