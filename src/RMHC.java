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
		
		
		s=randomTour.tour(n);
		
		RMHC(iter,n,s);
	}
	
	public static ArrayList<Integer> RMHC(int iter, int n, ArrayList<Integer> s){	
		
	ArrayList<Integer> change = new ArrayList<Integer>();
	String filename="TSP_48.txt";
	double dist[][]=TSP.ReadArrayFile(filename, " ");
	
	//Fitness Current Solution
	double f=fitness.distance(n,s,dist);
//	double f_final=0;
	
	for (int i=0;i<iter;i++){
		
		change=SmallChange.swap(s, n);
		double f_new=fitness.distance(n, change,dist);
		
			if (f_new<f){
				
				s=change;
				f=f_new;
					
			}
		
//	System.out.println(f);	
	}
	
//	System.out.println("Best Route was: \n" + s);
	System.out.println("\nBest fitness was (RMHC): " + f);
	double eff=Efficiency.CalculateEfficiencyOfMST(f);
//	double opt_eff=Efficiency.CalcEfficiencyOPT(f);
	
//	System.out.println(opt_eff);
	System.out.println(eff);
	return s;
	
}

}
