
public class ten2twoWeight{

	String code = "";
	String integer = "";
	String fractional = "";

	public ten2twoWeight(){

	}

	public void inputStr(String str){
		code = str;
	}

	public void string2arr(){
		if( code.indexOf(".") != -1 )
			fractional = code.split("\\.")[1];
		integer = code.split("\\.")[0];
	}

	public double getPow(int i){
		return Math.pow(2 , i);
	}

	public int getMaxnum(double num){
		double maxNum = 0;
		int i = 0;
		for ( ; maxNum * 2 < num ; i++) {
			maxNum = getPow(i);
		}
		return i-1;
	}

	public String integerSum(){

		String result = "";
		Double number = Double.parseDouble(integer);
		int count = getMaxnum(number);

		while(count != -1){
			if( number - getPow(count) >= 0 ){
				result += "1";
				number = number - getPow(count);
			}
			else
				result += "0";
			count -= 1;
		}
		return result;
	}

	public int getMinNum(double num){
		double minNum = 0;
		int i = -1;
		for ( ; minNum * 2 < num; i--) {
			minNum = getPow(i);
		}
		return i+1;
	}

	public String fractionalSum(){

		String result = "";
		fractional = "0." + fractional;
		double number = Double.parseDouble(fractional);
		int count = getMinNum(number);

		for ( int i = 0 ; i < 10 ; i++) {
			if(number - getPow(count) >= 0){
				result += "1";
				number -= getPow(count);
			}
			else
				result += "0";
			count -= 1;
		}
		return result;
	}

	public String input(String str){
		this.inputStr(str);
		this.string2arr();
		if(fractional.length() == 0)
			return this.integerSum();
		else if(integer.equals("0"))
			return "0." + this.fractionalSum();
		else
			return this.integerSum() + "." + this.fractionalSum();
	}

	public static void main(String args[]){
		ten2twoWeight tt = new ten2twoWeight();
		String dec1 = "116";
		String dec2 = "0.0";
		String dec3 = "116.635";
		String dec4 = "3.635";
		System.out.println(tt.input(dec1));
		System.out.println(tt.input(dec2));
		System.out.println(tt.input(dec3));
		System.out.println(tt.input(dec4));
	}
}