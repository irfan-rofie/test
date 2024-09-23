import java.util.Random;

public class Problem1 {
	public static void main(String[] args) {
		Integer profitProductA = 40;
		Integer profitProductB = 30;
		
		Integer maxWorkingHours = 160;
		Integer maxMachineHours = 180;
		
		Integer maxProductA = 80;
		Integer maxProductB = 100;
		
		Integer workingHoursProductA = 2;
		Integer machineHoursProducA = 1;
		
		Integer workingHoursProductB = 1;
		Integer machineHoursProducB = 2;
		
		Integer productAIsProduced = 0;
		Integer productBIsProduced = 0;
		Integer maxProfit = 0;

		Random random = new Random();
		
		Integer iteration = 10;
		for (Integer i = 1; i <= iteration; i++) {
			Integer productA = random.nextInt(maxProductA + 1);
			Integer productB = random.nextInt(maxProductB + 1);
			
			Integer totalWorkingHours = (workingHoursProductA * productA) + (workingHoursProductB * productB);
			Integer totalMachineHours = (machineHoursProducA * productA) + (machineHoursProducB * productB);

			Integer currentProfit = 0;
			if (totalWorkingHours <= maxWorkingHours && totalMachineHours <= maxMachineHours) {
				currentProfit = (profitProductA * productA) + (profitProductB * productB);
				
				if (currentProfit > maxProfit) {
					productAIsProduced = productA;
					productBIsProduced = productB;
                    maxProfit = currentProfit;
                }
			}
			
			 System.out.println("Iteration" + i + ": Product A = " + productA + ", Product B = " + productB + ", Profit = $" + currentProfit);
		}
		
		System.out.println("\nBest result after " + iteration + " iterations:");
        System.out.println("Number of units of Product A produced: " + productAIsProduced);
        System.out.println("Number of units of Product B produced: " + productBIsProduced);
        System.out.println("Maximum profit: $" + maxProfit);
	}
}
