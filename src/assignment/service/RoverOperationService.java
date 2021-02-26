package assignment.service;

import assignment.model.ConfigurationData;
import assignment.model.Rover;

public interface RoverOperationService {

	public void initializeRoverBoundary(ConfigurationData configurationData) throws Exception;
	
	public Rover initializeRoverPositon(ConfigurationData configurationData) throws Exception;

	public void operateRover(ConfigurationData configurationData, Rover rover) throws Exception;

	public void getNewRoverPositon(Rover rover) throws Exception;


}
