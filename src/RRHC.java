import java.util.ArrayList;

public class RRHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int iter=5000;
		int n=48;
		int runs=2;
		
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		
	}
	
	public static double RRHC(int iter, int runs, ArrayList<Integer> s){
		
		
		
	//	s=randomTour.tour(n);
		
		int iteration = 0;
		double fitness_RRHC=0;
		
		double f=Functions.distance(s);
		for (int j=0;j<runs;j++){
		ArrayList<Integer> change = new ArrayList<Integer>();
		change=Functions.swap(s);
		
			
		//Fitness Current Solution
	
		fitness_RRHC=RMHC.RMHC(iter, s);
	//	System.out.println("Best Route was: \n" + s);
	//	System.out.println("f: " + f);
	//	System.out.println("f_rrhc: " + fitness_RRHC);
			

		if (fitness_RRHC<f){
			f=fitness_RRHC;
		}
		s=Functions.tour();
		//System.out.println("\nBest fitness was: " + f);
		}
	//	System.out.println("\nThe Best Fitness from all the runs was (RRHC) : " + f);
	//	System.out.println("\nThe Iteration was : " + (iteration+1));
		
		return f;
		
	}
	
}
