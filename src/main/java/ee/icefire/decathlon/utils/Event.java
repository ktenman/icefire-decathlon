package ee.icefire.decathlon.utils;

enum Event {

	race_100m(25.4347f, 18f, 1.81f, EventType.RUNNING),
	long_jump(0.14354f, 220f, 1.4f, EventType.JUMPING),
	shot_put(51.39f, 1.5f, 1.05f, EventType.THROWING),
	high_jump(0.8465f, 75f, 1.42f, EventType.JUMPING),
	race_400m(1.53775f, 82f, 1.81f, EventType.RUNNING),
	hurdles_110m(5.74352f, 28.5f, 1.92f, EventType.RUNNING),
	discus_throw(12.91f, 4f, 1.1f, EventType.THROWING),
	pole_vault(0.2797f, 100f, 1.35f, EventType.JUMPING),
	javelin_throw(10.14f, 7f, 1.08f, EventType.THROWING),
	race_1500m(0.03768f, 480f, 1.85f, EventType.RUNNING);

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

	public float getA() {
		return A;
	}

	public float getB() {
		return B;
	}

	public float getC() {
		return C;
	}

	public EventType getType() {
		return type;
	}
}
