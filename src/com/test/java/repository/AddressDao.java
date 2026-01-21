package com.test.java.repository;

// 파일 입출력 담당자

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.test.java.dto.AddressDto;

// -DAO(Data Access Object) > 데이터를 직접 조작하는 업무 객체
public class AddressDao {
	
	private final String PATH; 
	
	public AddressDao() {
		this.PATH = ".\\data\\address.txt";
	}
	
	public List<AddressDto> list(){
		
		// address.txt > (읽기) > 반환
		try(BufferedReader reader = new BufferedReader(new FileReader(PATH));) {
			
			String line = null;
			List<AddressDto> list = new ArrayList<AddressDto>();
			
			while ((line = reader.readLine()) != null) {
				// 파싱 parsing
				String[] temp = line.split(",");
				
				// Raw Data > (포장) > AddressDto
				AddressDto dto = new AddressDto();
				dto.setName(temp[0]);
				dto.setAge(temp[1]);
				dto.setGender(temp[2]);
				dto.setTel(temp[3]);
				dto.setAddress(temp[4]);
				
				list.add(dto);
			
			}
			
			return list; // 주소록 목록(= list<AddressDto>)
			
		} catch (Exception e) {
			System.out.println("AddressDao.list() 예외 발생");
			e.printStackTrace();
		}
		
		return null; // 목록에 아무도 없다.
		
	}

	public void add(AddressDto dto) {
		
		// Dto > (항목) > 파일에쓰기
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, StandardCharsets.UTF_8, true))) {// append 모드 트루
			
			String line = String.format("%s,%s,%s,%s,%s\r\n"
											, dto.getName()
											, dto.getAge()
											, dto.getGender()
											, dto.getTel()
											, dto.getAddress());
			writer.write(line);
			
		} catch (Exception e) {
			System.out.println("AddressDao.add() 예외 발생");
			e.printStackTrace();
		}
		
	}

	public void delete(String name) {
		
		
		
		// 읽고
		try {
			
			String wholeText = "";
			String line = null;
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			// 파일에서 원하는 줄(한사람)을 삭제하기
			// - 텍스트 입출력 > 삭제라는 행위 없음.
			
			// 삭제해야될 내용만 빼고 저장한 뒤
			while((line = reader.readLine()) != null) {
				if(!line.startsWith(name)) {
				wholeText += line + "\r\n";
				}
			}
			reader.close();
			
			// 쓰기
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
			writer.write(wholeText);
			writer.close();
			
		} catch (Exception e) {
			System.out.println("AddressDao.delete() 예외 발생");
			e.printStackTrace();
		}
		
	}

	public List<AddressDto> search(String word) {
		
		try(BufferedReader reader = new BufferedReader(new FileReader(PATH));) {
			
			String line = null;
			List<AddressDto> list = new ArrayList<AddressDto>();
			
			while ((line = reader.readLine()) != null) {
				// 파싱 parsing
				String[] temp = line.split(",");
				
				// Raw Data > (포장) > AddressDto
				if(temp[4].replace(" ","").contains(word.replace(" ",""))) {
					AddressDto dto = new AddressDto();
					dto.setName(temp[0]);
					dto.setAge(temp[1]);
					dto.setGender(temp[2]);
					dto.setTel(temp[3]);
					dto.setAddress(temp[4]);
					
					list.add(dto);
				}
			}
			
			return list; // 주소록 목록(= list<AddressDto>)
			
		} catch (Exception e) {
			System.out.println("AddressDao.list() 예외 발생");
			e.printStackTrace();
		}
		
		return null; // 목록에 아무도 없다.
		
		
	}
	
}
