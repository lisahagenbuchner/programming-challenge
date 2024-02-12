package de.bcxp.challenge.countryProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.bcxp.challenge.reader.CSVreader;

public class CountryLogic {
    /**
     * @param fileName
     * @return country with the highest population density
     */
    public String getMaxPopulationDensityCountry(List<Country> countries) {
        String highestPopulationDensityCountry = "";
        float highestPopulationDensity = 0;
        for(int i=0; i < countries.size(); ++i){
            float currentPopulationDensity = countries.get(i).getPopulation() / countries.get(i).getArea();
            if (currentPopulationDensity > highestPopulationDensity){
                highestPopulationDensity = currentPopulationDensity;
                highestPopulationDensityCountry = countries.get(i).getCountryName();
            }
        }
        return highestPopulationDensityCountry;
    }

    /**
     * @param fileName
     * @return List of Country objects with the countries population and area data
     */
    public List<Country> getCountries(String filePath) {
        ArrayList<String[]> countriesData = new CSVreader().read(filePath, ";");
        List<Country> countries = new ArrayList<Country>();
        List<String> columnNames = Arrays.asList(countriesData.get(0));
        int nameIndex = columnNames.indexOf("Name");
        int populationIndex = columnNames.indexOf("Population");
        int areaIndex = columnNames.indexOf("Area (km²)");
        try {
            if (nameIndex == -1 || populationIndex == -1 || areaIndex == -1){
                throw new IllegalArgumentException("Expected columns not found in the file. Please check the file format.");
            }
            
            for(int i=1; i < countriesData.size(); ++i){
                try {
                    Integer.valueOf(countriesData.get(i)[populationIndex]);
                    Integer.valueOf(countriesData.get(i)[areaIndex]);
                } catch (NumberFormatException e) {
                    System.out.println("WARNING: Population and Area should be numbers. Please check the file format in line " + i + " of file " + filePath + ". The data of " + countriesData.get(i)[nameIndex] + " was not read.");
                    continue;
                }
                Country country = new Country();
                country.setCountryName(countriesData.get(i)[nameIndex]);
                country.setPopulation(Integer.valueOf(countriesData.get(i)[populationIndex]));
                country.setArea(Integer.valueOf(countriesData.get(i)[areaIndex]));
                countries.add(country);
            }
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            throw new IllegalArgumentException(message, e);
        }
        return countries;
    }
}