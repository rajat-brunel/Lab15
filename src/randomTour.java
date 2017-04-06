import java.util.ArrayList;

public class randomTour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int n=48;
		
		tour(n);
	}
	
	public static ArrayList<Integer> tour(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		ArrayList<Integer> t = new ArrayList<Integer>(); 
		
		for (int i=0;i<n;i++){
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
		System.out.println("Random Tour: ");
		System.out.println(t);
		return t;
	
	}
}
