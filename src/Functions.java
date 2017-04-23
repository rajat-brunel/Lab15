import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Functions {
	
	 /**
	  * Dataset 
	  * @param cities Number of Cities
	  * @return Dataset of distance between the Cities
	  */
	 public static double[][] dataset(int cities) {
		
		double dist[][];
		String filename=file(cities);
		dist=TSP.ReadArrayFile(filename, " ");
		return dist;
	}
	
	 /**
	  * File Path
	  * @param cities Number of Cities
	  * @return Location of the File
	  */
	 public static String file(int cities){
		 String path="dataset/";
		 String start="TSP_";
		 String end=".txt";
		 
		 String locat=path+start+cities+end;
		 return locat;
	 }
	 /**
	  * OPT File Path
	  * @param cities Number of Cities
	  * @return Location of the OPT File
	  */
	 public static String OPT_file(int cities){
		 String path="dataset/";
		 String start="TSP_";
		 String opt="_OPT";
		 String end=".txt";
		 
		 String locat=path+start+cities+opt+end;
		 return locat;
	 }
	
	/**
	 * The Small Change Method
	 * It swaps two cities
	 * @param r_tour A tour
	 * @return The Swapped City Tour
	 */
	 public static ArrayList<Integer> swap(ArrayList<Integer> r_tour){
			
		int i=0;
		int j=0;
		
		//Declare the Changed Tour
		ArrayList<Integer> changed_tour = new ArrayList<Integer>();
		
		//While loop until we get two different random numbers
		//Uses CS2004 Class, gets random numbers from 0 to the length of the tour
		while(i==j){
					i= CS2004.UI(0,r_tour.size()-1);
					j= CS2004.UI(0,r_tour.size()-1);
				}
			
		//Populates the Changed tour with all the Cities from the original Tour
		for (int a=0;a<Algorithms.cities;a++){
				
			changed_tour.add(r_tour.get(a));
			
			}
			//Swaps the Cities using the index values from earlier
			changed_tour.set(i,r_tour.get(j));
			changed_tour.set(j,r_tour.get(i));
			
		//	System.out.println("Changed Tour: \n" + changed_tour);
			
			return changed_tour;
		}
	
	/**
	 * Distance of a Tour (Fitness)
	 * @param t A Tour
	 * @return The Fitness of the Tour
	 */
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
					
				} 
				
				//As we have to return to our starting city
				//get the city at the end
				int end_city = t.get(Algorithms.cities-1);
				//get the city at the start
				int start_city = t.get(0);
				
				
				//Add the distance between the start city to the end city 
				s= s+Algorithms.distanceArray[end_city][start_city];
				
				
				//Output the total distance 	
				//System.out.println("Length of the tour is  : "+   s); 
				
				//We need to minimise this value
				return s;
	}
	
	/**
	 * Makes a Tour
	 * @return A New Random Tour
	 */
	public static ArrayList<Integer> tour(){
		
		//Initialise two Array Lists
		//1 to add all the values in linear order
		//2 to randomise the values and get a random tour
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		ArrayList<Integer> t = new ArrayList<Integer>(); 
		
		
		//Use a for loop to add integers according to the number of cities
		for (int i=0;i<Algorithms.cities;i++){
			p.add(i);
		}
		int i;
		
		//Runs a while loop until the original Linear Tour is empty
		while(p.size()>0){
			
			//get a random integer from the original tour
			i=CS2004.UI(0,p.size());
			
			//if the random integer is the last integer in the array
			//get a random integer again
			//As the length would be 1 more than the actual tour cities (0-47) for 48 cities
			do{
				i=CS2004.UI(0,p.size());
			}while
				(p.size()<i || p.size()==i);
		
			int add=p.get(i);
			//Remove the City from the Linear Tour
			t.add(add);
			//Add the City to the new Random Tour
			p.remove(i);
			
		}
		
		return t;
	
	}
	 /**
	  * Writes the Results to a Text File in CSV
	  * @param fitness fitness of the Algorithm
	  * @param efficiency efficiencies of the Algorithm
	  * @param algorithm Name of the Algorithm
	  * @param append Overwrite or Create new file
	  */
	public static void Results(double fitness, String efficiency, String algorithm, boolean append){
		
		//Converts the fitness from Double to String Data Type
		String fitness_string= Double.toString(fitness);
		//Creates the filename in a proper readable format
		String filename="results/"+algorithm+"_"+Algorithms.cities+"_"+Algorithms.iter+".txt";
		
		try {
			//Creates the file
		      File file = new File(filename);
		      // Check if the file is already present
		      if (file.createNewFile()){
		        System.out.println("File is created!");
		      }else{
		        System.out.println("File already exists.");
		      }

	    	} catch (IOException e) {
		      e.printStackTrace();
	    	}
		
		// Writes the required results into the file
		try{
			FileWriter writer = new FileWriter(filename, append);
			writer.write(fitness_string+" "+efficiency);
			writer.write("\n"); 
			writer.close();
			
		}catch(IOException e2) {
			System.out.println("File Not Found!");
			e2.printStackTrace();
		}
	}
}
