package ee.icefire.decathlon.utils;

enum Event {

	RACE_100M(25.4347F, 18F, 1.81F, EventType.RUNNING),
	LONG_JUMP(0.14354F, 220F, 1.4F, EventType.JUMPING),
	SHOT_PUT(51.39F, 1.5F, 1.05F, EventType.THROWING),
	HIGH_JUMP(0.8465F, 75F, 1.42F, EventType.JUMPING),
	RACE_400M(1.53775F, 82F, 1.81F, EventType.RUNNING),
	HURDLES_110M(5.74352F, 28.5F, 1.92F, EventType.RUNNING),
	DISCUS_THROW(12.91F, 4F, 1.1F, EventType.THROWING),
	POLE_VAULT(0.2797F, 100F, 1.35F, EventType.JUMPING),
	JAVELIN_THROW(10.14F, 7F, 1.08F, EventType.THROWING),
	RACE_1500M(0.03768F, 480F, 1.85F, EventType.RUNNING);

	final float A;
	final float B;
	final float C;
	final EventType type;

	Event(float A, float B, float C, EventType type) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.type = type;
	}

}
