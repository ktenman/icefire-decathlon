package ee.icefire.decathlon;

class PointsCalculator {
	static int calculatePoints(int index, float performance) {
		Event event = EventMapper.eventMap.get(index);
		int calculation = 0;
		switch (event.type) {
			case RUNNING:
				calculation = (int) (event.A * Math.pow(event.B - performance, event.C));
				break;
			case JUMPING:
				calculation = (int) (event.A * Math.pow(performance * 100 - event.B, event.C));
				break;
			case THROWING:
				calculation = (int) (event.A * Math.pow(performance - event.B, event.C));
				break;
			default:
		}
		return calculation;
	}
}
