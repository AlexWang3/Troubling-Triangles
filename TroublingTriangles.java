package TroublingTriangles;
import java.util.*;
public class TroublingTriangles {
	static int N;
	static int [][] points;
	static float [] A;
	static float [] P;
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {		
		N=in.nextInt();
		points=new int[N][6];
		A=new float[N];
		P=new float[N];
		Input();
		double x,y,z;
		for (int i=0;i<N;i++) {
			x=Math.sqrt(Math.pow(points[i][2]-points[i][0],2)+Math.pow(points[i][3]-points[i][1],2));
			y=Math.sqrt(Math.pow(points[i][4]-points[i][0],2)+Math.pow(points[i][5]-points[i][1],2));
			z=Math.sqrt(Math.pow(points[i][2]-points[i][4],2)+Math.pow(points[i][3]-points[i][5],2));
			CalculateA(i,x,y,z);
			CalculateP(i,x,y,z);
		}
		for(int i=0;i<N;i++) {
			System.out.printf("%.2f",A[i]);
			System.out.print(" ");
			System.out.printf("%.2f",P[i]);
			System.out.println();
		}
	}
	private static void Input() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<6;j++) {
				points[i][j]=in.nextInt();
			}
		}
		
	}
	private static void CalculateP(int i,double x,double y, double z) {
		P[i]=(float)(x+y+z);	
	}
	private static void CalculateA(int i, double x, double y, double z) {
		double angle=Math.acos((x*x-y*y-z*z)/(2*y*z));
		double h=y*Math.sin(angle);
		A[i]=(float)(z*h/2);
	}

}
