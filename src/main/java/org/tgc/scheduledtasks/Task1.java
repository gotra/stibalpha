package org.tgc.scheduledtasks;

import org.tgc.EntityMarshallingUtils;
import org.tgc.model.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by rajeevguru on 29/11/13.
 */
public class Task1 {

    private Client client;



    public Lines getLines() {


        WebTarget webTarget = client.target("http://m.stib.be/api");

        WebTarget target = webTarget.path("getlinesnew.php").queryParam("lang","en");

        Invocation.Builder invocationBuilder =
                target.request(MediaType.APPLICATION_XML);

        Response response = invocationBuilder.get();

        Lines lines = null;

        try {
            lines = EntityMarshallingUtils.marshal(Lines.class, response.readEntity(String.class));
        } catch (JAXBException e) {
            e.printStackTrace();
            //todo put a logger or throw some exception
        }

        return lines;

    }

    public Task1() {
        this.client = ClientBuilder.newClient();
    }

    public List<Stop> getStops(Line line, int direction) {

        WebTarget webTarget = client.target("http://m.stib.be/api");

        WebTarget target = webTarget.path("getitinerary.php").queryParam("lang", "en").queryParam("line",line.getId()).queryParam("iti", direction);

        Invocation.Builder invocationBuilder =
                target.request(MediaType.APPLICATION_XML);


        Response response = invocationBuilder.get();


        Itinerary it = null ;
        try {
            it = EntityMarshallingUtils.marshal(Itinerary.class, response.readEntity(String.class));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return (it != null) ? it.getStops() : null;

    }


    public Schedules getSchedule(Line line, int direction, Stop stop) {

        WebTarget webTarget = client.target("http://m.stib.be/api");

        WebTarget target = webTarget.path("getschedule.php").queryParam("lang", "en")
                .queryParam("line",line.getId()).queryParam("iti",direction)
                .queryParam("halt", stop.getId());

        Invocation.Builder invocationBuilder =
                target.request(MediaType.APPLICATION_XML);


        Response response = invocationBuilder.get();

        Schedules schedules = null;

        try {
            schedules = EntityMarshallingUtils.marshal(Schedules.class, response.readEntity(String.class));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return schedules;

    }

    public void orchestrator() {

        Lines lines = this.getLines();
        if (lines!=null && lines.getLines()!=null) {

            for (Line line:lines.getLines()) {

                int count =0;

                for(String destination:line.getDestination()){

                        List<Stop> stops = getStops(line,++count);
                        for(Stop stop:stops) {
                            Schedules schedules = getSchedule(line,count,stop);

                            for (Schedule sch: schedules.getTimes()) {
                                Calendar cal = Calendar.getInstance();
                                cal.set(Calendar.HOUR_OF_DAY,sch.getHour());
                                for (Integer m: sch.getMinutes().getMinute()) {
                                    cal.set(Calendar.MINUTE,m);
                                }
                            }
                        }
                }


            }

        }

    }


}
