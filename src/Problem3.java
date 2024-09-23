public class Problem3 {
	public static void main(String[] args) {
		Integer maxDevelopersA = 15;
		Integer minDevelopersA = 5;

		Integer maxDevelopersB = 20;
		Integer minDevelopersB = 10;
		
		Integer budget = 100000;

		Integer bestDevelopersA = 0;
		Integer bestDevelopersB = 0;
		
		Double maxRevenue = (double) 0;

		for (int developersA = minDevelopersA; developersA <= maxDevelopersA; developersA++) {
			for (int developersB = minDevelopersB; developersB <= maxDevelopersB; developersB++) {
				Integer costA = developersA * 5000;
				Integer costB = developersB * 4000;
				Integer totalCost = costA + costB;

				if (totalCost <= budget) {
					Double revenueA;
					if (developersA <= 40) {
						revenueA = (double) (developersA * 120);
					} else {
						revenueA = (double) (40 * 120 + (developersA - 40) * (120 - 2 * (developersA - 40)));
					}

					Double revenueB;
					if (developersB <= 80) {
						revenueB = (double) (developersB * 60);
					} else {
						revenueB = (double) (80 * 60 + (developersB - 80) * (60 - (developersB - 80)));
					}

					Double totalRevenue = revenueA + revenueB;
					
					if (totalRevenue > maxRevenue) {
						maxRevenue = totalRevenue;
						bestDevelopersA = developersA;
						bestDevelopersB = developersB;
					}
				}
			}
		}

		System.out.println("Optimal number of developers in Team A: " + bestDevelopersA);
		System.out.println("Optimal number of developers in Team B: " + bestDevelopersB);
		System.out.println("Maximized Total Revenue: $" + maxRevenue);
	}
}
