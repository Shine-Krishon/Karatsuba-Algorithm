class KaratsubaAlgorithm {
	static int numberOfDigits ( String num ) {
		return num.length();
	}

	static String power ( int nod ) {
		StringBuilder pow = new StringBuilder();
		pow.append('1');
		for( int count = 0; count < nod; count += 1 ) {
			pow.append('0');
		}

		return pow.toString();
	}

	static String karatsubaMul () {
		// arm length
		// set an environment
		String num1 = "123456";
		String num2 = "654321";
		// call the helper recursively

		return karatsubaMulHelper ( num1, num2 );
	}

	private static String karatsubaMulHelper ( String num1, String num2 ) {
		

	}

	public static void main(String[] args) {

		String res = karatsubaMul ();

		System.out.println(res);
	}
}