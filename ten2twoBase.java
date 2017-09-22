
public class ten2twoBase {

	String code = "";
	String integer = "";
	String fractional = "";


	public ten2twoBase(){

	}

	public void inputStr(String str){
		code = str;
	}

	public void string2arr(){
		if(code.indexOf(".") != -1)
			fractional = code.split("\\.")[1];
		integer = code.split("\\.")[0];
	}

	public String integerSum(){
		int num = Integer.parseInt(integer);
		if( num == 0 )
			return "0";
		String result = "";
		while( num != 0 ){
			result = num%2 + result;
			num = (int)num / 2;
		}
		return result;
	}

	public String fractionalSum(){
		if( fractional.length() == 0 )
			return "0";
		double num = Double.parseDouble("0." + fractional);
		String result = "";
		while( num - 1 != 0 ){
			num = num * 2;
			result += (int)num;
			if(num > 1)
				num -= 1;
		}
		return result;
	}

	public String input(String str){
		this.inputStr(str);
		this.string2arr();
		return this.integerSum() + "." + this.fractionalSum();
	}

	public static void main(String args[]){
		ten2twoBase ttb = new ten2twoBase();
		String ten1 = "116";
		String ten2 = "0.625";
		String ten3 = "116.625";
		System.out.println(ttb.input(ten1));
		System.out.println(ttb.input(ten2));
		System.out.println(ttb.input(ten3));
	}
}