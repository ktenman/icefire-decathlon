package ee.icefire.decathlon.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class EventMapper {

	static final Map<Integer, Event> eventMap = createMap();

	private static Map<Integer, Event> createMap() {
		Map<Integer, Event> eventMap = new HashMap<>();
		IntStream.range(0, Event.values().length).forEach(i -> eventMap.put(i + 1, Event.values()[i]));
		return Collections.unmodifiableMap(eventMap);
	}
}
