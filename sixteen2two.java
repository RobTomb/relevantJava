
public class sixteen2two{

	String code = "";
	String[] encode = null;
 	String[] binary = {"0000" , "0001" , "0010" , "0011" , "0100" , "0101" , "0110" , "0111" , "1000" , "1001" , "1010" , "1011" , "1100" , "1101" , "1110" , "1111"};

 	public sixteen2two(){

 	}

 	public void input(String str){
 		code = str;
 	}

 	public void string2arr(){
 		encode = code.split("");
 	}

 	public void char2num(){

 		for (int i = 0 ; i <encode.length ; i++ ) {
 			int asc = (int)encode[i].charAt(0);

 			if( asc >= 97 && asc <= 102 )
 				encode[i] = (asc - 87) + "";

 			if( asc >= 65 && asc <= 70 )
 				encode[i] = (asc - 55) + "";
 		}
 	}

 	public void hex2binary(){

 		String[] result = new String[encode.length];

 		for ( int i = 0 ; i < encode.length ; i++ ) {
 			
 			if( !encode[i].equals(".") )
 				result[i] = binary[Integer.parseInt(encode[i])];
 			else
 				result[i] = encode[i];
 		}

 		encode = result;
 	}


 	public String show(){

 		String result = "";

 		for (String item : encode) {
 			result += item + " ";
 		}

 		return result;
 	}

 	public String hex2bin(String str){
 		this.input(str);
 		this.string2arr();
 		this.char2num();
 		this.hex2binary();
 		return this.show();
 	}

	public static void main(String args[]){

		String hex1 = "a.Ab";
		String hex2 = "B";
		String hex3 = "7A.3";

		sixteen2two st = new sixteen2two();
		System.out.println(st.hex2bin(hex1));
		System.out.println(st.hex2bin(hex2));
		System.out.println(st.hex2bin(hex3));
	}

}