package hirecab;

import java.math.BigInteger;
import java.security.SecureRandom;

public class randomnum {
	private static SecureRandom random = new SecureRandom();

	  public static String nextSessionId() {
	    return new BigInteger(50, random).toString(32).toUpperCase();
	  }
}
