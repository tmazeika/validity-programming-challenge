package me.mazeika.validity.dedup;

import me.mazeika.validity.csv.PersonEntry;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for DuplicatePeopleFinder.
 */
public class DuplicatePeopleFinderTest
{
    private DuplicatePeopleFinder finder;
    private List<PersonEntry> people;

    @Before
    public void setUp()
    {
        this.finder = new DuplicatePeopleFinder();
        this.people = new ArrayList<>(List.of(
                new PersonEntry("2,Daphene,McArthur," +
                        "\"West, Schimmel and Rath\",dmcarthur1@twitter.com," +
                        "43 Grover Parkway,,30311,Atlanta,Georgia," +
                        "GA,770-271-7837"),
                new PersonEntry("4,Kale,Gipp,Klein Group,kgipp3@360.cn,4985 " +
                        "Menomonie Drive,,94975,Petaluma,California,CA," +
                        "707-840-2551"),
                new PersonEntry("1,Donalt,Canter,Gottlieb Group," +
                        "dcanter0@nydailynews.com,9 Homewood Alley,,50335," +
                        "Des Moines,Iowa,IA,515-601-4495"),
                new PersonEntry("3,Akim,McAlpine," +
                        "\"Quitzon, Schaefer and Gleason\",amcalpine2@goo.gl," +
                        "4 Kipling Drive,,93721,Fresno,California,CA," +
                        "209-867-8571"),
                new PersonEntry("4,Kale,Gipp,The Klein Group,kgipp3@360.cn," +
                        "4985 Menomonie Drive,,94975,Petaluma,California,CA," +
                        "707-840-2551"),
                new PersonEntry("11,Barny,Parncutt," +
                        "\"Collier, Grady and Huels\"," +
                        "bparncutta@ezinearticles.com,07700 Rutledge Court,," +
                        "11205,Brooklyn,New York,NY,718-430-6357"),
                new PersonEntry("11,Barney,Parncutt," +
                        "\"Collier, Grady and Huels\"," +
                        "bparncutta@ezinearticles.com,07700 Rutledge Court,," +
                        "11205,Brooklyn,New York,NY,718-430-6357"),
                new PersonEntry("12,Janeczka,Addie,McDermott LLC," +
                        "jaddieb@bbb.org,947 Bunker Hill Place,,93399," +
                        "Bakersfield,California,CA,661-933-4345"),
                new PersonEntry("15,Jacquelyn,Ilchenko,Goodwin Inc," +
                        "jilchenkoe@wisc.edu,9160 Cherokee Avenue,,18763," +
                        "Wilkes Barre,Pennsylvania,PA,570-384-8352"),
                new PersonEntry("13,Gwynne,Eddington," +
                        "\"Christiansen, Gutmann and Ritchie\"," +
                        "geddingtonc@webnode.com,0 Artisan Place,Apt 7," +
                        "80126,Littleton,Colorado,CO,303-949-6227"),
                new PersonEntry("14,Guinna,Labden,Parisian-Luettgen," +
                        "glabdend@examiner.com,01 Mayer Trail,,79171," +
                        "Amarillo,Texas,TX,806-851-1176"),
                new PersonEntry("15,Jacqueline,Ilchenko,Goodwin Inc," +
                        "jilchenkoe@wisc.edu,9160 Cherokee Avenue,,18763," +
                        "Wilkes Barre,Pennsylvania,PA,570-384-8352")));
    }

    @Test(expected = NullPointerException.class)
    public void testFindDuplicatesNullEntries()
    {
        this.finder.findDuplicates(null);
    }

    @Test
    public void testFindDuplicatesSize()
    {
        final List<List<PersonEntry>> duplicates =
                this.finder.findDuplicates(people);

        assertEquals(3, duplicates.size());
    }

    @Test
    public void testFindDuplicates()
    {
        final List<List<PersonEntry>> duplicates =
                this.finder.findDuplicates(people);

        assertEquals(3, duplicates.size());
    }
}
