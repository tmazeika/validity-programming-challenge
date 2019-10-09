package me.mazeika.validity;

import me.mazeika.validity.csv.PersonCSVLoader;
import me.mazeika.validity.csv.PersonEntry;
import me.mazeika.validity.dedup.DuplicatePeopleFinder;
import me.mazeika.validity.web.WebServer;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Represents our main class.
 */
public class Validity
{
    private static final String CSV_FILE_NAME = "normal.csv";

    /**
     * Starts the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        final String normalCsvPath = Objects.requireNonNull(
                Validity.class.getClassLoader().getResource(CSV_FILE_NAME)
        ).getFile();

        final List<PersonEntry> people = new PersonCSVLoader(normalCsvPath)
                .loadPeople();

        final List<List<PersonEntry>> duplicates = new DuplicatePeopleFinder()
                .findDuplicates(people);

        new WebServer(duplicates).start();
    }
}
