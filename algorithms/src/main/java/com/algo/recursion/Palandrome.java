package com.algo.recursion;

public class Palandrome {
	public boolean isPalandrome(char[] palArray, int startIndex, int lastIndex) {

		if (startIndex == lastIndex || startIndex > lastIndex)
			return true;
		else if (palArray[startIndex] != palArray[lastIndex]) {
			return false;

		} else {
			return isPalandrome(palArray, ++startIndex, --lastIndex);
		}

	}
}
