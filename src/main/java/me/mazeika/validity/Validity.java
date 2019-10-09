package me.mazeika.validity;

import me.mazeika.validity.csv.PersonCsvLoader;
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
    private static final String NORMAL_CSV_FILE_NAME = Objects.requireNonNull(
            Validity.class.getClassLoader().getResource("normal.csv")
    ).getFile();

    private static final String ADVANCED_CSV_FILE_NAME = Objects.requireNonNull(
            Validity.class.getClassLoader().getResource("advanced.csv")
    ).getFile();

    /**
     * Starts the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        final List<PersonEntry> people = new PersonCsvLoader()
                .load(NORMAL_CSV_FILE_NAME);

        final List<List<PersonEntry>> duplicates = new DuplicatePeopleFinder()
                .findDuplicates(people);

        new WebServer(duplicates).start();
    }
}
