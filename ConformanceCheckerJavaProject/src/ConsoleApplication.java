
public class ConsoleApplication {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Incorrect number of arguments.");
			System.out.println("1. Path to event log.");
			System.out.println("2. Path to petri net.");
		}
		
		Metrics metrics = null;
		try {
			ConformanceChecker cc = new ConformanceChecker();
			metrics = cc.getMetrics(args[0], args[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Incorrect arguments entered.");
			System.out.println("1. Path to event log.");
			System.out.println("2. Path to petri net.");
		}

		System.out.println("Fitness: " + metrics.getFitness());
		System.out.println("Simple behavioral appropriateness: " + metrics.getSBA());
		System.out.println("Simple structural appropriateness: " + metrics.getSSA());
	}

}
