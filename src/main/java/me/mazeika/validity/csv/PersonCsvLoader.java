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
public class PersonCsvLoader implements CsvLoader<PersonEntry>
{
    @Override
    public List<PersonEntry> load(String csv) throws IOException
    {
        final List<PersonEntry> entries = new ArrayList<>();

        boolean afterHeader = false;

        try (final InputStreamReader reader = new FileReader(new File(csv));
             final Scanner scanner = new Scanner(reader)) {

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();

                // skip the header
                if (afterHeader) {
                    entries.add(new PersonEntry(line));
                }
                else {
                    afterHeader = true;
                }
            }
        }

        return entries;
    }
}
