package misc;

public class longestpossibleSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(lps2("geeksforgeeks"));
	}

	private static String lps(String string) {
		// TODO Auto-generated method stub
		String ans="";
		for(int i=0;i<string.length()-1;i++){
			String temp="";
			for(int j=i+1;j<string.length();j++){
				if(!temp.contains(string.charAt(j)+"")){
					temp = temp+string.charAt(j);
				}else{
					if(temp.length()>ans.length()){
						ans=temp;
					}
					break;
				}
			}
		}
		return ans;
	}
	private static String lps2(String s) {
		int[] p = new int[256];
		for(int i=0;i<p.length;i++){
			p[i]=-1;
		}
		String ans="";
		int l = 0;
		String temp="";
		for(int i=0;i<s.length();i++){
			if(p[(int)s.charAt(i)]!=-1){
					// this is repeated
					l=ans.length();
					ans = temp;
					temp="";
				p[(int)s.charAt(i)] = i;
			}else{
				p[(int)s.charAt(i)] = i;
				temp = temp+s.charAt(i);
			}
		    
		}
		return ans;
	}

}
