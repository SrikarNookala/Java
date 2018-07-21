package misc;
class coordinate{
	public int x;
	public int y;
	public coordinate(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class knightstour {

	public static void main(String []args){
		int a[][] = new int[8][8];
		calculate(a,0,0,1,3);
	}
	public static boolean calculate(int a[][],int x,int y,int p,int q){
		if(
		check(a,x+2,y+1,p,q)||
		check(a,x+1,y+2,p,q)||
		check(a,x+2,y-1,p,q)||
		check(a,x+1,y-2,p,q)||
		check(a,x-2,y+1,p,q)||
		check(a,x-2,y-1,p,q)||
		check(a,x-1,y+2,p,q)||
		check(a,x-1,y-2,p,q)){
			return true;
		}
		return false;
		
	}
	public static boolean isValid(int x,int y){
		if(x<0 || x>7 ||y<0 || y>7){
			return false;
		}
		return true;
	}
	public static boolean check(int a[][],int x,int y,int p, int q){
		if(isValid(x,y)){
			if(a[x][y]==1){
				return false;
			}
			if(x==p && y==q){
				a[x][y]=8;
				print(a);
				return true;
			}
			a[x][y]=1;
			if(!calculate(a,x,y,p,q)){
				a[x][y]=0;
				return false;
			}
		}
		return false;
	}
	public static void print(int [][]matrix){
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
	        System.out.print(matrix[i][j] + " ");
	    }
	    System.out.println();
	}
	}
}
