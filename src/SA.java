import java.util.ArrayList;
 
 public class SA {
 
 	public static void main(String[] args) {
 		// TODO Auto-generated method stub
 		
 		
 		int n=48;
		int iter=5000;
 		
 		ArrayList<Integer> s = new ArrayList<Integer>();
 		
 		s=randomTour.tour(n);
 		
 		SA(iter,n,s);

 	}
public static void SA(int iter, int n, ArrayList<Integer> s){
	double f=fitness.distance(n,s);
	double f_new=0.0;
//		System.out.println("Fitness: " + f);
		
		
		
		ArrayList<Integer> s_new = new ArrayList<Integer>();
		
		
		double k=500.0;
		
	
	double T_start=f/k;
	//	double T_start=119.3875;
	System.out.println("T: " + T_start);
		
		double T_iter=0.001;
		

		
		double t_val=T_iter/T_start;
		
		double cr= Math.pow(t_val, 1.0/iter);
		
	System.out.println("Cooling Rate: " + cr);

 		
		
 	double temp=T_start;
		int times=0;
		
		double p=0.0;
		double delta_f=0.0;
		
		s_new=SmallChange.swap(s, n);
		
		for(int i=0;i<iter;i++){
			
			s_new=SmallChange.swap(s, n);
		f_new=fitness.distance(n, s_new);
		
		if (f_new>f){

			delta_f= Math.abs(f_new-f);
			delta_f= (-1)*delta_f;
			double a=(delta_f/temp);
			p=Math.exp(a);
			
			if(p <CS2004.UR(0.0, 1.0)){
				s=s;
				f=f;
			}
			else{
				s=s_new;
				f=f_new;
			}
			
			}
		else{
			s=s_new;
			f=f_new;
		}
//			System.out.println("iter " + times + " temp " + temp + " p " + p + " delta f " + delta_f);
			temp=cr*temp;
//		System.out.println(f);
		//	System.out.println("Current route : " + s);
			times++;
		}
		
//		System.out.println("Number of times " + times + " temp " + temp);
	System.out.println("Best Route was: \n" + s);
	System.out.println("\nBest fitness was (SA): " + f);
} 	
 }
 