package nl.idgis.docker;

import nl.idgis.docker.api.DockerClient;

public class EventTest {
	
	public static void main(String[] args) throws Exception {
		DockerClient dockerClient = new DockerClient();		
		dockerClient.events("0").forEach(System.out::println);
	}
}