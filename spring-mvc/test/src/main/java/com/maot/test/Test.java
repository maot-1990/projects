package com.maot.test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int number = 1;
		// 原始数二进制
		System.out.println(Integer.toBinaryString(number)+"十进制：" + number);
		number = number << 4;
		// 左移一位
		System.out.println(Integer.toBinaryString(number)+"十进制：" + number);
		number = number >> 4;
		// 右移一位
		System.out.println(Integer.toBinaryString(number)+"十进制：" + number);

	}

	public static void findNum() {
		Scanner sc = null;

		try {
			while (true) {
				int count = 0;
				sc = new Scanner(System.in);
				int find = sc.nextInt();
				int math[] = { 0, 9, 2, 5, 4, 3, 1, 7, 8, 6 };
				if (math.length > 0) {
					int temp = 0;
					int k = 0;
					for (int i = 1; i < math.length; i++) {
						count++;
						k = i - 1;
						while (k >= 0 && math[k] > math[k + 1]) {
							temp = math[k + 1];
							math[k + 1] = math[k];
							math[k] = temp;
							k--;
							count++;
						}
					}
				}
				System.out.print("执行结果为：");
				for (int j = math.length - 1; j > math.length - 1 - find; j--) {
					System.out.print(math[j] + " ");
				}
				System.out.println("");
				System.out.println(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

	public static void match() {
		Scanner sc1 = new Scanner(System.in);
		;
		String str1 = null;
		String str2 = null;
		try {
			while (true) {
				str1 = sc1.nextLine();
				str2 = sc1.nextLine();
				String findStr = "";
				String temp = "";
				int i = 0;
				int j = 1;

				while (true) {
					temp = str1.substring(i, j);
					System.out.println("每次匹配的字符串：" + temp);
					if (str2.indexOf(temp) >= 0) {
						if (findStr.length() < temp.length()) {
							findStr = temp;
						}
					}
					j++;
					if (j > str1.length()) {
						i++;
						j = i + 1;
						if (i > str1.length() || j > str1.length()) {
							break;
						}

					}
				}
				System.out.println("字符串匹配结果：" + findStr);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc1 != null) {
				sc1.close();
			}
		}

	}
}
