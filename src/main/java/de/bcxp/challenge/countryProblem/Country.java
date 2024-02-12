package de.bcxp.challenge.countryProblem;

public class Country {
     // name of the country
     private String countryName;

     // population of the country
     private int population;
 
     // area of the country
     private int area;
 
     /**
      * @return name of the country
      */
     public String getCountryName() {
         return countryName;
     }
 
     /**
      * @param countryName name of the country
      */
     public void setCountryName(String countryName) {
         this.countryName = countryName;
     }
 
     /**
      * @return population of the country
      */
     public int getPopulation() {
         return population;
     }
 
     /**
      * @param population population of the country
      */
     public void setPopulation(int population) {
         this.population = population;
     }
 
     /**
      * @return area of the country
      */
     public int getArea() {
         return area;
     }
 
     /**
      * @param area area of the country
      */
     public void setArea(int area) {
         this.area = area;
     }
 
}