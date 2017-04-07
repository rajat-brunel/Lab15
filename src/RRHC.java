import java.util.ArrayList;

public class RRHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double fitness_RRHC=200000;
		int iteration = 0;
		
		for (int j=0;j<5;j++){
		int iter=500;
		
		//Number of cities to visit
		int n=48;
		
		//Random Tour
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		
		s=randomTour.tour(n);
		
		ArrayList<Integer> change = new ArrayList<Integer>();
		
		
		//Fitness Current Solution
		double f=fitness.distance(n,s);
		
		change=SmallChange.swap(s, n);
		
		
		for (int i=0;i<iter;i++){
			change=SmallChange.swap(change, n);
			double f_new=fitness.distance(n, change);
			
				if (f_new<f){
					
					s=change;
					f=f_new;
					
				}
		}
		
		System.out.println("Best Route was: \n" + s);
		System.out.println("\nBest fitness was: " + f);
		
		if (f<fitness_RRHC){
			fitness_RRHC=f;
			iteration=j;
		}
		System.out.println("\nThe Best Fitness from all the runs was : " + fitness_RRHC);
		System.out.println("\nThe Iteration was : " + iteration);
		}
	}

}
