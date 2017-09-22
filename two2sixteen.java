
public class two2sixteen{

	String integer = "";
	String fractional = "";
	String code = "";

	public two2sixteen(){

	}

	public void inputStr(String str){
		code = str;
	}

	public void string2arr(){
		if(code.indexOf(".") != -1)
			fractional = code.split("\\.")[1];
		integer = code.split("\\.")[0];
	}

	public String zero(int count){
		String str = "";
		for (int i = 0 ; i < count && count != 4 ; i++ ) {
			str += "0";
		}
		return str;
	}

	public void zerofill(){
		int num = 4 - (integer.length() % 4);
		integer = zero(num) + integer; 
	}

	public void fillzero(){
		int num = 4 - (fractional.length() % 4);
		fractional += zero(num);
	}

	public String num2char(String str){
		int num = Integer.parseInt(str , 2);
		String result = "";
		if( num >= 0 && num <= 9 )
			result = num + "";
		else
			result = (char)(num + 55) + "";	
		return result;
	}

	public String binary2hex(String str){

		String hex = "";

		for (int i = 0 ; i < str.length() ; i += 4) {
			hex += num2char(str.substring(i , i + 4));
		}
		return hex;

	}

	public String input(String str){
		this.inputStr(str);
		this.string2arr();
		this.zerofill();
		this.fillzero();
		return this.binary2hex(integer) + "." + this.binary2hex(fractional);
	}

	public static void main(String args[]){
		two2sixteen ts = new two2sixteen();
		String bin1 = "1111";
		String bin2 = "1010";
		String bin3 = "011010.01";
		String bin4 = "011010.010101";
		System.out.println(ts.input(bin1));
		System.out.println(ts.input(bin2));
		System.out.println(ts.input(bin3));
		System.out.println(ts.input(bin4));
	}
}