package ee.icefire.decathlon.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class EventMapper {

	static final Map<Integer, Event> eventMap = createMap();

	private static Map<Integer, Event> createMap() {
		Map<Integer, Event> eventMap = new HashMap<>();
		eventMap.put(1, Event.race_100m);
		eventMap.put(2, Event.long_jump);
		eventMap.put(3, Event.shot_put);
		eventMap.put(4, Event.high_jump);
		eventMap.put(5, Event.race_400m);
		eventMap.put(6, Event.hurdles_110m);
		eventMap.put(7, Event.discus_throw);
		eventMap.put(8, Event.pole_vault);
		eventMap.put(9, Event.javelin_throw);
		eventMap.put(10, Event.race_1500m);
		return Collections.unmodifiableMap(eventMap);
	}
}
