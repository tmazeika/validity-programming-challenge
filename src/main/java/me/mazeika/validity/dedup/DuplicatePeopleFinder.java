package me.mazeika.validity.dedup;

import me.mazeika.validity.csv.PersonEntry;

import java.util.List;

/**
 * Represents a finder of duplicate entries of people.
 */
public class DuplicatePeopleFinder implements DuplicateFinder<PersonEntry>
{
    @Override
    public List<List<PersonEntry>> findDuplicates(List<PersonEntry> entries)
    {
        return null;
    }
}
