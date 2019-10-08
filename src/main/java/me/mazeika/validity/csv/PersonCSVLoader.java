package me.mazeika.validity.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a load of {@link PersonEntry}'s.
 */
public class PersonCSVLoader
{
    private final File csvFile;

    /**
     * Constructs a loader of {@link PersonEntry}'s.
     *
     * @param file the name of the file
     */
    public PersonCSVLoader(String file)
    {
        this.csvFile = new File(file);
    }

    public List<PersonEntry> loadPeople() throws IOException
    {
        final List<PersonEntry> entries = new ArrayList<>();

        try (final InputStreamReader reader = new FileReader(this.csvFile);
             final Scanner scanner = new Scanner(reader)) {

            while (scanner.hasNextLine()) {
                entries.add(new PersonEntry(scanner.nextLine()));
            }
        }

        return entries;
    }
}
