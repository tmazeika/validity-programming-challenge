package me.mazeika.validity.dedup;

import me.mazeika.validity.csv.PersonEntry;
import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.text.similarity.LevenshteinDistance;

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

        for (int i = 0; i < entries.size(); i++) {
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
     * Gets whether the given two PersonEntry's are likely to be duplicates,
     * ignoring ID's.
     *
     * @param p1 the first person
     * @param p2 the second person
     *
     * @return whether the two PersonEntry's are likely to be duplicates
     */
    private boolean isDuplicate(PersonEntry p1, PersonEntry p2)
    {
        final LevenshteinDistance dist =
                LevenshteinDistance.getDefaultInstance();
        final Metaphone meta = new Metaphone();

        // we'll use p1 as the base, so we'll see if p2 is a duplicate

        // let's start with names: 1 mistake allowed per 4 characters
        final int firstNameThreshold = p1.getFirstName().length() / 4 + 1;
        final int lastNameThreshold = p1.getFirstName().length() / 4 + 1;

        final String p1FirstName = p1.getFirstName().toLowerCase();
        final String p2FirstName = p2.getFirstName().toLowerCase();
        final String p1LastName = p1.getLastName().toLowerCase();
        final String p2LastName = p2.getLastName().toLowerCase();

        // both Levenshteins should be in range, and if so, then at least one
        // pair should be a metaphone
        boolean nameCheck = dist.apply(p1FirstName, p2FirstName)
                    <= firstNameThreshold
                && dist.apply(p1LastName, p2LastName)
                    <= lastNameThreshold
                && (meta.isMetaphoneEqual(p1FirstName, p2FirstName)
                    || meta.isMetaphoneEqual(p1LastName, p2LastName));

        // let's allow 2 mistakes in the email
        final String p1Email = p1.getEmail().toLowerCase();
        final String p2Email = p2.getEmail().toLowerCase();

        boolean emailCheck = dist.apply(p1Email, p2Email) <= 2;

        // let's allow 1 mistake in the address1 excluding any dots (address2
        // is usually insignificant), or if one or both are empty, we can't
        // really do anything with that so we say it checks out
        final String p1Address1 = p1.getAddress1().toLowerCase()
                .replace(".", "");
        final String p2Address1 = p2.getAddress2().toLowerCase()
                .replace(".", "");

        boolean addressCheck = dist.apply(p1Address1, p2Address1) <= 1
                || p1Address1.isEmpty() || p2Address1.isEmpty();

        // let's allow 1 mistake in the phone, excluding any '-'s
        final String p1Phone = p1.getPhone().replace("-", "");
        final String p2Phone = p2.getPhone().replace("-", "");

        boolean phoneCheck = dist.apply(p1Phone, p2Phone) <= 1;

        // check some other fields for straight equality
        boolean miscCheck = (p1.getCity().isEmpty()
                    || p2.getCity().isEmpty()
                    || p1.getCity().equalsIgnoreCase(p2.getCity()))
                && (p1.getStateShort().isEmpty()
                    || p2.getStateShort().isEmpty()
                    || p1.getStateShort().equalsIgnoreCase(p2.getStateShort()));

        return nameCheck && emailCheck && addressCheck && phoneCheck && miscCheck;
    }
}
