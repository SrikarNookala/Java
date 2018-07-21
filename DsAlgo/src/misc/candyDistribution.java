package misc;

public class candyDistribution {

	public static void main(String []args){
		// marks distribution, each student has to be provided a chocolate, but if the adjacent grade is higher count should be more
		int dist[] = {1,2,3,4,2,3};
		counter(dist);
		int dist2[] = {1,4,3,2};
		counter(dist2);
		int dist3[] = {4,3,2};
		counter(dist3);
		int dist4[] = {2,3,4};
		counter(dist4);
	}
	/* wrong
	public static void counter(int []a){	
		int c=0;
		int total=0;
		int dist[] = new int[a.length];
		for(int i=0;i<dist.length;i++){
			if(i==a.length-1 || a[i]>=a[i+1]){	
				if(i!=0 && a[i]==a[i-1]){
					dist[i]=c;
				}else{
					c++;
					dist[i]=c;
					if(i==a.length-1 || a[i]!=a[i+1]){
						c=0;
					}
				}
			}else{
				c++;
				dist[i]=c;
			}
		}
		for(int j=0;j<dist.length;j++){
			System.out.print(dist[j]+" ");
			total = total+dist[j];
		}
		System.out.println(total);
		
	}
	*/
	
	public static void counter(int []a){	
		int ascent=0;
		int total=0;
		int dist[] = new int[a.length];
		for(int i=0;i<dist.length;i++){
			if(i==0 || a[i]<=a[i-1]){
				ascent=0;
			}else{
				ascent++;
			}
			int descent=0;
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					descent++;
				}else{
					break;
				}
			}
			dist[i]= Integer.max(ascent, descent)+1;
		}
		for(int j=0;j<dist.length;j++){
			System.out.print(dist[j]+" ");
			total = total+dist[j];
		}
		System.out.println("total-"+total);
		
	}	
}
