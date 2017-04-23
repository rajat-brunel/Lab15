import java.util.ArrayList;

public class RandomMutationHC {

	
	public static double RMHC(int iter, ArrayList<Integer> s){	
	
	//Declare the changed route
	ArrayList<Integer> change = new ArrayList<Integer>();
	
	
	//Fitness Current Solution
	double f=Functions.distance(s);
	
	
	//For Loop for RMHC Continues Until All the Iterations are completed
	for (int i=0;i<iter;i++){
		
		//Apply a small Change to the Original Route and Store it into the Change Variable
		change=Functions.swap(s);
		
		//Get the fitness of the changed Route
		double f_new=Functions.distance(change);
		
			//Compare new fitness with the Stored Fitness
			if (f_new<f){
				
				//If fitness is better store new route and fitness 
				s=change;
				f=f_new;
					
			}
	}
	//Return Stored Fitness after the loop is completed
	return f;
	
}

}
