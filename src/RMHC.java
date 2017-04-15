import java.util.ArrayList;

public class RMHC {

	public static void main(String[] args) {
		
	}
	
	public static double RMHC(int iter, ArrayList<Integer> s){	
		
	ArrayList<Integer> change = new ArrayList<Integer>();
	
	
	//Fitness Current Solution
	double f=Functions.distance(s);

	for (int i=0;i<iter;i++){
		
		change=Functions.swap(s);
		double f_new=Functions.distance(change);
		
			if (f_new<f){
				
				s=change;
				f=f_new;
					
			}
	}
	return f;
	
}

}
