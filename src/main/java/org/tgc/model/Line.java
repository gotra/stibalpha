package org.tgc.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by rajeevguru on 21/11/13.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "line")
public class Line {

    private String id;

    private String mode;



    @XmlElements(value = {
            @XmlElement(name = "destination1", type = String.class),
            @XmlElement(name = "destination2", type = String.class)
    })

    private List<String> destination;


    public Line() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getDestination() {
        return destination;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }
}
