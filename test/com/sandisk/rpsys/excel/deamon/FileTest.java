package com.sandisk.rpsys.excel.deamon;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("xls/test.txt");
		System.out.println(file.getAbsolutePath());
	}

}
