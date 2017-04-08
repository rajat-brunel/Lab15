import java.util.ArrayList;

public class SA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int iter=5;
		int n=48;
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		ArrayList<Integer> s_new = new ArrayList<Integer>();
		
		s=randomTour.tour(n);
		double f=fitness.distance(n,s);
		System.out.println("Fitness: " + f);
		
		double k=500.0;
		
		double T_start=f/k;
		System.out.println("T: " + T_start);
		
		double T_iter=0.001;
		
		double t_val=T_iter/T_start;
		
		double cr= Math.pow(t_val, 1.0/iter);
		
		for (int i=0;i<iter;i++){
			
			s_new=SmallChange.swap(s, n);
		
			double f_new=fitness.distance(n, s_new);
		
		//System.out.println("Cooling Rate: " + cr);
		
			double temp=T_start;
		
			if (f_new>f){
		
					double delta_f=f_new-f;
					delta_f= (-1)* delta_f;
					double a=delta_f/temp;
					double p=Math.exp(a);
					System.out.println(p);
					if (p>CS2004.UR(0, 1)){
			
						}
					else{
						 s=s_new;
						 f=f_new;
						 
						}
				}else{
					
					s=s_new;
					}
		
			temp=cr*temp;
		
		}
		
		System.out.println("Best Route was: \n" + s);
		System.out.println("\nBest fitness was: " + f);
	}

}
