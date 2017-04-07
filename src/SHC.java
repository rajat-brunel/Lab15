import java.util.ArrayList;

public class SHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=48;
		int iter=2500;
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		ArrayList<Integer> s_new = new ArrayList<Integer>();
		
		s=randomTour.tour(n);
		
		double f=fitness.distance(n,s);
		
		s_new=SmallChange.swap(s, n);
		
		double f_new=fitness.distance(n, s_new);
		
		double k=125.0;
		
		double T=f/k;
		
		System.out.println("The value of T is :" + T);
		
		double e=Math.E;
		
		
		double power=(f_new-f)/T;
		
		double p=1/(1+(Math.pow(e, power)));
		
		double val=Math.pow(e, power);
		
		System.out.println("Probability is: "+ p + " val " + val);
		
		for (int i=0;i<iter;i++){
			
			s_new=SmallChange.swap(s_new, n);
			
			f_new=fitness.distance(n, s_new);
			
			power=(f_new-f)/T;
			
			double p_new=1/(1+(Math.pow(e, power)));
			
			if (p_new>p){
				
				s=s_new;
				f=f_new;
			}
		}
		
		System.out.println("Best Route was: \n" + s);
		System.out.println("\nBest fitness was: " + f);
		
		
	}

}
