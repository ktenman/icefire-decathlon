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

	private Decathlon main;

	@Before
	public void setUp() {
		main = new Decathlon();
	}

	@Test
	public void testGetResultsOfAthletesFromFile() {

		main.setFileName("");
		main.getResultsOfAthletesFromFile();
		assertFalse(main.isReadFromFileSuccess());

		File file = new File("RYyFajDbpjuP.csv");
		if (!fileExists(file)) {
			main.setFileName("RYyFajDbpjuP.csv");
			main.getResultsOfAthletesFromFile();
			assertFalse(main.isReadFromFileSuccess());
		}

		main.setFileName("results.csv");
		main.getResultsOfAthletesFromFile();
		assertTrue(main.isReadFromFileSuccess());
	}

	@Test
	public void testNoResultFound() {
		getAthleteResults();
		boolean noResultsFould = main.getAthleteResults().size() == 0;
		assertFalse(noResultsFould);
	}

	@Test
	public void testResultInWrongFormatExists() {
		getAthleteResults();
		assertFalse(main.resultInWrongFormatExists());
	}

	private void getAthleteResults() {
		String fileName = "results.csv";
		try {
			main.setAthleteResults(Files.lines(Paths.get(fileName)).collect(toList()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean fileExists(File file) {
		return file.exists();
	}

}
