import java.util.ArrayList;

public class SHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=48;
		
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
		
	}

}
