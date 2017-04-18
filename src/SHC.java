import java.util.ArrayList;

public class SHC {

	public static void main(String[] args) {
		
	}

	public static double SHC(int iter, ArrayList<Integer> s){
		
		ArrayList<Integer> s_new = new ArrayList<Integer>();
		
		double f=Functions.distance(s);
		s_new=Functions.swap(s);
		double f_new=Functions.distance(s_new);
		
		double k=6000.0;
		
		double T=f/k;
		
//		System.out.println("The value of T is :" + T);
		
		double e=Math.E;
		
		
		double power=(f_new-f)/T;
		
	
		
		double val=Math.pow(e, power);
		
	
		
		for (int i=0;i<iter;i++){
			
			s_new=Functions.swap(s);
			
			f_new=Functions.distance(s_new);
			
			power=(f_new-f)/T;
			
			double p_new=1/(1+(Math.pow(e, power)));
			
			if (f_new>f){
				
				if (p_new > CS2004.UR(0.0, 1.0)){
					
					s=s_new;
					f=f_new;
				
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
	//	System.out.println(f);
		}
		
	//	System.out.println("Best Route was: \n" + s);
	//	System.out.println("\nBest fitness was (SHC): " + f);
		
		
		return f;
	}
}
