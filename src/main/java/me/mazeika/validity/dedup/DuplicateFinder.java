package me.mazeika.validity.dedup;

import java.util.List;

/**
 * Represents a finder of duplicate entries.
 *
 * @param <T> the type of entries
 */
public interface DuplicateFinder<T>
{
    /**
     * Finds and groups duplicate entries.
     *
     * @param entries the entries for which we want to find duplicates
     *
     * @return a list of the duplicate groups, in the order found in the entries
     */
    List<List<T>> findDuplicates(List<T> entries);
}
