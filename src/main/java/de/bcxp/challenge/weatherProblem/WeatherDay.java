package de.bcxp.challenge.weatherProblem;

public class WeatherDay {
     // day of the month (1-31)
     private int day;

     // minimum temperature of the day
     private float minTemp;
 
     // maximum temperature of the day
     private float maxTemp;

     /**
      * @return day of the month
      */
     public int getDay() {
         return day;
     }
 
     /**
      * @param day day of the month
      */
     public void setDay(int day) {
         this.day = day;
     }
 
     /**
      * @return minimum temperature of the day
      */
     public float getMinTemp() {
         return minTemp;
     }
 
     /**
      * @param minimumTemperature minimum temperature of the day
      */
     public void setMinTemp(float minimumTemperature) {
         this.minTemp = minimumTemperature;
     }
 
     /**
      * @return maximum temperature of the day
      */
     public float getMaxTemp() {
         return maxTemp;
     }
 
     /**
      * @param maximumTemperature maximum temperature of the day
      */
     public void setMaxTemp(float maximumTemperature) {
         this.maxTemp = maximumTemperature;
     }
 
}