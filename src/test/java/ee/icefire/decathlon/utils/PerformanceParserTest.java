package ee.icefire.decathlon.utils;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PerformanceParserTest {

	@Test
	public void testParsePerformanceToFloat() {
		String value = "4:35,13";
		Float expectedValue = 275.13f;
		assertEquals(expectedValue, PerformanceParser.parsePerformanceToFloat(value));
		value = "0:35,13";
		expectedValue = 35.13f;
		assertEquals(expectedValue, PerformanceParser.parsePerformanceToFloat(value));
		value = "0:00,13";
		expectedValue = 0.13f;
		assertEquals(expectedValue, PerformanceParser.parsePerformanceToFloat(value));
	}
}
