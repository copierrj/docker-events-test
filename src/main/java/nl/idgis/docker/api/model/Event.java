package nl.idgis.docker.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
	
	private String type, action;
	
	private Actor actor;
	
	@JsonProperty("Type")
	public String getType() {
		return type;
	}
	
	@JsonProperty("Action")
	public String getAction() {
		return action;
	}
	
	@JsonProperty("Actor")
	public Actor getActor() {
		return actor;
	}

	@Override
	public String toString() {
		return "Event [type=" + type + ", action=" + action + ", actor=" + actor + "]";
	}
	
}
