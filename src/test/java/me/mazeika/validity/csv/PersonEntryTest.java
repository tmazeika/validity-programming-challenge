package me.mazeika.validity.csv;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for PersonEntry.
 */
public class PersonEntryTest
{
    private PersonEntry kaleGipp;
    private PersonEntry analiseDoorbar;

    @Before
    public void setUp()
    {
        this.kaleGipp = new PersonEntry("4,Kale,Gipp,Klein Group," +
                "kgipp3@360.cn,4985 Menomonie Drive,,94975,Petaluma," +
                "California,CA,707-840-2551");
        this.analiseDoorbar = new PersonEntry("5,Analise,Doorbar,Stamm-Pagac," +
                "adoorbar4@mit.edu,2340 Dennis Center,Apt 11,33180,Miami," +
                "Florida,FL,305-604-6702");
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNullEntryLine()
    {
        new PersonEntry(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorBadId()
    {
        new PersonEntry("O,Donalt,Canter,Gottlieb Group,dcanter0@nydailynews" + ".com,9 Homewood Alley,,50335,Des Moines,Iowa,IA,515-601-4495");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTooFewArgs()
    {
        new PersonEntry("3,Akim,McAlpine,\"Quitzon, Schaefer and Gleason\"," + "amcalpine2@goo.gl,4 Kipling Drive,,93721,Fresno,California," + "CA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTooManyArgs()
    {
        new PersonEntry("2,Daphene,McArthur,\"West, Schimmel and Rath\"," +
                "dmcarthur1@twitter.com,43 Grover Parkway,,30311,Atlanta," +
                "Georgia,GA,770-271-7837,45");
    }

    @Test
    public void testGetId()
    {
        assertEquals(4, this.kaleGipp.getId());
        assertEquals(5, this.analiseDoorbar.getId());
    }

    @Test
    public void testGetFirstName()
    {
        assertEquals("Kale", this.kaleGipp.getFirstName());
        assertEquals("Analise", this.analiseDoorbar.getFirstName());
    }

    @Test
    public void testGetLastName()
    {
        assertEquals("Gipp", this.kaleGipp.getLastName());
        assertEquals("Doorbar", this.analiseDoorbar.getLastName());
    }

    @Test
    public void testGetCompany()
    {
        assertEquals("Klein Group", this.kaleGipp.getCompany());
        assertEquals("Stamm-Pagac", this.analiseDoorbar.getCompany());
    }

    @Test
    public void testGetEmail()
    {
        assertEquals("kgipp3@360.cn", this.kaleGipp.getEmail());
        assertEquals("adoorbar4@mit.edu", this.analiseDoorbar.getEmail());
    }

    @Test
    public void testGetAddress1()
    {
        assertEquals("4985 Menomonie Drive", this.kaleGipp.getAddress1());
        assertEquals("2340 Dennis Center", this.analiseDoorbar.getAddress1());
    }

    @Test
    public void testGetAddress2()
    {
        assertEquals("", this.kaleGipp.getAddress2());
        assertEquals("Apt 11", this.analiseDoorbar.getAddress2());
    }

    @Test
    public void testGetZip()
    {
        assertEquals("94975", this.kaleGipp.getZip());
        assertEquals("33180", this.analiseDoorbar.getZip());
    }

    @Test
    public void testGetCity()
    {
        assertEquals("Petaluma", this.kaleGipp.getCity());
        assertEquals("Miami", this.analiseDoorbar.getCity());
    }

    @Test
    public void testGetStateLong()
    {
        assertEquals("California", this.kaleGipp.getStateLong());
        assertEquals("Florida", this.analiseDoorbar.getStateLong());
    }

    @Test
    public void testGetStateShort()
    {
        assertEquals("CA", this.kaleGipp.getStateShort());
        assertEquals("FL", this.analiseDoorbar.getStateShort());
    }

    @Test
    public void testGetPhone()
    {
        assertEquals("707-840-2551", this.kaleGipp.getPhone());
        assertEquals("305-604-6702", this.analiseDoorbar.getPhone());
    }
}
