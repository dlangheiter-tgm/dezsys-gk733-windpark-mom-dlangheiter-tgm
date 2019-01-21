package windengineServer.model;

import general.WindengineData;

import java.util.HashMap;
import java.util.Set;

public class WindparkModel {

    private static HashMap<String, WindengineData> engineData = new HashMap<>();

    public static Set<String> getWindengines() {
        return WindparkModel.engineData.keySet();
    }

    public static WindengineDataList getAllWindengineData() {
        WindengineDataList ret = new WindengineDataList();
        ret.setWindengine(WindparkModel.engineData.values());
        return ret;
    }

    public static void addEngineEntry(WindengineData windengineData) {
        WindparkModel.engineData.put(windengineData.getWindengineID(), windengineData);
    }

    public static void setEngineData(String id, WindengineData windengineData) {
        WindparkModel.engineData.put(id, windengineData);
    }

    public static WindengineData getEngineData(String id) {
        return WindparkModel.engineData.get(id);
    }
}
