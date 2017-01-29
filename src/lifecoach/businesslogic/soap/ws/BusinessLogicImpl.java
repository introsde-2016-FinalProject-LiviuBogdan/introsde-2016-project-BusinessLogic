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
	
	private final String completedTopic = "achievement";
	private final String progressTopic = "cat";
	private final String encourageTopic = "encourage";

	@Override
	public Feedback savePersonMeasure(long personId, Measure newMeasure) {

		Feedback feedback = new Feedback(); 
		
        StorageService service = new StorageService();
        Storage storage = service.getStorageImplPort();
        
        //Generalising integer and double as doubles for simplicity
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
        
        //If previous measure and goal of that type exist then the goal is still active (can deduce goal semantic)
        if(previous != null && goal !=null){
            double diff = 0.0; 
    		double previousValue = Double.valueOf(previous.getMeasureValue());
    		double goalValue = Double.valueOf(goal.getValue());
			diff = goalValue - previousValue;
			
			//Case: goal to beat (newMeasure must be => goalValue)
    		if(diff > 0){
    			//getting closer to the goal than previously
    			if(newValue - previousValue > 0){
    				//beat the goal
    				if(newValue >= goalValue){
    					feedback = this.completeAchievement(feedback, storage, goal, newMeasure);
    				//did not beat the goal but progressing
    				} else {
        				feedback.setMessage("You are getting closer to your goal "
        		    			+type+" --> " + goalValue +"!\n Only " + (goalValue - newValue) 
        		    			+ "to go! Good Job!");
        				feedback.setLink(storage.getPicUrl(progressTopic));
    				}     				
    			}
    			//getting farther to goal than previously - encourage!
    			else{
    				feedback.setMessage("You are getting farther from your goal "
    			+type+" --> " + goalValue +"!\n Focus! You can do it!");
    				feedback.setLink(storage.getPicUrl(encourageTopic));
    			}
    		}
    		//Case goal to reach (newMeasure must be <= goalValue)
    		else if(diff < 0){
    			//new value closer to goal than previous measure of that type
    			if(newValue - previousValue < 0){
    				//Goal reached?
    				if(newValue <= goalValue){
    					feedback = this.completeAchievement(feedback, storage, goal, newMeasure);
    				//Goal not reached but still progressing
    				} else {
        				feedback.setMessage("You are getting closer to your goal "
        		    			+type+" --> " + goalValue +"!\n Only " + (newValue - goalValue) 
        		    			+ "to go! Good Job!");
        				feedback.setLink(storage.getPicUrl(progressTopic));
    				}     
    			}
    			//getting farther from the goal - encourage
    			else{
    				feedback.setMessage("You are getting farther from your goal "
    			+type+" --> " + goalValue +"!\n Focus! You can do it!");
    				feedback.setLink(storage.getPicUrl(encourageTopic));
    			}
    		}
        }
        //if no previous measures present but goal exists 
        else if(goal != null){
    		double goalValue = Double.valueOf(goal.getValue());
    		//if goal achieved complete achievement
        	if(newValue == goalValue){
				feedback = this.completeAchievement(feedback, storage, goal, newMeasure);
    		}
        }
        //No goal set of this type
        else{
			feedback.setMessage("You do not have a goal set for "+ type
					+ "!\n Have you thought about setting one? ");
			feedback.setLink(storage.getPicUrl("goal"));
        }
        
        storage.savePersonMeasure(personId, newMeasure);
        return feedback;
	}
	
	//Auxiliary function
	//deletes completed goal from goal list
	//adds it to achievement
	//updates the feedback structure with correct picture and message
	private Feedback completeAchievement(Feedback feedback, Storage storage, Goal goal, Measure newMeasure){
		feedback.setMessage("You have completed your goal "
				+goal.getMeasureDefinition().getMeasureType()+" --> " 
				+ goal.getValue()
				+ "! \n Congradulations!");
		
		feedback.setLink(storage.getPicUrl(completedTopic));
		//Deleting current goal
		storage.deleteGoal(new Holder<Long>(goal.getGid()));
		//Adding it as achievement
		Achievement completed = new Achievement();
		completed.setValue(newMeasure.getMeasureValue());
		completed.setMeasureDefinition(newMeasure.getMeasureDefinition());
		storage.createAchievement(completed);
		
		return feedback;
	}
}
