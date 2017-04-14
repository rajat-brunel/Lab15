import java.util.ArrayList;

public class Algorithms {
	
	static int cities=48;
	static double distanceArray[][]=dataset();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int iter=10000;
		int runs=2;
		String filename="TSP_48.txt";
		distanceArray= dataset();
	//	int n=48;
		
		ArrayList<Integer> s = new ArrayList<Integer>();	
		
		s=randomTour.tour();	
		
		RMHC.RMHC(iter, n, s);
	//	RRHC.RRHC(iter/runs, n, runs,s);
	//	SHC.SHC(iter, n, s);
	//	SA.SA(iter, n, s);	
		
	}
	
	public static double[][] dataset(){
		double dist[][];
		String filename="TSP_48.txt";
		dist=TSP.ReadArrayFile(filename, " ");
		return dist;
	}
}
