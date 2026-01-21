package com.test.java.ui;

import java.util.List;
import java.util.Scanner;

import com.test.java.dto.AddressDto;

public class AddressUi {
	
	public final static int ADD = 2;
	public final static int DELETE = 3;
	public static final int SEARCH = 4;
	
	public static void mainMenu() {
		
		System.out.println("=========================================================================");
		System.out.println("\t\t\t\t 🏠주소록");
		System.out.println("=========================================================================");
		System.out.println("1. 주소록 목록보기");
		System.out.println("2. 주소록 추가하기");
		System.out.println("3. 주소록 삭제하기");
		System.out.println("4. 주소록 검색하기");
		System.out.println("5. 종료");
		System.out.print("선택(번호): ");
		
	}
	
	public static void closedMessage() {

		System.out.println();
		System.out.println("⚠️🔚주소록을 종료합니다.");
		System.out.println();
		
	}

	public static void pause() {
		
		// 각 메뉴 실행이 끝난 뒤 잠시 프로그램을 일시 중지
		Scanner scan = new Scanner(System.in);
		
		System.out.print("⚠️ 계속 하시려면 엔터를 입력하세요");
		scan.nextLine();
		
		System.out.println();
	}

	public void printlist(List<AddressDto> list) {
		
		// 표 출력
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("\t\t\t1. 주소록 목록보기");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("[이름]\t[나이]\t[성별]\t[전화]\t\t[주소]");
		
		// 이름순으로 정렬
		list.sort((a,b) -> a.getName().compareTo(b.getName()));
		
		for(AddressDto dto : list) {
			
			System.out.printf("%s\t%5s\t%3s\t%s\t%s\n"
					, dto.getName()
					, dto.getAge()
					, dto.getGender().equals("1")? "남자":"여자"
					, dto.getTel()
					, dto.getAddress());
			
		}
		
		System.out.println();
		
	}
	

	public void completedMessage(int num) {
		String message = "";
		if(num == 2) {
			System.out.println("⚠️🔚주소록을 추가했습니다.");
		} else if(num == 3) {
			System.out.println("⚠️주소록을 삭제했습니다.");
		}
		
		System.out.println();
	}

	public void subMenu(String title) {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("\t\t\t" + title);
		System.out.println("-------------------------------------------------------------------------");
	}
	
}
