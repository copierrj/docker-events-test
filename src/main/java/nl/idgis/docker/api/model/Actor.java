package nl.idgis.docker.api.model;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor {

	private String id;
	
	private Map<String, String> attributes;
	
	@JsonProperty("ID")
	public String getId() {
		return id;
	}
	
	@JsonProperty("Attributes")
	public Map<String, String> getAttributes() {
		return attributes;
	}
	
	public Optional<String> getAttribute(String name) {
		return Optional.ofNullable(attributes.get(name));
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", attributes=" + attributes + "]";
	}
	
}
