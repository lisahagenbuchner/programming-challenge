package de.bcxp.challenge.readerTest;

import org.junit.jupiter.api.Test;

import de.bcxp.challenge.reader.CSVreader;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CSVreaderTest {
    String resourceTestFile = "src/test/resources/de/bcxp/challenge/testWeather.csv";
    String resourceEmpty = "src/test/resources/de/bcxp/challenge/empty.csv";
    String resourceNotExistent = "src/test/resources/de/bcxp/challenge/notExistent.csv";
    
    @Test
    public void testRead() {
        ArrayList<String[]> expected = new ArrayList<String[]>();
        expected.add(new String[]{"Day", "Mxt", "Mnt"});
        expected.add(new String[]{ "1", "18", "15"});
        expected.add(new String[]{ "1", "20", "10"});
        ArrayList<String[]> actual = new CSVreader().read(resourceTestFile, ",");
        assertEquals(expected.get(0)[0], actual.get(0)[0]);
        assertEquals(expected.get(1)[1], actual.get(1)[1]);
    }
    
    @Test
    public void testReadEmpty() {        
        assertThrows(RuntimeException.class, () -> {
            new CSVreader().read(resourceEmpty, ",");
        });
    }

    @Test
    public void testWrongDelimiter() {        
        assertThrows(RuntimeException.class, () -> {
            new CSVreader().read(resourceEmpty, ";");
        });   
    }

    @Test
    public void testReadNotExistent() {
        assertThrows(RuntimeException.class, () -> {
            new CSVreader().read(resourceNotExistent, ",");
        });
    }
}
