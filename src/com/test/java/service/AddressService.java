package com.test.java.service;

import java.util.List;
import java.util.Scanner;

import com.test.java.dto.AddressDto;
import com.test.java.repository.AddressDao;
import com.test.java.ui.AddressUi;

public class AddressService {
	
	private AddressDao dao;
	private AddressUi ui;
	private AddressDto dto;
	
	public AddressService() {
		this.dao = new AddressDao();
		this.ui = new AddressUi();
		this.dto = new AddressDto();
	}


	public void list() {

		// 주소록 목록 보기
		
		List<AddressDto> list = dao.list();
		
		ui.printlist(list);
			
	}

	public void add() {
		
		// 주소록 추가하기
		// - 파일 쓰기 > AddressDao 위임
		
		// 사용자 입력 > (전달) > Dao + 파일 쓰기
		ui.subMenu("2. 주소록 추가하기");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		String age = scan.nextLine();
		
		System.out.print("성별(남자(1), 여자(2): ");
		String gender = scan.nextLine();
		
		System.out.print("전화번호: ");
		String tel = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		// *** 권장사항
		// - 계층과 계층간에 데이터를 전달할 때 > 되도록 상자에 담아서 넘겨라
		// dao.add(name, age, gender, tel, address);
		
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setAddress(address);
		
		dao.add(dto);
		
		ui.completedMessage(ui.ADD);
		
	}

	public void delete() {
		
		// 주소록 삭제하기
		// 사용자 입력(이름) > 파일에서 해당 정보를 삭제하기
		ui.subMenu("3.주소록 삭제하기");//이것도 상수로 조건문에서 판단하는게 더 좋음 나중에 바꾸기
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		dao.delete(name);
		
		ui.completedMessage(ui.DELETE);
		
		
		
	}

	public void search() {
		
		// 주소록 검색하기
		// - 검색어 입력 > Dao에게 결과 반환
		ui.subMenu("4.주소록 검색하기");

		Scanner scan = new Scanner(System.in);
		
		System.out.print("지역: ");
		String word = scan.nextLine();
		
		List<AddressDto> list  = dao.search(word);
		
		ui.completedMessage(ui.SEARCH);
		
		ui.printlist(list);
		
	}

}
