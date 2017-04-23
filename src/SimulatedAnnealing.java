import java.util.ArrayList;
 
 public class SimulatedAnnealing {
 
	public static double SA(int iter, ArrayList<Integer> s){
	
	//Get Fitness of the Original Tour	
	double f=Functions.distance(s);
	
	//Declare and Initialise the new Fitness Variable
	double f_new=0.0;
			
	//Declare the changed route
	ArrayList<Integer> s_new = new ArrayList<Integer>();
	
	// Set the Value of k (200.0 was quite good after Trial And Error)
	double k=200.0;	
	
	// Sets the Initial Temperature
	double T_start=f/k;
	
	// Prints out the Initial Temperature
	//System.out.println("T: " + T_start);
		
		//T_Iter for calculating the Cooling Rate
		//Set at 0.001, according to the lecture notes
		double T_iter=0.001;
		
		
		double t_val=T_iter/T_start;
		
		//Sets the Cooling Rate 
		double cr= Math.pow(t_val, 1.0/iter);
		
		//Prints out the Cooling Rate
		//System.out.println("Cooling Rate: " + cr);

 		
		//Sets T_Start as the Temperature, used only to make it less confusing
		double temp=T_start;
		
		//Initialise Probability of Acceptance and Delta F 
		double p=0.0;
		double delta_f=0.0;
		
		
		//For Loop for SA Continues Until All the Iterations are completed
		for(int i=0;i<iter;i++){
			
			//Apply Small Change to the Original Tour and get the fitness of the changed tour
			s_new=Functions.swap(s);
			f_new=Functions.distance(s_new);
			
			//Compare new fitness with the Stored Fitness
			if (f_new>f){
				
				// If Fitness is worse
				//Calculate the Probability of Acceptance
				
				//Difference between the two fitness
				
				//Sets all the Required Value for the Probability of Acceptance Equation
				delta_f= Math.abs(f_new-f);
				delta_f= (-1)*delta_f;
				double a=(delta_f/temp);
				//Gets the Probability of Acceptance
				p=Math.exp(a);
				
			
				if(p<CS2004.UR(0.0, 1.0)){
					//Reject Changes
						s=s;
						f=f;
				}
				else{
					//Accept Changes
					s=s_new;
					f=f_new;
				}
			}
			else{
			//Store the better Route and Fitness 
			s=s_new;
			f=f_new;
			}
			
			//Cool Down the temperature after each iteration
			temp=cr*temp;

		}
		
		// Output the Results
//		System.out.println("Best Route was: \n" + s);
//		System.out.println("\nBest fitness was (SA): " + f);
	
		
	//Returns Fitness
	return f;
	} 	
 }
 