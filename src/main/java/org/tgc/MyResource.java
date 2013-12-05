package org.tgc;

import org.tgc.model.Itinerary;
import org.tgc.model.Lines;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Itinerary getIt() {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://m.stib.be/api");

        WebTarget helloworldWebTarget = webTarget.path("getitinerary.php");

        WebTarget helloworldWebTargetWithQueryParam =
                helloworldWebTarget.queryParam("lang", "en").queryParam("line","19").queryParam("iti","1");

        Invocation.Builder invocationBuilder =
                helloworldWebTargetWithQueryParam.request(MediaType.APPLICATION_XML);
        invocationBuilder.header("some-header", "true");

        Response response = invocationBuilder.get();


        Itinerary it = null ;
        try {
            it = EntityMarshallingUtils.marshal(Itinerary.class, response.readEntity(String.class));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return it;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("lines")
    public Lines gotIt() {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://m.stib.be/api");

        WebTarget helloworldWebTarget = webTarget.path("getlinesnew.php").queryParam("lang","en");

        Invocation.Builder invocationBuilder =
                helloworldWebTarget.request(MediaType.APPLICATION_XML);

        Response response = invocationBuilder.get();

        Lines lines = null;

        try {
            lines = EntityMarshallingUtils.marshal(Lines.class,response.readEntity(String.class));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return lines;

    }
}
