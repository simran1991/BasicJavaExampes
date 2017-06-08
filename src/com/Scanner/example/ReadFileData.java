package com.Scanner.example;

import java.io.File;
import java.util.Scanner;

public class ReadFileData {
public static void main(String[] args) {
	File file=new File("D:/help.txt");
	try {
		System.out.println("printing...");
		Scanner sc=new Scanner(file);
		
		while(sc.hasNextLine()){
			System.out.println(sc.nextInt()+sc.nextInt());
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
