package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class cell{
	int x;
	int y;
	public cell(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		cell other = (cell) obj;
		if (x == other.x && y == other.y){
			return true;
		}
		
		return false;
	}
	@Override
	public String toString(){
		return "("+x+","+y+")";
	}
	
}

public class knightstour {
    public static boolean isValid(cell x,int N){
    	if(x.x<0 || x.x>N || x.y<0 || x.y>N ){
    		return false;
    	}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        cell init = new cell(0,0);
        cell dest = new cell(2,3);
        findpath(init,dest,3);

	}
	
	public static void findpath(cell init, cell dest, int N){
	     int[][] board= new int[N+1][N+1];
	     Queue<cell> list = new LinkedList<cell>();
	     Stack<cell> pushlist = new Stack<cell>();
	     list.add(init);
	     
	     int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
	     int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	     
	     while(!list.isEmpty()){
	    	 cell p= list.poll();
	    	 board[p.x][p.y]=1;
	    	 System.out.println("current cell->"+p.toString());
	    	 for(int f=0;f<8;f++){
	    		cell temp =  new cell(p.x+dx[f],p.y+dy[f]);
	    		if(temp.equals(dest)){
	    			System.out.println("dest found cell->"+temp.toString());
	    			return;
	    		}
	    		if(isValid(temp,N) && board[temp.x][temp.y]!=1){
	    			//System.out.println("cell->"+temp.toString());
	    			list.add(temp);
	    		}
	    	 }
	    	
	    	 
	     }     
	}

}
