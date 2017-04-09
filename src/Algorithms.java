import java.util.ArrayList;

public class Algorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int iter=2500;
		int runs=5;
		int n=48;
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		
		s=randomTour.tour(n);
		
		RMHC.RMHC(iter, n, s);
		RRHC.RRHC(iter, n, runs,s);
		SHC.SHC(iter, n, s);
		SA.SA(iter, n, s);
		
		
		
	}

}
