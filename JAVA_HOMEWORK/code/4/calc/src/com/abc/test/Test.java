package com.abc.test;

import com.abc.calc.Calc; //������������������

public class Test {
	public static void main(String[] args) {
		Calc c = new Calc(); // ȥ������������

		System.out.println("5 + 6 = " + c.add(5, 6));
		System.out.println("11 - 5 = " + c.sub(11, 5));
	}
}
