import java.util.ArrayList;

public class SmallChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=48;
		
		ArrayList<Integer> r_tour = new ArrayList<Integer>();
		
		r_tour=randomTour.tour();
		
		swap(r_tour);
	}
	
	public static ArrayList<Integer> swap(ArrayList<Integer> r_tour){
		
		int i=0;
		int j=0;
		
	
		ArrayList<Integer> changed_tour = new ArrayList<Integer>();
		
		while(i==j){
			i= CS2004.UI(0,r_tour.size()-1);
			j= CS2004.UI(0,r_tour.size()-1);
		}
		
	//	System.out.println(i + " " + j);
		
		for (int a=0;a<Algorithms.cities;a++){
			
			changed_tour.add(r_tour.get(a));
		}
		
		changed_tour.set(i,r_tour.get(j));
		changed_tour.set(j,r_tour.get(i));
		
	//	System.out.println("Changed Tour: \n" + changed_tour);
		
		return changed_tour;
		
		
	}
	
}
