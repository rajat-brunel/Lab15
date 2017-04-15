import java.util.ArrayList;

public class Functions {
	
	 public static double[][] dataset(int cities) {
		
		double dist[][];
		String filename=file(cities);
		dist=TSP.ReadArrayFile(filename, " ");
		return dist;
	}
	 
	 public static String file(int cities){
		 String path="dataset/";
		 String start="TSP_";
		 String end=".txt";
		 
		 String locat=path+start+cities+end;
		 return locat;
	 }
	 
	 public static String OPT_file(int cities){
		 String path="dataset/";
		 String start="TSP_";
		 String opt="_OPT";
		 String end=".txt";
		 
		 String locat=path+start+cities+opt+end;
		 return locat;
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
	
	public static double distance(ArrayList<Integer> t){
				
				//Initialise variable for the Final length of the tour
				
				double s=0;
				
				// run a loop until we have visited all of the cities
				for (int i=0;i<(Algorithms.cities-1);i++)
				{	
					//first city
					int a = t.get(i);
					//second city
					int b = t.get(i+1);
					
					//sum of the distance between the cities
					//Adding the sum from previous cities
					s= s + Algorithms.distanceArray[a][b];
					
				//	System.out.println("dist " + a + " "+ b +" = " + dist[a][b]);
				} 
				
				//As we have to return to our starting city
				//get the city at the end
				int end_city = t.get(Algorithms.cities-1);
				//get the city at the start
				int start_city = t.get(0);
				
			//	System.out.println("dist " + end_city + " "+ start_city +" = " + dist[end_city][start_city]);
				
				//Add the distance between the start city to the end city 
				s= s+Algorithms.distanceArray[end_city][start_city];
				
				
				//Output the total distance 
				
				
			//	System.out.println("Length of the tour is  : "+   s); 
				
				//We need to minimise this value
				return s;
	}
	
	public static ArrayList<Integer> tour(){
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		ArrayList<Integer> t = new ArrayList<Integer>(); 
		
		for (int i=0;i<Algorithms.cities;i++){
			p.add(i);
		}
		int i;
		
		while(p.size()>0){
			
			i=CS2004.UI(0,p.size());
			do{
				i=CS2004.UI(0,p.size());
			}while
				(p.size()<i || p.size()==i);
		
		
			int add=p.get(i);
			t.add(add);
			p.remove(i);
			
		}
		
		return t;
	
	}
	 
}
