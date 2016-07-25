package ee.icefire.decathlon.utils;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class PointsCalculatorTest {

	@Test
	public void testCalculate() {
		float[] resultsA = new float[]{10.62f, 8.07f, 16.57f, 2f, 47.74f, 13.8f, 45.51f, 5f, 68.53f, 275.13f};
		float[] resultsB = new float[]{10.6f, 7.63f, 14.9f, 2.03f, 46.23f, 14.4f, 43.4f, 5.4f, 67.01f, 269.58f};
		assertEquals(8902, calculate(resultsA));
		assertEquals(8815, calculate(resultsB));
	}

	private int calculate(float[] results) {
		Map<Integer, Float> resultsMap = new TreeMap<>();
		IntStream.range(0, results.length).forEach(i -> resultsMap.put(i + 1, results[i]));
		return resultsMap.entrySet().stream()
			.mapToInt(e -> PointsCalculator.calculate(e.getKey(), e.getValue()))
			.sum();
	}

}
