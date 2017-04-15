import java.util.ArrayList;

public class RMHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Number of iterations to run the RMHC Algorithm
		int iter=2500;
		
		//Number of cities to visit
		int n=48;
		
		//Random Tour
		ArrayList<Integer> s = new ArrayList<Integer>();
		
	//	ArrayList<Integer> s_final = new ArrayList<Integer>();
		
		
		s=Functions.tour();
		
		System.out.println(s);
		
		RMHC(iter,s);
	}
	
	public static ArrayList<Integer> RMHC(int iter, ArrayList<Integer> s){	
		
	ArrayList<Integer> change = new ArrayList<Integer>();
	
	
	//Fitness Current Solution
	double f=Functions.distance(s);
//	double f_final=0;
	
	for (int i=0;i<iter;i++){
		
		change=Functions.swap(s);
		double f_new=Functions.distance(change);
		
			if (f_new<f){
				
				s=change;
				f=f_new;
					
			}
		
//	System.out.println(f);	
	}
	
//	System.out.println("Best Route was: \n" + s);
	System.out.println("\nBest fitness was (RMHC): " + f);
	
	Efficiency.percentage(f);
	return s;
	
}

}
