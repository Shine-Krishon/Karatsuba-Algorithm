import java.math.BigInteger;

class KaratsubaAlgorithmBigInt {
	static int numberOfDigits ( BigInteger num ) {
		return num.toString().length();
	}

	static BigInteger power ( int nod ) {
		return BigInteger.TEN.pow(nod );
	}

	static BigInteger karatsubaMul () {
		// arm length
		// set an environment
		BigInteger num1 = new BigInteger("123456");
		BigInteger num2 = new BigInteger("654321");
		// call the helper recursively

		return karatsubaMulHelper ( num1, num2 );
	}

	private static BigInteger karatsubaMulHelper ( BigInteger num1, BigInteger num2 ) {
		if ( num1.compareTo(BigInteger.TEN) < 0 || num2.compareTo(BigInteger.TEN) < 0 ) {
			return num1.multiply( num2 );
		}

		int nod1 = numberOfDigits( num1 );
		int nod2 = numberOfDigits( num2 );

		int nod = nod1 > nod2 ? nod1 : nod2;
		int halfNod = (nod + 1) / 2;
		BigInteger pow = power( halfNod );

		BigInteger firstHalf1 = num1.divide( pow );
		BigInteger secondHalf1 = num1.mod( pow );
		BigInteger firstHalf2 = num2.divide( pow );
		BigInteger secondHalf2 = num2.mod( pow );

		BigInteger high, low, highLow;

		low = karatsubaMulHelper ( secondHalf1, secondHalf2 );
		highLow = karatsubaMulHelper ( firstHalf1.add( secondHalf1 ), firstHalf2.add( secondHalf2 ) );
		high = karatsubaMulHelper ( firstHalf1, firstHalf2 );

		BigInteger res = ( high.multiply( power ( 2 * halfNod ) ) ).add( ( highLow.subtract( high.add( low ) ) ).multiply( pow ) ).add( low );

		return res;

	}

	public static void main(String[] args) {

		BigInteger res = karatsubaMul ();

		System.out.println(res);
	}
}