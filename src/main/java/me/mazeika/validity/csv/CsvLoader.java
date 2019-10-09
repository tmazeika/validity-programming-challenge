package me.mazeika.validity.csv;

import java.io.IOException;
import java.util.List;

/**
 * Represents a loader of entries in a CSV file.
 *
 * @param <T> the type of entries
 */
public interface CsvLoader<T>
{
    /**
     * Loads the entries from the given CSV file.
     *
     * @return a list of the entries from the CSV file
     * @throws IOException when an exception occurs while reading the file
     */
    List<T> load(String csv) throws IOException;
}
