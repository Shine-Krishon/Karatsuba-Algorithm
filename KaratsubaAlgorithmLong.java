class KaratsubaAlgorithmLong {

	static int numberOfDigits ( long num ) {
		long numCopy = num;

		int nod = 0;

		while ( numCopy != 0 ) {
			numCopy = numCopy / (long)10;
			nod += 1;
		}

		return nod;
	}

	static long power ( int nod ) {
		long pow = 1;
		for ( int times = 0; times < nod; times += 1) {
			pow *= 10;
		}

		return pow;
	}

	static long karatsubaMul () {
		// arm length
		// set an environment
		long num1 = 123456652658910962L;
		long num2 = 65432185763776763L;
		// call the helper recursively

		return karatsubaMulHelper ( num1, num2 );
	}

	private static long karatsubaMulHelper ( long num1, long num2 ) {
		if ( num1 < 10 || num2 < 10 ) {
			return num1 * num2;
		}

		int nod1 = numberOfDigits( num1 );
		int nod2 = numberOfDigits( num2 );

		int nod = nod1 > nod2 ? nod1 : nod2;
		int halfNod = (nod + 1) / 2;
		long pow = power( halfNod );

		long firstHalf1 = num1 /  pow;
		long secondHalf1 = num1 % pow;
		long firstHalf2 = num2 /  pow;
		long secondHalf2 = num2 % pow;

		long high, low, highLow;

		low = karatsubaMulHelper ( secondHalf1, secondHalf2 );
		highLow = karatsubaMulHelper ( firstHalf1 + secondHalf1, firstHalf2 + secondHalf2 );
		high = karatsubaMulHelper ( firstHalf1, firstHalf2 );

		long res = ( ( high * power ( 2 * halfNod ) ) + ( highLow - high - low ) * pow + low );

		return res;

	}

	public static void main(String[] args) {

		long res = karatsubaMul ();

		System.out.println(res);
	}
}