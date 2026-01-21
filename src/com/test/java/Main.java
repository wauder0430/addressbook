package com.test.java;

import java.util.Scanner;

import com.test.java.service.AddressService;
import com.test.java.ui.AddressUi;

public class Main {	//Controller
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		AddressService service = new AddressService();
		
		while(true) {
			
			AddressUi.mainMenu();
			
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				
				service.list();	// 업무 위임 > 메서드 호출
				
			} else if(input.equals("2")) {
				
				service.add();
				
			} else if(input.equals("3")) {
				
				service.delete();
				
			} else if(input.equals("4")) {
				
				service.search();
				
			} else {
				
				break;
				
			}
			
			// 잠시 멈춤
			AddressUi.pause();
			
		}
		
		AddressUi.closedMessage();
				
	}
}
