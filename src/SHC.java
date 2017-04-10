import java.util.ArrayList;

public class SHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=48;
		int iter=2500;
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		
		
		s=randomTour.tour(n);
		
		
		SHC(iter,n,s);		
	}

	public static double SHC(int iter, int n, ArrayList<Integer> s){
		
		ArrayList<Integer> s_new = new ArrayList<Integer>();
		int shc=0;
		double f=fitness.distance(n,s);
		s_new=SmallChange.swap(s, n);
		double f_new=fitness.distance(n, s_new);
		
		double k=2000.0;
		
		double T=f/k;
		
		System.out.println("The value of T is :" + T);
		
		double e=Math.E;
		
		
		double power=(f_new-f)/T;
		
	//  double p=1/(1+(Math.pow(e, power)));
		
		double val=Math.pow(e, power);
		
	//	System.out.println("Probability is: "+ p + " val " + val);
		
		for (int i=0;i<iter;i++){
			
			s_new=SmallChange.swap(s, n);
			
			f_new=fitness.distance(n, s_new);
			
			power=(f_new-f)/T;
			
			double p_new=1/(1+(Math.pow(e, power)));
			
			if (f_new>f){
				
				if (p_new > CS2004.UR(0.0, 1.0)){
					
					s=s_new;
					f=f_new;
					shc++;
				//	System.out.println("Chose Worse " + " Probabilty was: " + p_new);
				}
				else{
					s=s;
					f=f;
				}
			}
			else{
				s=s_new;
				f=f_new;
		}
	//		System.out.println("Current fitness : " + f);	
		}
		
		System.out.println("Best Route was: \n" + s);
		System.out.println("\nBest fitness was (SHC): " + f);
	//	System.out.println("\nSHC: " + shc);
		return f;
	}
}
