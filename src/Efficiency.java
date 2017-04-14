import java.util.ArrayList;

public class Efficiency {
	
	private static double[][] CalculateMST() {
		String filename="TSP_48.txt";
		double dist[][]=TSP.ReadArrayFile(filename, " ");
		double[][] mstOfArray = MST.PrimsMST(dist);
		
		return mstOfArray;
	}
	
	private static double CalculateFitnessOfMST(double[][] mstArray) {
		
		double fitness = 0.0;
		for (int i = 0; i < mstArray.length; i++) {
			for (int j = 0; j < mstArray[i].length; j++) {
				fitness = fitness + mstArray[i][j];
			}
		}
		double fitnessScore = fitness / 2;
		return fitnessScore;
	}

	static double CalculateEfficiencyOfMST(double fitness) {
		double[][] mstArray = CalculateMST();
		double mstFitnessScore = CalculateFitnessOfMST(mstArray);
		double efficiency = (mstFitnessScore / fitness) * 100;

		return efficiency;
	}
	public static double CalcEfficiencyOPT(double fitness){
		int n=48;
		double opt=fitness_OPT(n);
		double efficiency=(opt/fitness)*100;
		return efficiency;
	}
	
	public static double fitness_OPT(int n){
		
		ArrayList<Integer> t = new ArrayList<Integer>();
		
		String filename="TSP_48_OPT.txt";
		
		t=TSP.ReadIntegerFile(filename);
		
		double dist=fitness.distance(n,t);
		return dist;
	}
}
