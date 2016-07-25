package ee.icefire.decathlon;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DecathlonTest {

	private Decathlon decathlon;

	@Before
	public void setUp() {
		decathlon = new Decathlon();
	}

	@Test
	public void testGetResultsOfAthletesFromFile() {

		decathlon.setFileName("");
		decathlon.getResultsOfAthletesFromFile();
		assertFalse(decathlon.isReadFromFileSuccess());

		File file = new File("RYyFajDbpjuP.csv");
		if (!fileExists(file)) {
			decathlon.setFileName("RYyFajDbpjuP.csv");
			decathlon.getResultsOfAthletesFromFile();
			assertFalse(decathlon.isReadFromFileSuccess());
		}

		decathlon.setFileName("results.csv");
		decathlon.getResultsOfAthletesFromFile();
		assertTrue(decathlon.isReadFromFileSuccess());
	}

	@Test
	public void testNoResultFound() {
		getAthleteResults();
		boolean noResultsFould = decathlon.getAthleteResults().size() == 0;
		assertFalse(noResultsFould);
	}

	@Test
	public void testResultInWrongFormatExists() {
		getAthleteResults();
		assertFalse(decathlon.resultInWrongFormatExists());
	}

	private void getAthleteResults() {
		String fileName = "results.csv";
		try {
			decathlon.setAthleteResults(Files.lines(Paths.get(fileName)).collect(toList()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean fileExists(File file) {
		return file.exists();
	}

}
