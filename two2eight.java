
public class two2eight{

	String integer = "";
	String fractional = "";
	String code = "";

	public two2eight(){

	}

	public void input(String str){
		code = str;
	}

	public void str2arr(){
		if( code.indexOf(".") != -1 )
			fractional = code.split("\\.")[1];
		integer = code.split("\\.")[0];
	}

	public String zero(int count){
		String str = "";
		for (int i = 0 ; i < count && count != 3; i++ ) {
			str += "0";
		}
		return str;
	}

	public void fillZero(){
		int num = 3 - ( fractional.length() % 3);
		fractional += zero(num);
	}

	public void zeroFill(){
		int num = 3 - (integer.length() % 3);
		integer = zero(num) + integer;
	}

	public String binary2oct(String str){

		String oct = "";

		for (int i = 0 ; i < str.length() ; i += 3) {
			oct += Integer.parseInt(str.substring(i , i + 3),2) + "";
		}
		return oct;
	}

	public String bin2oct(String str){
		this.input(str);
		this.str2arr();
		this.zeroFill();
		this.fillZero();
		return binary2oct(integer) + "." + binary2oct(fractional);
	}

	public static void main(String[] args){
		String bin1 = "100.001";
		String bin2 = "11";
		String bin3 = "0.10";
		String bin4 = "001110.101";

		two2eight te = new two2eight();

		System.out.println( te.bin2oct(bin1));
		System.out.println( te.bin2oct(bin2));
		System.out.println( te.bin2oct(bin3));
		System.out.println( te.bin2oct(bin4));
		
	}

}