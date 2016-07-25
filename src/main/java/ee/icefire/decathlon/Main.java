package ee.icefire.decathlon;

class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String fileName = "results.csv";
		if (args.length > 0) {
			fileName = args[0];
		}
		for (int i = 0; i < 5000; i++) {
			new Decathlon(fileName);
		}
		System.out.println((System.currentTimeMillis() - start) + "ms");
	}

}
