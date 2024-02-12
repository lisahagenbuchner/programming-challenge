package de.bcxp.challenge;

import de.bcxp.challenge.weatherProblem.WeatherDay;
import de.bcxp.challenge.weatherProblem.WeatherLogic;

import java.util.ArrayList;
import java.util.List;

import de.bcxp.challenge.countryProblem.Country;
import de.bcxp.challenge.countryProblem.CountryLogic;
import de.bcxp.challenge.reader.CSVreader;


/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        
        String resourcesFolder = "src/main/resources/de/bcxp/challenge/";
        String weatherFile = resourcesFolder + "weather.csv";
        String countriesFile = resourcesFolder + "countries.csv";

        WeatherLogic weatherLogic = new WeatherLogic();
        CountryLogic countryLogic = new CountryLogic();

        List<WeatherDay> dailyTemps = weatherLogic.getDailyTemps(weatherFile);
        List<Country> countries = countryLogic.getCountries(countriesFile);

        int dayWithSmallestTempSpread = weatherLogic.getMinTempSpreadDay(dailyTemps);
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = countryLogic.getMaxPopulationDensityCountry(countries);
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
