
import org.junit.rules.ExternalResource;
import org.sql2o.*;
import org.sql2o.Connection;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "mumo", "pw*kinyanjui*");
    }

    @Override
    protected void after() {
        String deleteAnimalsQuery = "DELETE FROM animals *;";

        String deleteEndangeredAnimalsQuery = "DELETE FROM endangered_animals *;";
        String deleteSightingsQuery = "DELETE FROM sightings *;";
        try(Connection con = DB.sql2o.open()) {
            ((org.sql2o.Connection) con).createQuery(deleteAnimalsQuery).executeUpdate();
            ((org.sql2o.Connection) con).createQuery(deleteEndangeredAnimalsQuery).executeUpdate();
            ((org.sql2o.Connection) con).createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
}