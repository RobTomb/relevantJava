
public class two2tenWeight{

	String code = "";
	String integer = "";
	String fractional = "";

	public two2tenWeight(){

	}

	public void inputStr(String str){
		code = str;
	}

	public void string2arr(){
		if( code.indexOf(".") != -1 )
			fractional = code.split("\\.")[1];
		integer = code.split("\\.")[0];
	}

	public double integerSum(){
		double sum = 0.0;
		int length = integer.length();
		for (int i = 0 ; i < length ; i++ ) {
			sum += Integer.parseInt(integer.substring(i , i+1)) * Math.pow(2 , length - 1 - i);
		}
		
		return sum;
	}

	public double fractionalSum(){
		double sum = 0.0;
		int length = fractional.length();
		for (int i = 0 ; i < length ; i++) {
			sum += Integer.parseInt(fractional.substring(i , i+1)) * Math.pow(2 , 0 - 1 - i);
		}
		return sum;
	}

	public String input(String str){
		this.inputStr(str);
		this.string2arr();
		return Double.toString(integerSum() + fractionalSum());
	}

	public static void main(String args[]){
		String bin1 = "110111";
		String bin2 = "111";
		String bin3 = "101.11";
		String bin4 = "0.0";
		two2tenWeight tt = new two2tenWeight();
		System.out.println(tt.input(bin1));
		System.out.println(tt.input(bin2));
		System.out.println(tt.input(bin3));
		System.out.println(tt.input(bin4));
	}
}