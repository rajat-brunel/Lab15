import java.util.ArrayList;

public class Algorithms {
	
	static int cities=48;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int iter=10000;
		int runs=2;
	//	int n=48;
		
		ArrayList<Integer> s = new ArrayList<Integer>();	
		
		s=randomTour.tour(n);	
		
		RMHC.RMHC(iter, n, s);
	//	RRHC.RRHC(iter/runs, n, runs,s);
	//	SHC.SHC(iter, n, s);
	//	SA.SA(iter, n, s);	
		
	}
	
	
}
