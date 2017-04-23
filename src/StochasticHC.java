import java.util.ArrayList;

public class StochasticHC {

	public static double SHC(int iter, ArrayList<Integer> s){
		
		
		double f=Functions.distance(s);
		
		//Initialise new Changed Tour and get fitness after Applying Small Change
		ArrayList<Integer> s_new = new ArrayList<Integer>();
		s_new=Functions.swap(s);
		double f_new=Functions.distance(s_new);
		
		
		//Set the Value of k (Depends on the Dataset)
		double k=6000.0;
		
		
		//Get the Temperature
		double T=f/k;
		
		//Prints the Value of Temperature
		//System.out.println("The value of T is :" + T);
		
		//Initialise the Exponential Function
		double e=Math.E;
		
		//Initialise power 
		double power=0.0;
		
		//For Loop for SHC Continues Until All the Iterations are completed
		for (int i=0;i<iter;i++){
			
			//Apply Small Change to the original route and get the fitness
			s_new=Functions.swap(s);		
			f_new=Functions.distance(s_new);
			
			//Used to simplify the probability equation
			power=(f_new-f)/T;
			
		
			
			if (f_new>f){
				//Calculate the Probability of Acceptance
				double p_new=1/(1+(Math.pow(e, power)));
				if (p_new > CS2004.UR(0.0, 1.0)){
					//Accept Changes
					s=s_new;
					f=f_new;
				
				}
				else{
					//Reject Changes
					s=s;
					f=f;
				}
			}
			else{
				//Store the new better Fitness and Route
				s=s_new;
				f=f_new;
			}
		}
	//  Outputs the Results for the SHC Algorithm	
	//	System.out.println("Best Route was: \n" + s);
	//	System.out.println("\nBest fitness was (SHC): " + f);
		
	//Returns the Fitness	
		return f;
	}
}
