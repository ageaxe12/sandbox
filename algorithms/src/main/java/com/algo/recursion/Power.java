package com.algo.recursion;

public class Power {
	public double pow(int base , int exp) {
		if(exp == 0 ) {
			return 1;
		}else if (exp > 0 && exp % 2 == 0) {
			double y  =  pow(base,exp/2);
			return y*y;
		}else if(exp > 0 ) {
			return base*pow(base,--exp);	
		}else {
			double y  =  pow(base,-exp);
			return 1/y;
		}
	}

}
