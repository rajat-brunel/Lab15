import java.util.ArrayList;

public class fitness {

	
	public static double distance(int n, ArrayList<Integer> t, double dist[][]){
		//A tour
				//Added integer values depending upon the length of the tour
				//This integer value is the number of cities to visit i.e. tour
				
				
				
				//for (int i=0;i<=n;i++){
				//	t.add(i);
				//}
				
				
				
				//Path of the Dataset File
				
				
				//distance matrix
				//Read the Dataset file through the string
				
				
				
				//Initialise variable for the Final length of the tour
				
				double s=0;
				
				// run a loop until we have visited all of the cities
				for (int i=0;i<n-1;i++)
				{	
					//first city
					int a = t.get(i);
					//second city
					int b = t.get(i+1);
					
					//sum of the distance between the cities
					//Adding the sum from previous cities
					s= s + dist[a][b];
					
				//	System.out.println("dist " + a + " "+ b +" = " + dist[a][b]);
				} 
				
				//As we have to return to our starting city
				//get the city at the end
				int end_city = t.get(n-1);
				//get the city at the start
				int start_city = t.get(0);
				
			//	System.out.println("dist " + end_city + " "+ start_city +" = " + dist[end_city][start_city]);
				
				//Add the distance between the start city to the end city 
				s= s+dist[end_city][start_city];
				
				
				//Output the total distance 
				
				
			//	System.out.println("Length of the tour is  : "+   s); 
				
				//We need to minimise this value
				return s;
	}
}
