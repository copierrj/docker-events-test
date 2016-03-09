package nl.idgis.docker.api;

import java.net.URL;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import nl.idgis.docker.api.model.Event;

public class DockerClient {
	
	private final static String DEFAULT_HOST = "localhost";
	
	private final static int DEFAULT_PORT = 2375;
	
	private final String host;
	
	private final int port;
	
	private final JsonFactory jsonFactory;
	
	private final ObjectMapper mapper;
	
	public DockerClient() {
		this(DEFAULT_HOST, DEFAULT_PORT);
	}
	
	public DockerClient(String host) {
		this(host, DEFAULT_PORT);
	}

	public DockerClient(String host, int port) {
		this.host = host;
		this.port = port;
		
		jsonFactory = new JsonFactory();
		mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public Iterable<Event> events(String since) {
		try {
			ObjectReader reader = mapper.readerFor(Event.class);
			JsonParser jp = jsonFactory.createParser(new URL("http://" + host + ":" + port + "/v1.22/events?since=" + since));
			
			return () -> {
				try {
					return reader.readValues(jp, Event.class);
				} catch(Exception e) {
					throw new RuntimeException(e);
				}
			};
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
