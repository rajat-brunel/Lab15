import java.text.DecimalFormat;
import java.util.ArrayList;

public class Efficiency {
	
	private static double[][] MST() {
		int n=Algorithms.cities;
		String filename=Functions.file(n);
		double dist[][]=TSP.ReadArrayFile(filename, " ");
		double[][] mstOfArray = MST.PrimsMST(dist);
		return mstOfArray;
	}
	
	private static double MST_Fitness(double[][] MST_Array) {
		
		double fitness = 0.0;
		for (int i = 0; i < MST_Array.length; i++) {
			for (int j = 0; j < MST_Array[i].length; j++) {
				fitness = fitness + MST_Array[i][j];
			}
		}
		fitness = fitness / 2;
		return fitness;
	}

	public static double MST_Efficiency(double fitness) {
		double[][] array = MST();
		double mst_fitness = MST_Fitness(array);
		
		double efficiency = (mst_fitness / fitness) * 100;

		return efficiency;
	}
	public static double OPT_Efficiency(double fitness){
		int n=Algorithms.cities;
		double opt=OPT_fitness(n);
		double efficiency=(opt/fitness)*100;
		return efficiency;
	}
	
	public static double OPT_fitness(int n){
		
		ArrayList<Integer> t = new ArrayList<Integer>();
		
		String cities= String.valueOf(n);
		
		String filename=Functions.OPT_file(n);
		
		t=TSP.ReadIntegerFile(filename);
		
		double dist=Functions.distance(t);
		return dist;
	}
	
	public static String percentage(double fitness){
		
		 DecimalFormat f = new DecimalFormat("##.00");
		
		double mst_eff=Efficiency.MST_Efficiency(fitness);
		double opt_eff=Efficiency.OPT_Efficiency(fitness);
		
		String eff=" "+f.format(opt_eff)+" " + f.format(mst_eff);
		System.out.println(eff);
		return eff;
	}
}
