package ee.icefire.decathlon.utils;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

public class PerformanceParser {

	public static float parsePerformanceToFloat(String value) {
		value = value.replace(",", ".");
		if (value.contains(":")) {
			String[] values = value.split(":");
			return SECONDS.convert(Integer.parseInt(values[0]), MINUTES) + Float.parseFloat(values[1]);
		}
		return Float.parseFloat(value);
	}

}
