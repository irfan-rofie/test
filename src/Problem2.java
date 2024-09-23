import java.util.Random;

public class Problem2 {
	public static void main(String[] args) {
		Integer maxPremiumWidgets = 150;
		Integer maxStandardWidgets = 200;
		
		Integer premiumWidgetCost = 80;
		Integer standardWidgetCost = 30;

		Integer productionCostLimit = 20000;
		
		Integer bestPremiumWidgets = 0;
		Integer bestStandardWidgets = 0;
		Double bestRevenue = (double) 0;

		Random random = new Random();
		
		Integer iteration = 10;
		for (int i = 1; i <= iteration; i++) {
			Integer premiumWidgetsProduced = random.nextInt(maxPremiumWidgets + 1);
			Integer standardWidgetsProduced = random.nextInt(maxStandardWidgets + 1);

			Integer totalProductionCost = (premiumWidgetsProduced * premiumWidgetCost)
					+ (standardWidgetsProduced * standardWidgetCost);

			Double revenue = (double) 0;
			if (totalProductionCost <= productionCostLimit) {
				revenue = calculateRevenue(premiumWidgetsProduced, standardWidgetsProduced);

				if (revenue > bestRevenue) {
					bestRevenue = revenue;
					bestPremiumWidgets = premiumWidgetsProduced;
					bestStandardWidgets = standardWidgetsProduced;
				}
			}
			
			System.out.println("Iteration" + i + ": Premium Widgets = " + premiumWidgetsProduced + ", Standard Widgets = " + standardWidgetsProduced + ", Revenue = $" + revenue);
		}

		System.out.println("\nBest production after " + iteration + " iterations:");
		System.out.println("Premium Widgets: " + bestPremiumWidgets);
		System.out.println("Standard Widgets: " + bestStandardWidgets);
		System.out.println("Total Revenue: $" + bestRevenue);
	}

	private static Double calculateRevenue(Integer premiumWidgets, Integer standardWidgets) {
		Double premiumRevenue = (double) 0;
		Double standardRevenue = (double) 0;

		if (premiumWidgets <= 50) {
			premiumRevenue = (double) (premiumWidgets * 100);
		} else {
			premiumRevenue = (double) ((50 * 100) + ((premiumWidgets - 50) * (100 - (premiumWidgets - 50))));
		}

		if (standardWidgets <= 100) {
			standardRevenue = (double) (standardWidgets * 50);
		} else {
			standardRevenue = (100 * 50) + ((standardWidgets - 100) * (50 - (standardWidgets - 100) * 0.5));
		}

		return premiumRevenue + standardRevenue;
	}
}
