package gymnasticCompetititons.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import model.Product;

public class Competition {
	private String name;
	private String description;
	private String initialDate;
	ArrayList<Trial> trials = new ArrayList<Trial>();
	
	Map<Integer, Participation> participations = new HashMap<>();


	public boolean addTrial(Trial trial) {
		boolean result = false;
		if(trial!=null && !isTrial(trial)) {
			trials.add(trial);
			result = true;
		}
			
		return result;
	}

	
	public Trial showTrial(String type, String category, String kit) {
		Trial trial = null;
		if(trials!=null) {
			Iterator<Trial> it = trials.iterator();
			while(it.hasNext()){
				Trial trial = it.next();
				if (trials.getType().getCategory().getKit().equalsIgnoreCase(type, category, kit)) {
					trial = trials;
				}
					
			}
		}
		
		
		
		return trial;
	}
	
	public boolean changeTrial(Trial trial) {
		boolean result = false;
		
		if(trial != null  &&  showArticle(trial.getType().getCategory().getKit())!=null) {
			Iterator<Trial> it = trials.iterator();
			while(it.hasNext()){
				Trial trials = it.next();
				if (trials.equals(trial)) {
					trials = trial;
					result = true;
				}
			}
		}
		
		return result;
	}
	
	public boolean removeTrial(Trial trial) {
		boolean result = false;
		
		if(trials!=null && showTrial(trial.getType().getCategory().getKit())!=null) {
			Iterator<Trial> it=trials.iterator();
			while(it.hasNext()){
				Trial trials = it.next();
				if (trials.equals(trial)) {
					it.remove();
					result = true;
				}
			}
		}
		
		
		return result;
	}
	
	
	public boolean isTrial(Trial trial) {
		boolean result = false;
		Iterator<Trial> it = trials.iterator();
		while(it.hasNext()){
			Trial trials = it.next();
			if (trials!=null && trial.equals(trials)) {
				result = true;
				break;
			}
				
		}
		
		return result;
	}
	
	
	public boolean addParticipation(Participation participation, int key) {
		boolean result = false;
		if(participation!=null && !isParticipation(participation)) {
			participation.put(participation.getDorsalNumber(), participation);
			result = true;
		}
		
		return result;
	}
	
	public Participation showParticipation(int dorsalNumber) {
			
		Participation participation = null;
		Iterator<Integer> it = participations.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			participation = participations.get(dorsalNumber);	
		}
		
		return participation;
	}
	
	public void showAllParticipation(){
		Participation participation = null;
		Iterator<String> it = participations.keySet().iterator();//tambien se puede recorer con un forEach
		while(it.hasNext()) {
			String key = it.next();
			//esto te da el valor perteneciente a esa key:
			System.out.println(participations.get(key));
		}
	}
	
	public boolean removeParticipation(Participation participation, int key) {
		boolean result = false;
		if(participation!=null && !isProduct(participation)) {
			participations.remove(participation.getDorsalNumber(), participation);
			result = true;
		}
		
		return result;
	}
	
	public boolean changeParticipation(Map<Integer, Participation> participation) {
		boolean result = false;
		
		if(participation != null  &&  showParticipation((participation).getDorsalNumber())!=null) {
			Iterator<Integer> it = participations.keySet().iterator();
			while(it.hasNext()){
				Integer key = it.next();
				if (participations.equals(participation)) {
					participations = participation;
					result = true;
				}
			}
		}
		
		return result;
	}
	
	public boolean isParticipation(Participation participation) {
		boolean result = false;
		Iterator<Integer> it = participations.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			if (participations!=null && participation.equals(participations)) {
				result = true;
				break;
			}
				
		}
		
		return result;
	}

}