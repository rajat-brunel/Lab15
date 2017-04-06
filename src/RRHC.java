import java.util.ArrayList;

public class RRHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int iter=100;
		
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

	}

}
