package ee.icefire.decathlon.utils;

public class PointsCalculator {

	public static int calculate(int index, float performance) {

		Event event = EventMapper.eventMap.get(index);
		int points = 0;
		switch (event.type) {
			case RUNNING:
				points = (int) (event.A * Math.pow(event.B - performance, event.C));
				break;
			case JUMPING:
				points = (int) (event.A * Math.pow(performance * 100 - event.B, event.C));
				break;
			case THROWING:
				points = (int) (event.A * Math.pow(performance - event.B, event.C));
				break;
		}

		return points;
	}
}
