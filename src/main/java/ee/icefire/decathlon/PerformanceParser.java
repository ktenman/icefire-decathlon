package ee.icefire.decathlon;

class PerformanceParser {
	static float parsePerformanceToFloat(String value) {
		value = value.replace(",", ".");
		if (value.contains(":")) {
			String[] values = value.split(":");

			return Float.parseFloat(values[0]) * 60 + Float.parseFloat(values[1]);

		}
		return Float.parseFloat(value);
	}
}
