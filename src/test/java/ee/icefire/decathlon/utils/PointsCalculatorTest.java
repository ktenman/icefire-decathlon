package ee.icefire.decathlon.utils;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class PointsCalculatorTest {

	@Test
	public void testCalculate() {
		float[][] results = new float[][]{
			{10.62f, 8.07f, 16.57f, 2f, 47.74f, 13.8f, 45.51f, 5f, 68.53f, 275.13f},
			{10.6f, 7.63f, 14.9f, 2.03f, 46.23f, 14.4f, 43.4f, 5.4f, 67.01f, 269.58f},
			{10.72f, 7.59f, 15.41f, 2.15f, 46.21f, 14.34f, 46.96f, 4.7f, 54.61f, 269.05f},
			{10.97f, 6.99f, 14.65f, 2.18f, 48.86f, 15.19f, 47.23f, 4.9f, 62.43f, 263.23f},
			{10.74f, 7.15f, 16.16f, 2.03f, 48.78f, 14.42f, 44.95f, 5.1f, 54.68f, 271.77f},
			{11.14f, 7.17f, 13.76f, 2.09f, 48.76f, 14.33f, 47.4f, 5.1f, 56.04f, 260.66f},
			{10.87f, 7.43f, 13.55f, 1.97f, 47.86f, 14.57f, 43.16f, 5.1f, 65.13f, 273.98f},
			{10.97f, 7.31f, 14.43f, 2.03f, 49.31f, 14.01f, 43.93f, 5.1f, 59.9f, 277.41f},
			{10.93f, 7.37f, 15.15f, 1.97f, 49.45f, 14.41f, 48.1f, 5f, 58.63f, 278.43f},
			{10.91f, 7.67f, 15.43f, 2f, 48.18f, 16.97f, 47.41f, 4.6f, 65.75f, 271.04f},
			{11.29f, 6.98f, 15.17f, 1.97f, 49.86f, 14.86f, 50.3f, 4.9f, 64.57f, 271.44f},
			{10.84f, 7.11f, 15.35f, 2f, 48.46f, 14.45f, 44.22f, 5f, 53.23f, 276.64f},
			{11.03f, 7.17f, 15.34f, 2.06f, 48.68f, 14.5f, 45.2f, 4.7f, 58.87f, 289.61f},
			{10.79f, 7.08f, 14.47f, 1.88f, 48.27f, 14.22f, 39.89f, 5.3f, 56.51f, 276.45f},
			{11.39f, 6.94f, 15.12f, 1.97f, 49.08f, 15.09f, 48.85f, 5.1f, 53.5f, 260.84f},
			{10.9f, 7.48f, 14.47f, 1.94f, 48.28f, 14.36f, 44.93f, 4.3f, 55.89f, 288.33f},
			{11.17f, 6.72f, 13.45f, 1.88f, 48.26f, 14.77f, 43.39f, 5f, 57.96f, 259.26f}
		};
		int[] points = new int[]{
			8902, 8815, 8603, 8371, 8352, 8332, 8307, 8280, 8264, 8174, 8169, 8155, 8097, 8090, 8079, 7916, 7905};

		IntStream.range(0, results.length).forEach(i -> assertEquals(points[i], calculatePoints(results[i])));
	}

	private int calculatePoints(float[] results) {
		Map<Integer, Float> resultsMap = new TreeMap<>();
		IntStream.range(0, results.length).forEach(i -> resultsMap.put(i + 1, results[i]));
		return resultsMap.entrySet().stream()
			.mapToInt(e -> PointsCalculator.calculate(e.getKey(), e.getValue()))
			.sum();
	}

}
