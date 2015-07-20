package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a^2 + b^2 = c^2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2. There
 * exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the
 * product abc.
 */
public class Pythagorean {
	static final int SumOfNumbers = 1000;

	public long find() {
		int c = 0;

		for (int a = 1; a < 500; a++) {
			for (int b = 1; b < 500; b++) {
				c = SumOfNumbers - a - b;
				if (c > 0 && a < b && (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))) {
					System.out.println("a: " + a + " b: " + b + " c: " + c + " iloczyn: " + a * b * c);
					return a * b * c;
				}
			}
		}
		return -1;
	}

	public long find2() {
		int n = 0, mMin = 0, mMax;
		int a = 0, b = 0, c = 0;
		mMax = (int) Math.sqrt(500); 
		mMin = (int) Math.sqrt(300);
		for (int m = mMin; m <= mMax; m++) {
			n = (SumOfNumbers / 2 - m * m) / m;
			if ((SumOfNumbers / 2 - m * m) % m == 0 && m > n) {
				a = 2 * m * n;
				b = m * m - n * n;
				c = m * m + n * n;
				return a * b * c;
			}
		}
		return -1;
	}

}