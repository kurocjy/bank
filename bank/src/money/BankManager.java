package money;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BankDTO dto;
		BankDAO dao = new BankDAO();
		
		System.out.println("은행 고객 관리 프로그램을 시작합니다.");
		
		//관리 프로그램 시작
		while (true) {
			System.out.println();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("1.신규고객 등록     2.고객정보 수정     3.고객탈퇴");
			System.out.println("4.고객정보 검색     5.전체 고객 리스트 보기     6.종료");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.print("번호입력>> ");
			int input = sc.nextInt();
			System.out.println();
			
			switch (input) {
			case 1:
				/*** 신규 고객 삽입 ***/
				dto = new BankDTO();
				
				System.out.println("-------------------------------------");
				System.out.println("    [등록] 등록하실 고객 정보를 입력해주세요.");
				System.out.println();
				
				System.out.print("아이디 : ");
				dto.setId(sc.next());
				System.out.print("이름 : ");
				dto.setName(sc.next());
				System.out.print("나이 : ");
				dto.setAge(sc.nextInt());
				System.out.print("전화번호 : ");
				dto.setTel(sc.next());
				System.out.println();
				
				dao.insert(dto);
				System.out.println("-------------------------------------");
				break;
			case 2:
				/*** 고객 정보 수정 ***/
				dto = new BankDTO();
				System.out.println("-------------------------------------");
				System.out.println("  [수정] 원하시는 고객의 아이디를 입력해주세요.");
				System.out.println();
				
				System.out.print("아이디 입력>> ");
				dto.setId(sc.next());
				System.out.print("수정할 전화번호 입력>> ");
				dto.setTel(sc.next());
				System.out.println();
				
				dao.update(dto);
				System.out.println("-------------------------------------");
				break;
			case 3:
				/*** 고객 탈퇴 ***/
				System.out.println("-------------------------------------");
				System.out.println("  [탈퇴] 원하시는 고객의 아이디를 입력해주세요.");
				System.out.println();
				
				System.out.print("아이디 입력>> ");
				String id = sc.next();
				System.out.println();
				
				dao.delete(id);
				System.out.println("-------------------------------------");
				break;
			case 4:
				/*** 고객 정보 검색 ***/
				System.out.println("-------------------------------------");
				System.out.println("  [검색] 원하시는 고객의 아이디를 입력해주세요.");
				System.out.println();
				
				System.out.print("아이디 입력>> ");
				id = sc.next();
				System.out.println();
				
				dto = dao.select(id);
				
				if (dto == null) {
					System.out.println("존재하지 않는 회원입니다. 다시 입력해주세요.");
				} else {					
					System.out.println("<고객 정보>");
					System.out.println("아이디 : " + dto.getId());
					System.out.println("이름 : " + dto.getName());
					System.out.println("나이 : " + dto.getAge());
					System.out.println("전화번호 : " + dto.getTel());			
				}
				System.out.println("-------------------------------------");
				break;
			case 5:
				/*** 전체 고객 리스트 ***/
				System.out.println("-------------------------------------");
				System.out.println("     [전체 고객 리스트] 리스트를 출력합니다.");
				System.out.println();
				
				ArrayList<BankDTO> list = dao.selectAll();
				
				for (int i = 0; i < list.size(); i++) {
					dto = list.get(i);
					System.out.println((i+1) + " " + dto);
				}
				System.out.println("-------------------------------------");
				break;
			case 6:
				/*** 종료 ***/
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못된 번호를 입력하였습니다.");
			}			
		}//프로그램 끝
	}
}
