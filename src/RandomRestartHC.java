import java.util.ArrayList;

public class RandomRestartHC {

	
	public static double RRHC(int iter, int runs, ArrayList<Integer> s){
		
		//Initialise the Fitness for RRHC
		double fitness_RRHC=0;
		
		
		//Get the Fitness of the Intial Route
		double f=Functions.distance(s);
		
		//For Loop for RRHC
		for (int j=0;j<runs;j++){
			
			ArrayList<Integer> change = new ArrayList<Integer>();
			change=Functions.swap(s);
				
			//Fitness Current Solution
			//Gets the Fitness from the RMHC Class and Stores it into the RRHC Fitness Variable
			fitness_RRHC=RandomMutationHC.RMHC(iter, s);	
			
		//Checks if the Current Fitness is better than the Stored	
			if (fitness_RRHC<f){
			f=fitness_RRHC;
			}
		
		//Gets A Random Tour after each Iteration
			s=Functions.tour();
		
		//System.out.println("\nBest fitness was: " + f);
		
		}
	//	System.out.println("\nThe Best Fitness from all the runs was (RRHC) : " + f);
	//	System.out.println("\nThe Iteration was : " + (iteration+1));
		
		return f;
		
	}
	
}
