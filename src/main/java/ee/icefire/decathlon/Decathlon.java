package ee.icefire.decathlon;


import ee.icefire.decathlon.objects.Athlete;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static ee.icefire.decathlon.utils.PerformanceParser.parsePerformanceToFloat;
import static ee.icefire.decathlon.utils.PointsCalculator.calculate;
import static java.util.stream.Collectors.toList;

class Decathlon {

	private final List<Athlete> athletes = new ArrayList<>();
	String fileName;
	List<String> athleteResults;

	public Decathlon(String fileName) {
		this.fileName = fileName;
		getResultsOfAthletesFromFile();
		if (validDataFound()) {
			calculatePointsOfAthletes();
			printResults();
		} else {
			System.exit(0);
		}
	}

	public Decathlon(Consumer<Decathlon> builder) {
		builder.accept(this);
	}

	public void getResultsOfAthletesFromFile() {
		try {
			athleteResults = Files.lines(Paths.get(fileName)).collect(toList());
		} catch (IOException e) {
			System.out.println("Something is wrong with input file.");
			e.printStackTrace();
			System.exit(0);
		}
	}

	private boolean validDataFound() {
		StringBuilder error = new StringBuilder("Please check your file.\n\nRequirments:\n");
		boolean validDataFound = true;
		if (noResultFound()) {
			error.append("* There must be at least one result.\n");
			validDataFound = false;
		}
		if (resultInWrongFormatExists()) {
			error.append("* There is a result in wrong format.\n");
			validDataFound = false;
		}
		if (!validDataFound) {
			System.out.print(error);
		}
		return validDataFound;
	}

	private boolean resultInWrongFormatExists() {
		for (String athleteResult : athleteResults) {
			String[] columns = athleteResult.split(";");
			if (columns.length != 11) {
				return true;
			}
			for (int i = 1; i < columns.length; i++) {
				try {
					parsePerformanceToFloat(columns[i]);
				} catch (Exception e) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean noResultFound() {
		return athleteResults.size() == 0;
	}

	private void calculatePointsOfAthletes() {
		for (String athleteResult : athleteResults) {
			String[] columns = athleteResult.split(";");
			String name = columns[0];
			Athlete athlete = new Athlete(name);
			for (int i = 1; i < columns.length; i++) {
				athlete.addEventPoints(calculate(i, parsePerformanceToFloat(columns[i])));
			}
			athletes.add(athlete);
		}
	}

	private void printResults() {
		IntStream.range(0, athletes.size())
			.mapToObj(i -> String.format("%2d. %s", i + 1, athletes.get(i)))
			.forEach(System.out::println);
	}

}
