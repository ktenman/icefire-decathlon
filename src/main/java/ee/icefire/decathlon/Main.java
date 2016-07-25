package ee.icefire.decathlon;

class Main {

	public static void main(String[] args) {
		String fileName = "results.csv";
		if (args.length > 0) {
			fileName = args[0];
		}
		new Decathlon(fileName);
	}

}
