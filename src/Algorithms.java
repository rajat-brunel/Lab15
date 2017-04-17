import java.util.ArrayList;

public class Algorithms {
	
	static int cities=442;
	static double distanceArray[][];
	static int iter;
	
	public static void main(String[] args) {
		
		iter=100000;
		int runs=2;
		
		distanceArray=Functions.dataset(cities);

		ArrayList<Integer> s = new ArrayList<Integer>();	
		s=Functions.tour();	
		
		
		//Random Mutation Hill Climbing
		double fitness_rmhc=RMHC.RMHC(iter, s);
		System.out.print(fitness_rmhc);
		String eff_rmhc=Efficiency.percentage(fitness_rmhc);
		//Write Results to File
		Functions.Results(fitness_rmhc, eff_rmhc, "RMHC", true);
		
	
		//Random Restart Hill Climbing
		double fitness_rrhc=RRHC.RRHC(iter/runs, runs,s);
		System.out.print(fitness_rrhc);
		String eff_rrhc=Efficiency.percentage(fitness_rrhc);
		//Write Results to File
		Functions.Results(fitness_rrhc, eff_rrhc, "RRHC", true);
		
		//Stochastic Hill Climbing
		double fitness_shc=SHC.SHC(iter, s);
		System.out.print(fitness_shc);
		String eff_shc=Efficiency.percentage(fitness_shc);
		//Write Results to File
		Functions.Results(fitness_shc, eff_shc, "SHC", true);
		
		//Simulated Annealing
		double fitness_sa=SA.SA(iter, s);	
		System.out.print(fitness_sa);
		String eff_sa=Efficiency.percentage(fitness_sa);
		//Write Results to File
		Functions.Results(fitness_sa, eff_sa, "SA", true);
		
	}
	
	
}
