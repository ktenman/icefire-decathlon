package ee.icefire.decathlon.utils;

public class PointsCalculator {

	public static int calculate(int index, float performance) {

		Event event = EventMapper.eventMap.get(index);
		int calculation = 0;
		switch (event.getType()) {
			case RUNNING:
				calculation = (int) (event.getA() * Math.pow(event.getB() - performance, event.getC()));
				break;
			case JUMPING:
				calculation = (int) (event.getA() * Math.pow(performance * 100 - event.getB(), event.getC()));
				break;
			case THROWING:
				calculation = (int) (event.getA() * Math.pow(performance - event.getB(), event.getC()));
				break;
			default:
		}

		return calculation;
	}
}
