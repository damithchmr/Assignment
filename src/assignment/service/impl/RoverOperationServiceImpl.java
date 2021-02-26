package assignment.service.impl;

import assignment.model.ConfigurationData;
import assignment.model.Rover;
import assignment.service.RoverOperationService;

public class RoverOperationServiceImpl implements RoverOperationService {

	private int x;
	private int y;
	private char singleDirection;
	private int boundaryX;
	private int boundaryY;

	@Override
	public void initializeRoverBoundary(ConfigurationData configurationData) throws Exception {

		String boundaryPositon = configurationData.getBoundaryPosition().trim();
		String[] boundaryPositonArray = boundaryPositon.split(" ");

		try {
			boundaryX = Integer.parseInt(boundaryPositonArray[0]);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		try {
			boundaryY = Integer.parseInt(boundaryPositonArray[1]);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Rover initializeRoverPositon(ConfigurationData configurationData) throws Exception {

		Rover rover = new Rover();

		String startPositon = configurationData.getStartPosition().trim();
		String[] startPositonArray = startPositon.split(" ");

		try {
			rover.setRoverX(Integer.parseInt(startPositonArray[0]));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		try {
			rover.setRoverY(Integer.parseInt(startPositonArray[1]));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		try {
			rover.setRoverDirection(startPositonArray[2].charAt(0));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return rover;
	}

	@Override
	public void operateRover(ConfigurationData configurationData, Rover rover) throws Exception {

		x = rover.getRoverX();
		y = rover.getRoverY();
		singleDirection = rover.getRoverDirection();

		String instustion = configurationData.getInstruction().trim();
		char[] chars = instustion.toCharArray();

		for (char ch : chars) {
			executeInstruction(ch);
		}

		updateRoverInfo(rover);
	}

	private void updateRoverInfo(Rover rover) {

		rover.setRoverX(x);
		rover.setRoverY(y);
		rover.setRoverDirection(singleDirection);
	}

	private void executeInstruction(char ch) throws Exception {

		if (ch == 'L') {
			rotateLeftSide();
		} else if (ch == 'R') {
			rotateRightSide();
		} else if (ch == 'M') {
			movedForward();
		} else {
			throw new Exception("Bad input, input must be L,R or M");
		}

	}

	private void rotateLeftSide() {

		if (singleDirection == 'N') {
			singleDirection = 'W';
		} else if (singleDirection == 'W') {
			singleDirection = 'S';
		} else if (singleDirection == 'S') {
			singleDirection = 'E';
		} else if (singleDirection == 'E') {
			singleDirection = 'N';
		}

	}

	private void rotateRightSide() {

		if (singleDirection == 'N') {
			singleDirection = 'E';
		} else if (singleDirection == 'E') {
			singleDirection = 'S';
		} else if (singleDirection == 'S') {
			singleDirection = 'W';
		} else if (singleDirection == 'W') {
			singleDirection = 'N';
		}

	}

	private void movedForward() throws Exception {

		if (singleDirection == 'N') {
			y = y + 1;
		} else if (singleDirection == 'S') {
			y = y - 1;
		} else if (singleDirection == 'E') {
			x = x + 1;
		} else if (singleDirection == 'W') {
			x = x - 1;
		}
		if (!checkBoundaryPosition()) {
			throw new Exception("Rover out of the given boundary");
		}
	}

	private boolean checkBoundaryPosition() {

		if (x > boundaryX || y > boundaryY || x < 0 || y < 0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void getNewRoverPositon(Rover rover) throws Exception {

		System.out.println("Rover new position is ->" + rover.getRoverX() + " " + rover.getRoverY() + " "
				+ rover.getRoverDirection());

	}

}
