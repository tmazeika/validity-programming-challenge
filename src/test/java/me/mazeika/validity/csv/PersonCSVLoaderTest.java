package me.mazeika.validity.csv;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class PersonCSVLoaderTest
{
    private PersonCSVLoader loader;

    @Before
    public void setUp()
    {
        this.loader = new PersonCSVLoader(Objects.requireNonNull(
                getClass().getClassLoader().getResource("small.csv")
        ).getFile());
    }

    @Test
    public void testLoadPeopleSize() throws IOException
    {
        assertEquals(3, this.loader.loadPeople().size());
    }

    @Test
    public void testLoadPeopleProperties() throws IOException
    {
        final List<PersonEntry> people = this.loader.loadPeople();
        final PersonEntry person1 = people.get(0);
        final PersonEntry person2 = people.get(1);
        final PersonEntry person3 = people.get(2);

        assertEquals(1, person1.getId());
        assertEquals(2, person2.getId());
        assertEquals(3, person3.getId());
        assertEquals("Donalt", person1.getFirstName());
        assertEquals("McArthur", person2.getLastName());
        assertEquals("Quitzon, Schaefer and Gleason", person3.getCompany());
        assertEquals("dcanter0@nydailynews.com", person1.getEmail());
        assertEquals("43 Grover Parkway", person2.getAddress1());
        assertEquals("", person3.getAddress2());
        assertEquals("50335", person1.getZip());
        assertEquals("Atlanta", person2.getCity());
        assertEquals("California", person3.getStateLong());
        assertEquals("IA", person1.getStateShort());
        assertEquals("770-271-7837", person2.getPhone());
    }
}
