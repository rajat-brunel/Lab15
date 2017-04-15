import java.util.ArrayList;

public class Algorithms {
	
	static int cities=100;
	static double distanceArray[][];
	
	public static void main(String[] args) {
		
		int iter=12000;
		int runs=2;
		distanceArray=Functions.dataset(cities);

		ArrayList<Integer> s = new ArrayList<Integer>();	
		
		s=Functions.tour();	
		double fitness=Efficiency.OPT_fitness(cities);
		System.out.println(fitness);
		
		RMHC.RMHC(iter, s);
	//	RRHC.RRHC(iter/runs, n, runs,s);
	//	SHC.SHC(iter, n, s);
	//	SA.SA(iter, n, s);	
		
	}
	
	
}
