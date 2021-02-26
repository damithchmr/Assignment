package assignment;

import assignment.model.ConfigurationData;
import assignment.model.Rover;
import assignment.service.RoverOperationService;
import assignment.service.impl.RoverOperationServiceImpl;

public class RoverMain {

	public static void main(String[] args) {

		// Sample input data for this programme
		String boundaryPosition = "5 5";  
		String startPosition = "1 2 N";   // 3 3 E 
		String instruction = "LMLMLMLMM"; // MMRMMRMRRM
		
		Rover rover = null;

		try {
			ConfigurationData configurationData = new ConfigurationData();
			configurationData.setBoundaryPosition(boundaryPosition);
			configurationData.setStartPosition(startPosition);
			configurationData.setInstruction(instruction);

			RoverOperationService operationService = new RoverOperationServiceImpl();
			
			operationService.initializeRoverBoundary(configurationData);
			rover = operationService.initializeRoverPositon(configurationData);
			operationService.operateRover(configurationData, rover);
			operationService.getNewRoverPositon(rover);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
