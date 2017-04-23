import java.util.ArrayList;

public class Algorithms {
	
/** Travelling SalesPerson Problem
 *  Lab 15 - Main Class
 *  Algorithms and their Applications
 *  Student ID: 1534189
 */
	
	static int cities=48;
	static double distanceArray[][];
	static int iter;
	
	public static void main(String[] args) {
		
		//Number of RRHC Runs
		int runs=2;
		//Number of Iterations
		iter=100000;
		//Gets the Dataset
		distanceArray=Functions.dataset(cities);
		
		//A New Random Tour
		ArrayList<Integer> s = new ArrayList<Integer>();	
		s=Functions.tour();	
		
		//Output The Cities and Iterations
		System.out.println("Number of Cities = "+ cities);
		System.out.print("\nNumber of Iterations = "+iter + "\n");
		System.out.println("===================================");
		
		//Output Heading
		System.out.println("\n"+"\t Fitness "+ "\tOPT"+ "\tMST");
		
		//Random Mutation Hill Climbing
		double fitness_rmhc=RandomMutationHC.RMHC(iter, s);
		System.out.print("RMHC "+fitness_rmhc);
		String eff_rmhc=Efficiency.percentage(fitness_rmhc);
	//	Write Results to File
	//	Functions.Results(fitness_rmhc, eff_rmhc, "RMHC", true);
		
	
		//Random Restart Hill Climbing
		double fitness_rrhc=RandomRestartHC.RRHC(iter/runs, runs,s);
		System.out.print("RRHC "+fitness_rrhc);
		String eff_rrhc=Efficiency.percentage(fitness_rrhc);
	//	Write Results to File
	//	Functions.Results(fitness_rrhc, eff_rrhc, "RRHC", true);
		
		//Stochastic Hill Climbing
		double fitness_shc=StochasticHC.SHC(iter, s);
		System.out.print("SHC  "+fitness_shc);
		String eff_shc=Efficiency.percentage(fitness_shc);
	//	Write Results to File
	//	Functions.Results(fitness_shc, eff_shc, "SHC", true);
		
		//Simulated Annealing
		double fitness_sa=SimulatedAnnealing.SA(iter, s);	
		System.out.print("SA   "+fitness_sa);
		String eff_sa=Efficiency.percentage(fitness_sa);
	//	Write Results to File
	//	Functions.Results(fitness_sa, eff_sa, "SA", true);
		
	
	}
	
	
}
