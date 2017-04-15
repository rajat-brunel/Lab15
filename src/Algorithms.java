import java.util.ArrayList;

public class Algorithms {
	
	static int cities=51;
	static double distanceArray[][]=dataset(cities);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int iter=5000;
		int runs=2;

		ArrayList<Integer> s = new ArrayList<Integer>();	
		
		s=randomTour.tour();	
		double fitness=Efficiency.OPT_fitness(cities);
		System.out.println(fitness);
		
		RMHC.RMHC(iter, s);
	//	RRHC.RRHC(iter/runs, n, runs,s);
	//	SHC.SHC(iter, n, s);
	//	SA.SA(iter, n, s);	
		
	}
	
	public static double[][] dataset(int cities){
		double dist[][];
		String filename="TSP_"+cities+".txt";
		dist=TSP.ReadArrayFile(filename, " ");
		return dist;
	}
}
