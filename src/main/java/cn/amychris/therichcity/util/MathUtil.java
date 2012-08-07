package cn.amychris.therichcity.util;

public class MathUtil {

	public static boolean equals(Long long1, Long long2) {
		
		return null != long1 ? long1.equals( long2 ) : null == long2;
	}

	public static boolean equals( Integer int1, Integer int2 ) {
		return null != int1 ? int1.equals( int2 ) : null == int2;
	}
}
