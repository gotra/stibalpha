package org.tgc.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by rajeevguru on 21/11/13.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "lines")
public class Lines {

    @XmlElement(name = "line", type = Line.class)
    private List<Line> lines;

    public Lines() {
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
