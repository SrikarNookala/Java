import java.util.Calendar;

public class seeddataLoader {

	public static void main(String []args){
		String table_name="abc_trucks";
		String loaderQuery = "insert into "+table_name+" "+"(truck_id,ins_start_date,ins_end_date,fit_start_date,fit_end_date,pol_start_date,pol_end_date) values ";
		String data=" ";
		for(int i=1;i<=100;i++){
		  data = data+"("+i+","+"'2018-01-01'"+","+"'2018-12-12'"+","+"'2018-01-01'"+","+"'2018-12-12'"+","+"'2018-01-01'"+","+"'2018-12-12'"+"),";
		}
		System.out.println(loaderQuery+data);
		
		
	}
}
