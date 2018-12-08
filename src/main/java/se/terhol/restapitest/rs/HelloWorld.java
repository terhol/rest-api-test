package se.terhol.restapitest.rs;

import se.terhol.restapitest.db.PersonCreator;
import se.terhol.restapitest.dto.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Tereza Holm
 */
@Path("/hello")
public class HelloWorld {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        PersonCreator pc = new PersonCreator();
        Person randomPerson = pc.getRandomPerson();

        return randomPerson == null ? "Hello world!" : "Hello " + randomPerson.getFirstName() + "!";
    }
}
