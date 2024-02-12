package de.bcxp.challenge.reader;

import java.io.*;
import java.util.ArrayList;

public class CSVreader {
    /**
     * @param fileName 
     * @param delimiter character that separates the values in the file
     * @return ArrayList of string arrays with the data from the file
     */
    public ArrayList<String[]> read (String filePath, String delimiter) {

        BufferedReader reader = null;
        String line = "";
        ArrayList<String[]> list = new ArrayList<String[]>();
        
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while((line = reader.readLine()) != null) {
                String[] row = line.split(delimiter);
                list.add(row);
            }
            if (list.size() == 0){
                throw new IllegalArgumentException("The file " + filePath + " is empty.");
            }
        }
        catch (IllegalArgumentException e) {
            String message = e.getMessage();
            throw new RuntimeException(message, e);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Error reading the file: " + filePath + ". The delimiter is not present in the file.", e);
        }   
        catch (FileNotFoundException e) {
            throw new RuntimeException("No file found with the given filename: " + filePath, e);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}