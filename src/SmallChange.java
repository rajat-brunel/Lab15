import java.util.ArrayList;

public class SmallChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=48;
		
		ArrayList<Integer> r_tour = new ArrayList<Integer>();
		ArrayList<Integer> changed_tour = new ArrayList<Integer>();
		r_tour=randomTour.tour(n);
		
		int i=0;
		int j=0;
		while(i==j){
			i= CS2004.UI(1,n);
			j= CS2004.UI(1,n);
		}
		
		System.out.println(i + " " + j);
		
		for (int a=0;a<n;a++){
			
			changed_tour.add(r_tour.get(a));
		}
		
		changed_tour.set(i,r_tour.get(j));
		changed_tour.set(j,r_tour.get(i));
		System.out.println("Changed Tour: \n" + changed_tour);
	}
	
	
	
}
