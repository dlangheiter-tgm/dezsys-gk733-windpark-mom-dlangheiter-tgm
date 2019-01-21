package windengineServer.rest;

import general.WindengineData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import windengineServer.model.WindengineDataList;
import windengineServer.model.WindparkModel;

import java.util.Collection;

@RestController
public class RestInterface {

    @RequestMapping("/")
    public String getWindengine() {
        return "This is the windengine application! (DEZSYS_GK72_WINDPARK) <br/><br/>\n" +
                "<a href='/windengine/001/data/xml'>Link to windengine/001/data/xml</a><br/>\n" +
                "<a href='/windengine/001/data/json'>Link to windengine/001/data/json</a><br/>\n" +
                "<a href='/windengine/002/data/xml'>Link to windengine/002/data/xml</a><br/>\n" +
                "<a href='/windengine/002/data/json'>Link to windengine/002/data/json</a><br/>\n" +
                "<a href='/logout'>Logout</><br>\n";
    }

    @RequestMapping(value = "/windengine/data/json", produces = "application/json")
    public WindengineDataList windenginesJson() {
        return WindparkModel.getAllWindengineData();
    }

    @RequestMapping(value = "/windengine/data/xml", produces = "application/xml")
    public WindengineDataList windenginesXml() {
        return WindparkModel.getAllWindengineData();
    }

    @RequestMapping(value = "/windengine/{windengineID}/data/xml", produces = "application/xml")
    public WindengineData windengineDataXml(@PathVariable String windengineID) {
        return WindparkModel.getEngineData(windengineID);
    }

    @RequestMapping(value = "/windengine/{windengineID}/data/json", produces = "application/json")
    public WindengineData windengineDataJson(@PathVariable String windengineID) {
        return WindparkModel.getEngineData(windengineID);
    }

}
