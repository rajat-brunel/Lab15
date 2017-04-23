import java.text.DecimalFormat;
import java.util.ArrayList;

public class Efficiency {
	
	/**
	 * MST of a Dataset
	 * @return MST of a particular Dataset
	 */
	private static double[][] MST() {
		
		//Number of Cities
		int n=Algorithms.cities;
		//Location of the Dataset
		String filename=Functions.file(n);
		//Read in the dataset
		double dist[][]=TSP.ReadArrayFile(filename, " ");
		//Get MST in 2d array through Prims Algorithm using the dataset
		double[][] mstOfArray = MST.PrimsMST(dist);
		return mstOfArray;
	}
	
	/**
	 * Fitness of the MST
	 * @param MST_Array A MST Array
	 * @return Fitness of the MST Array Provided
	 */
	private static double MST_Fitness(double[][] MST_Array) {
		
		//Initialise the Fitness
		double fitness = 0.0;
		
		//As MST is a 2d Array we need a Nested loop
		//It runs until the length of the MST
		for (int i = 0; i < MST_Array.length; i++) {
			for (int j = 0; j < MST_Array[i].length; j++) {
				
				//Adds the fitness from the values of each row and column
				fitness = fitness + MST_Array[i][j];
			}
		}
		//Divide fitness by 2 as MST is a 2D array
		fitness = fitness / 2;
		return fitness;
	}
	
	/**
	 * Calculates the Efficiency of Fitness against MST
	 * @param fitness Fitness of the Algorithm
	 * @return Efficency of the Algorithm against MST
	 */
	public static double MST_Efficiency(double fitness) {
		
		//Get the MST Fitness
		double[][] array = MST();
		double mst_fitness = MST_Fitness(array);
		
		//Calculate Efficiency
		double efficiency = (mst_fitness / fitness) * 100;

		return efficiency;
	}
	/**
	 * Calculates The Efficiency Against the Optimal Tour
	 * @param fitness Fitness From The Algorithm
	 * @return Efficiency Against the Optimal Tour
	 */
	public static double OPT_Efficiency(double fitness){
		int n=Algorithms.cities;
		double opt=OPT_fitness(n);
		double efficiency=(opt/fitness)*100;
		return efficiency;
	}
	/**
	 * Gets the Fitness of the Optimal Tour 
	 * @param n Number of Cities
	 * @return Fitness of the Optimal Tour
	 */
	public static double OPT_fitness(int n){
		
		//Declare a new ArrayList to store the Optimal Tour
		ArrayList<Integer> t = new ArrayList<Integer>();
		
		//Convert the integer value of cities into String Data Type
		String cities= String.valueOf(n);
		
		//Get the location the required OPT File
		String filename=Functions.OPT_file(n);
		
		//Add the OPT to the Array List
		t=TSP.ReadIntegerFile(filename);
		
		//Gets the Fitness of the Optimal Tour
		double dist=Functions.distance(t);
		return dist;
	}
	
	/**
	 * Efficiency Percentage
	 * @param fitness Fitness of the Algorithm
	 * @return Effciency in a 2 decimal format
	 */
	public static String percentage(double fitness){
			
		//Initialise the Format to use
		 DecimalFormat f = new DecimalFormat("##.00");
		
		 //Gets the MST Efficiency
		double mst_eff=Efficiency.MST_Efficiency(fitness);
		//Initialise the OPT Efficiency
		double opt_eff=0.0;
		
		// If OPT Tour Available get the Efficiency of the OPT Tour
		if (Algorithms.cities==48||Algorithms.cities==51||
				Algorithms.cities==52||Algorithms.cities==70||
				Algorithms.cities==76||Algorithms.cities==100||
				Algorithms.cities==105||Algorithms.cities==442){
			
		opt_eff=Efficiency.OPT_Efficiency(fitness);
		
		}
		
		String eff=" "+f.format(opt_eff)+" " + f.format(mst_eff);
		System.out.println(eff);
		return eff;
	}
}
