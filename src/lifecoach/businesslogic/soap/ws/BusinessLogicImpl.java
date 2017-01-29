package lifecoach.businesslogic.soap.ws;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.glassfish.jersey.client.ClientConfig;

import lifecoach.localdb.soap.ws.Achievement;
import lifecoach.localdb.soap.ws.Goal;
import lifecoach.localdb.soap.ws.HealthMeasureHistory;
import lifecoach.localdb.soap.ws.Measure;
import lifecoach.localdb.soap.ws.Person;
import lifecoach.storageservice.soap.ws.Storage;
import lifecoach.storageservice.soap.ws.StorageService;


//Service Implementation
@WebService(endpointInterface = "lifecoach.businesslogic.soap.ws.BusinessLogic",
	serviceName="BusinessLogic")
public class BusinessLogicImpl implements BusinessLogic {

	@Override
	public String savePersonMeasure(long personId, Measure newMeasure) {
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        double newValue = Double.valueOf(newMeasure.getMeasureValue());
        String type = newMeasure.getMeasureDefinition().getMeasureType();
        
        //Find previous measure of that type if exists
        Measure previous = null; 
        for(Measure m : storage.readPerson(personId).getCurrentHealth().getMeasure()){
        	if(m.getMeasureDefinition().getMeasureType().equals(type)){
        		previous = m;
        	}
        }

        //Find goal of that type if exists
        Goal goal = null;
        for(Goal g : storage.readGoalList(personId)){
           	if(g.getMeasureDefinition().getMeasureType().equals(type)){
        		goal = g;
        	}
        }

        if(previous != null && goal !=null){
            double diff = 0.0; 
    		double previousValue = Double.valueOf(previous.getMeasureValue());
    		double goalValue = Double.valueOf(goal.getValue());
			diff = goalValue - previousValue;
    		if(diff > 0){
    			if(newValue - previousValue > 0){
    				//congratz - getting closer    
    				if(newValue >= goalValue){
    					
    					storage.deleteGoal(new Holder<Long>(goal.getGid()));
    					Achievement completed = new Achievement();
    					//completed.set
    					
    					//storage.createAchievement(achievement)
    					//achievement done - override message
    				}     				
    			}
    			else{
    				//try harder
    			}
    		}
    		else{
    			if(newValue - previousValue < 0){
    				//congratz - getting closer
    				if(newValue <= goalValue){
    					//achievement done - override message
    				}
    			}
    			else{
    				//try harder
    			}
    		}
        }
        else if(goal != null){
    		double goalValue = Double.valueOf(goal.getValue());
        	if(newValue == goalValue){
        		//achievement unlocked
    		}
        }
        
        storage.savePersonMeasure(personId, newMeasure);
        return "link";
	}

}
