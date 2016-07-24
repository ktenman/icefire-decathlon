package ee.icefire.decathlon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

public class DecathlonTest {

	private Decathlon decathlon;

	@Test(expected=IOException.class)
	public void setUp(){
		decathlon = new Decathlon(d -> {
			d.fileName = "f8PtWj3dY2Uw.csv";
			d.athleteResults = new ArrayList<>();
		});
		decathlon.getResultsOfAthletesFromFile();
	}

}
