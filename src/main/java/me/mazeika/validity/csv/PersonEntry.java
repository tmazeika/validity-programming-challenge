package me.mazeika.validity.csv;

import me.mazeika.validity.util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an entry of a person's details.
 */
public class PersonEntry
{
    private static final int COLUMN_COUNT = 12;

    private final String raw;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String email;
    private final String address1;
    private final String address2;
    private final String zip;
    private final String city;
    private final String stateLong;
    private final String stateShort;
    private final String phone;

    /**
     * Constructs a new PersonEntry from the given CSV entry line.
     *
     * @param entryLine the entry line from a CSV file
     */
    public PersonEntry(String entryLine)
    {
        Objects.nonNull(entryLine);

        final List<String> columns = new ArrayList<>();

        StringBuilder colBuilder = new StringBuilder();
        boolean inQuotes = false;

        for (char ch : entryLine.toCharArray()) {
            if (ch == '"') {
                // toggle inQuotes
                inQuotes = !inQuotes;
            } else if (inQuotes || ch != ',') {
                // we're either in quotes or we're between commas
                colBuilder.append(ch);
            } else {
                // we're at a comma; don't add it but also count what we've
                // read so far as a column
                columns.add(colBuilder.toString());
                colBuilder = new StringBuilder();
            }
        }

        Validation.requireThat("Must have exactly " + COLUMN_COUNT + " columns",
                columns.size() == COLUMN_COUNT);

        try {
            this.id = Integer.parseInt(columns.get(0));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(
                    "The ID must be an integer", ex);
        }

        this.raw = entryLine;
        this.firstName = columns.get(1);
        this.lastName = columns.get(2);
        this.company = columns.get(3);
        this.email = columns.get(4);
        this.address1 = columns.get(5);
        this.address2 = columns.get(6);
        this.zip = columns.get(7);
        this.city = columns.get(8);
        this.stateLong = columns.get(9);
        this.stateShort = columns.get(10);
        this.phone = columns.get(11);
    }

    /**
     * Gets the ID of this entry.
     *
     * @return this entry's ID
     */
    public int getId()
    {
        return this.id; // TODO
    }

    /**
     * Gets the first name of this person.
     *
     * @return this person's first name
     */
    public String getFirstName()
    {
        return this.firstName; // TODO
    }

    /**
     * Gets the last name of this person.
     *
     * @return this person's last name
     */
    public String getLastName()
    {
        return this.lastName; // TODO
    }

    /**
     * Gets the company that this person works at.
     *
     * @return this person's company
     */
    public String getCompany()
    {
        return this.company; // TODO
    }

    /**
     * Gets the email of this person.
     *
     * @return this person's email
     */
    public String getEmail()
    {
        return this.email; // TODO
    }

    /**
     * Gets the address line 1 of this person.
     *
     * @return this person's address line 1
     */
    public String getAddress1()
    {
        return this.address1; // TODO
    }

    /**
     * Gets the address line 2 of this person.
     *
     * @return this person's address line 2
     */
    public String getAddress2()
    {
        return this.address2; // TODO
    }

    /**
     * Gets the ZIP code of this person's home.
     *
     * @return this person's home ZIP code
     */
    public String getZip()
    {
        return this.zip; // TODO
    }

    /**
     * Gets the city of this person's home.
     *
     * @return this person's home city
     */
    public String getCity()
    {
        return this.city; // TODO
    }

    /**
     * Gets the state of this person in long form (e.g. "New Jersey" instead of
     * "NJ").
     *
     * @return this person's home state in long form
     */
    public String getStateLong()
    {
        return this.stateLong; // TODO
    }

    /**
     * Gets the state of this person in short form (e.g. "NJ" instead of "New
     * Jersey").
     *
     * @return this person's home state in short form
     */
    public String getStateShort()
    {
        return this.stateShort; // TODO
    }

    /**
     * Gets the phone number of this person.
     *
     * @return this person's phone number
     */
    public String getPhone()
    {
        return this.phone; // TODO
    }

    /**
     * Returns the raw entry line from the CSV file.
     *
     * @return the raw CVS entry
     */
    @Override
    public String toString()
    {
        return null; // TODO
    }
}
