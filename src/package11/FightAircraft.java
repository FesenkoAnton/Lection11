package package11;

import java.awt.Rectangle;

import acm.graphics.GRect;
import acm.program.*;

public class FightAircraft extends GraphicsProgram {

	/** size and speed aircraft */
	private static final int AIR_WIDTH = 20;
	private static final int AIR_HEIGHT = AIR_WIDTH / 2;
	private static final int AIR_SPEED = 2;
	/** size and speed bullet */
	private static final int BULLET_SPEED = 5;
	private static final int BULLET_DIAM = 5;
	/** size window */
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 400;

	public void run() {
		setup();
		moveAircraftLeft();
	}

	private void setup() {
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		aircraft = new GRect(AIR_WIDTH, AIR_HEIGHT);
		aircraft.setFilled(true);
		add(aircraft, WINDOW_WIDTH, 0);
		// move aircraft
		moveAircraftLeft = true;
		addMouseListeners();
	}

	private void moveAircraftLeft() {
		if (moveAircraftLeft) {
			aircraft.move(-AIR_SPEED, 0);
			if (aircraft.getX() <= 0) {
				moveAircraftLeft = false;
				aircraft.move(0, AIR_HEIGHT);
			} else {
				aircraft.move(AIR_SPEED, 0);
				if (aircraft.getX() >= getWidth() - AIR_HEIGHT) {
					moveAircraftLeft = true;
					aircraft.move(0, AIR_HEIGHT);
				}

			}
		}
	}

	private GRect aircraft;
	private boolean moveAircraftLeft;
}
