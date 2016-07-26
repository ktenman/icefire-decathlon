package ee.icefire.decathlon;

import java.util.stream.IntStream;

class Main {

	public static void main(String[] args) {
		String fileName = "results.csv";
		if (args.length > 0) {
			IntStream.range(0, args.length).forEach(i -> {
				System.out.printf("\nResults of '%s':\n", args[i]);
				new Decathlon(args[i]);
			});
		} else {
			new Decathlon(fileName);
		}
	}

}
