
public class eight2two{

	String code = "";
	String[] encode = null;
 	String[] binary = {"000" , "001" , "010" , "011" , "100" , "101" , "110" , "111"};

	public eight2two(){

	}

	public void input(String str){
		code = str;
	}

	public void string2arr(){
		encode = code.split("");
	}

	public void oct2binary(){

		String[] binaryArr = new String[encode.length];

		for ( int i = 0 ; i < encode.length ; i++ ) {

			if( !encode[i].equals(".") ){
				binaryArr[i] = binary[Integer.parseInt(encode[i])];
			}
			else
				binaryArr[i] = encode[i];
		}

		encode = binaryArr;
	}


	public String arr2string(){
		String result = ""; 

		for (String item: encode) {
			result += item + " ";
		}

		return result;
	}

	public String oct2bin(){
		this.string2arr();
		this.oct2binary();
		return this.arr2string();
	}

	public static void main(String args[]){
		String oct1 = "123.123";
		String oct2 = "123";
		String oct3 = "0.123";
		eight2two et = new eight2two();
		et.input(oct3);
		System.out.println(et.oct2bin());
	}
}