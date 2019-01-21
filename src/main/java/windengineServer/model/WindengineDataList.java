package windengineServer.model;

import general.WindengineData;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement
public class WindengineDataList {

    private Collection<WindengineData> windengine;

    public Collection<WindengineData> getWindengine() {
        return windengine;
    }

    public void setWindengine(Collection<WindengineData> windengine) {
        this.windengine = windengine;
    }
}
