import java.util.ArrayList;

public class SA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int iter=2500;
		int n=48;
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		s=randomTour.tour(n);
		double f=fitness.distance(n,s);
		System.out.println("Fitness: " + f);
		
		double k=500.0;
		
		double T_start=f/k;
		System.out.println("T: " + T_start);
		
		double T_iter=0.001;
		
		double t_val=T_iter/T_start;
		
		double cr= Math.pow(t_val, 1.0/iter);
		
		System.out.println("Cooling Rate: " + cr);
		
		double temp=T_start;
		int times=0;
		while(temp>1){
			
			temp=cr*temp;
			times++;
		}
		
		System.out.println("Number of times " + times + " temp " + temp);
	}

}
