package me.mazeika.validity.dedup;

import me.mazeika.validity.csv.PersonEntry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Represents a finder of duplicate entries of people.
 */
public class DuplicatePeopleFinder implements DuplicateFinder<PersonEntry>
{
    @Override
    public List<List<PersonEntry>> findDuplicates(List<PersonEntry> entries)
    {
        Objects.nonNull(entries);

        // don't modify the underlying ArrayList argument
        entries = new ArrayList<>(entries);

        final List<List<PersonEntry>> result = new ArrayList<>();

        for (int i = 0; i < entries.size() - 1; i++) {
            final PersonEntry p1 = entries.get(i);
            // p1 duplicates contains itself
            final List<PersonEntry> p1Duplicates = new ArrayList<>(List.of(p1));
            final Iterator<PersonEntry> p2Iterator =
                    entries.listIterator(i + 1);

            while (p2Iterator.hasNext()) {
                final PersonEntry p2 = p2Iterator.next();

                // if we have a duplicate, say that p2 is a duplicate of p1
                // and then add p2 to the p1Duplicates list, and don't
                // process it in the future
                if (this.isDuplicate(p1, p2)) {
                    p1Duplicates.add(p2);
                    p2Iterator.remove();
                }
            }

            result.add(p1Duplicates);
        }

        return result;
    }

    /**
     * Gets whether the given two PersonEntry's are likely to be duplicates.
     *
     * @param p1 the first person
     * @param p2 the second person
     * @return whether the two PersonEntry's are likely to be duplicates
     */
    private boolean isDuplicate(PersonEntry p1, PersonEntry p2)
    {
        return false; // TODO
    }
}
