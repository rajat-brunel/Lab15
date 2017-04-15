import java.util.ArrayList;

public class Algorithms {
	
	static int cities=48;
	static double distanceArray[][];
	static int iter;
	
	public static void main(String[] args) {
		
		iter=5000;
		int runs=2;
		
		distanceArray=Functions.dataset(cities);

		ArrayList<Integer> s = new ArrayList<Integer>();	
		s=Functions.tour();	
		
		
		//Random Mutation Hill Climbing
		double fitness_rmhc=RMHC.RMHC(iter, s);
		System.out.print(fitness_rmhc);
		String eff_rmhc=Efficiency.percentage(fitness_rmhc);
		//Write Results to File
	//	Functions.Results(fitness_rmhc, eff_rmhc, "RMHC", true);
		
	
		//Random Restart Hill Climbing
		double fitness_rrhc=RRHC.RRHC(iter/runs, runs,s);
		System.out.print(fitness_rrhc);
		String eff_rrhc=Efficiency.percentage(fitness_rrhc);
		
	//	SHC.SHC(iter, s);
	//	SA.SA(iter, s);	
		
	}
	
	
}
