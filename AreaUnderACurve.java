import java.util.Scanner;

public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.
		double prevArea = 0.0; 
		double newArea = 0.0; 

		PriorityQueue pq = new PriorityQueue(10);
		pq.insert(new Interval(a, b)); 

		prevArea = (b - a) * f(b); 

		while(!checkError(newArea, prevArea, error)){
			
			Interval max = pq.remove_max();
			double start = max.getStart();
			double end = max.getEnd();
			double mid = start + max.getLength()/2.0;

			pq.insert(new Interval(start, mid));
			pq.insert(new Interval(mid, end));
			double tempArea = 0.0; 

			newArea = prevArea - ((end - start) * f(end)) + ((mid - start) * f(mid)) + ((end - mid) * f(end)); 
			
			tempArea = prevArea; 
			prevArea = newArea; 
			newArea = tempArea; 
		}



		
		return newArea; // Remove this statement and return the computed area.
	}

	public static boolean checkError(double d, double c, double error){
		double diff = Math.abs(d - c);
		return diff <= error; // was originally error in spot of 0
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
