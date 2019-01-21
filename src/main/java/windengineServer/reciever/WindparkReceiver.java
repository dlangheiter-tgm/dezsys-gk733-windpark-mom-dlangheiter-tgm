package windengineServer.reciever;

import general.WindengineData;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import windengineServer.model.WindparkModel;

@Component
public class WindparkReceiver {

    @JmsListener(destination = "engineData", containerFactory = "myFactory")
    public void receiveMessage(WindengineData message) {
        System.out.println("Received <" + message + ">");
        WindparkModel.addEngineEntry(message);
    }

}
	
