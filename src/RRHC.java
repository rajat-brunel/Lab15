import java.util.ArrayList;

public class RRHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int iter=5000;
		int n=48;
		int runs=5;
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		s=randomTour.tour(n);
		
		RRHC(1000,n,runs,s);
	}
	
	public static void RRHC(int iter, int n, int runs, ArrayList<Integer> s){
		double fitness_RRHC=200000;

		int iteration = 0;
		int j=runs;
		for (j=0;j<runs;j++){
			
		ArrayList<Integer> change = new ArrayList<Integer>();
		
		
		//Fitness Current Solution
		double f=fitness.distance(n,s);
		
		change=SmallChange.swap(s, n);
		
		
		for (int i=0;i<iter;i++){
			change=SmallChange.swap(s, n);
			double f_new=fitness.distance(n, change);
			
				if (f_new<f){
					
					s=change;
					f=f_new;
					
				}
		}
		
	//	System.out.println("Best Route was: \n" + s);
		System.out.println("\nBest fitness was: " + f);
		
		if (f<fitness_RRHC){
			fitness_RRHC=f;
			iteration=j;
		}
		s=randomTour.tour(n);
		}
		System.out.println("\nThe Best Fitness from all the runs was (RRHC) : " + fitness_RRHC);
		System.out.println("\nThe Iteration was : " + (iteration+1));
	}
	
}
