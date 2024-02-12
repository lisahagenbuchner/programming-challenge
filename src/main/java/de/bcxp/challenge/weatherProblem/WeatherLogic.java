package de.bcxp.challenge.weatherProblem;

import java.util.List;

import de.bcxp.challenge.reader.CSVreader;

import java.util.ArrayList;
import java.util.Arrays;

public class WeatherLogic {
    /**
     * @param fileName
     * @return day of the month with the smallest temperature spread
     */
    public int getMinTempSpreadDay(List<WeatherDay> dailyTemps) {
        int minTempSpreadDay = 0;
        float minTempSpread = Float.MAX_VALUE;
        for(int i=1; i < dailyTemps.size(); ++i){
            float currentTempSpread = dailyTemps.get(i).getMaxTemp() - dailyTemps.get(i).getMinTemp();
            if (currentTempSpread < 0){
                throw new IllegalArgumentException("Negative temperature spread found. Please check the file for errors.");
            }
            if (currentTempSpread < minTempSpread){
                minTempSpread = currentTempSpread;
                minTempSpreadDay = dailyTemps.get(i).getDay();
            }
        }
        return minTempSpreadDay;
    }
    
    /**
     * @param fileName
     * @return List of WeatherDay objects with the daily temperatures
     */
    public List<WeatherDay> getDailyTemps(String filePath) {
        ArrayList<String[]> weatherData = new CSVreader().read(filePath, ",");
        List<WeatherDay> dailyTemps = new ArrayList<WeatherDay>();
        List<String> columnNames = Arrays.asList(weatherData.get(0));
        int dayIndex = columnNames.indexOf("Day");
        int minTempIndex = columnNames.indexOf("MnT");
        int maxTempIndex = columnNames.indexOf("MxT");
        if (dayIndex == -1 || minTempIndex == -1 || maxTempIndex == -1){
            System.out.println("Idices" +dayIndex + minTempIndex + maxTempIndex);
            throw new IllegalArgumentException("Expected columns not found in the file. Please check the file format.");
        }
        for(int i=1; i < weatherData.size(); ++i){
            WeatherDay weatherDay = new WeatherDay();
            weatherDay.setDay(Integer.parseInt(weatherData.get(i)[dayIndex]));
            weatherDay.setMinTemp(Float.parseFloat(weatherData.get(i)[minTempIndex]));
            weatherDay.setMaxTemp(Float.parseFloat(weatherData.get(i)[maxTempIndex]));
            dailyTemps.add(weatherDay);
        }
        return dailyTemps;
    }
}