
import org.sql2o.*;
import org.junit.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;
import static org.junit.Assert.*;

public class SightingTest{

    @Rule
    public DatabaseRule database = new DatabaseRule();

    private main.java.Sighting testSighting;
    private Animal  testAnimal;
    @Before
    public void setUp() {


        testSighting = new main.java.Sighting(1, "Zone A", "Ronald");
    }



    @Test
    public void Sighting_instantiatesCorrectly() {
        assertTrue(testSighting instanceof main.java.Sighting);
    }

    @Test
    public void getId_sightingInstantiatesWithId(){
        testSighting.save();
        assertTrue(testSighting.getId() > 0);
    }

    @Test
    public void getAnimalId_sightingInstantiatesWithAnimalId(){
        testSighting.save();
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    public void getLocation_sightingInstantiatesWithLocation(){
        testSighting.save();
        assertEquals("Zone A", testSighting.getLocation());
    }

    @Test
    public void getRangerName_sightingInstantiatesWithRangerName(){
        testSighting.save();
        assertEquals("Ronald", testSighting.getRangerName());
    }
    @Test
    public void equals_returnsTrueIfAllPropertiesAreTheSame() {
        main.java.Sighting anotherSighting = new main.java.Sighting(1, "Zone A", "Ronald");
        assertEquals(true, testSighting.equals(anotherSighting));
    }

    @Test
    public void save_assignsIdToObject() {
        testSighting.save();
        main.java.Sighting savedSighting = main.java.Sighting.all().get(0);
        assertEquals(testSighting.getId(), savedSighting.getId());
    }

    @Test
    public void save_insertsObjectIntoDatabase() {
        testSighting.save();
        assertTrue(main.java.Sighting.all().get(0).equals(testSighting));
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        testSighting.save();
        main.java.Sighting otherSighting = new main.java.Sighting(1, "Zone B",  "Baraka");
        otherSighting.save();
        assertEquals(true, main.java.Sighting.all().get(0).equals(testSighting));
        assertEquals(true, main.java.Sighting.all().get(1).equals(otherSighting));
    }

    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
        testSighting.save();
        main.java.Sighting otherSighting = new main.java.Sighting(1, "Zone B",  "Daniels");
        otherSighting.save();
        assertEquals(main.java.Sighting.find(otherSighting.getId()), otherSighting);
    }

    @Test
    public void delete_deletesSighting() {
        testSighting.save();
        testSighting.delete();
        assertEquals(0, main.java.Sighting.all().size());
    }

}