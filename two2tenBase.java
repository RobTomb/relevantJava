
public class two2tenBase{

	String code = "";
	String integer = "";
	String fractional = "";

	public two2tenBase(){

	}

	public void input(String str){
		code = str;
	}

	public void string2arr(){
		if( code.indexOf(".") != -1 )
			fractional = code.split("\\.")[1];
		integer = code.split("\\.")[0];
	}

	public double multiply(){
		int length = integer.length();

		if(length == 1)
			return Integer.parseInt(integer);

		double sum = Integer.parseInt(integer.substring(0 , 1)) * 2 + Integer.parseInt(integer.substring(1 , 2));

		for ( int i = 2 ; i < length; i++ ) { 
			sum = sum * 2+ Integer.parseInt(integer.substring(i , i+1)); 
		}

		return sum;
	}

	public double dividedSum(){
		int length = fractional.length();
		if(length == 1)
			return Integer.parseInt(fractional)*0.5;
		if(length == 0)
			return 0;
		double sum = Integer.parseInt(fractional.substring(length-1,length))*0.5+Integer.parseInt(fractional.substring(length-2,length-1)); 
		for (int i = length - 2; i >= 1 ; i-- ) {
			sum = sum * 0.5 + Integer.parseInt(fractional.substring(i-1,i));
		}
		return sum*0.5;
	}

	public String bin2dec(String str){
		this.input(str);
		this.string2arr();
		return Double.toString(this.multiply() + this.dividedSum());
	}
	public static void main(String args[]){
		String bin1 = "1011";
		String bin2 = "0.1011";
		String bin3 = "1.1";
		String bin4 = "0.1";
		two2tenBase tt = new two2tenBase();
		System.out.println(tt.bin2dec(bin1));
		System.out.println(tt.bin2dec(bin2));
		System.out.println(tt.bin2dec(bin3));
		System.out.println(tt.bin2dec(bin4));
	}
}