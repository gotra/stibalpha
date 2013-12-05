    package org.tgc.model;

    import javax.xml.bind.annotation.XmlAccessType;
    import javax.xml.bind.annotation.XmlAccessorType;
    import javax.xml.bind.annotation.XmlRootElement;
    import java.util.List;

    /**
     * Created by rajeevguru on 02/12/13.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "minutes")
    public class Minutes {




            private List<Integer> minute;

            public List<Integer> getMinute() {
                return minute;
            }

            public void setMinute(List<Integer> minute) {
                this.minute = minute;
            }

    }
