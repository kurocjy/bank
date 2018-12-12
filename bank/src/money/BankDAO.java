package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankDAO {
	Connection con;
	PreparedStatement ps;
	
	//DB연결식
	public Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		//DB연결	
		String url = "jdbc:mysql://localhost:3306/bank";
		Connection con = DriverManager.getConnection(url, "root", "1234");
		
		return con;
	}
	
	//신규 고객 삽입
	public void insert(BankDTO dto) throws Exception {
		Connection con = connect();
		
		//SQL문 결정	
		String sql = "insert into member values (?,?,?,?)";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setInt(3, dto.getAge());
		ps.setString(4, dto.getTel());
		
		//실행요청
		ps.executeUpdate();
		System.out.println("신규 고객이 등록되었습니다.");
	}
	
	//고객 정보 수정
	public void update(BankDTO dto) throws Exception {
		Connection con = connect();
		
		//SQL문 결정
		String sql = "update member set tel = ? where id = ?";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getTel());
		ps.setString(2, dto.getId());
		
		//실행요청
		ps.executeUpdate();
		if (ps.executeUpdate() == 0) {
			System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
		} else {
			System.out.println("정보가 수정되었습니다.");			
		}
	}
	
	//고객 탈퇴
	public void delete(String id) throws Exception {
		Connection con = connect();
		
		//SQL문 결정
		String sql = "delete from member where id = ?";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, id);
		
		//실행요청
		ps.executeUpdate();
		if (ps.executeUpdate() == 0) {
			System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
		} else {
			System.out.println("탈퇴 처리를 완료하였습니다.");
		}
	}
	
	//고객 정보 검색
	public BankDTO select(String id) throws Exception {
		Connection con = connect();
		
		//SQL문 결정
		String sql = "select * from member where id = ?";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, id);
		
		//실행요청
		ResultSet rs = ps.executeQuery();
		BankDTO dto = null;
		
		while (rs.next()) {
			dto = new BankDTO();
			
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getInt(3));
			dto.setTel(rs.getString(4));
		}
		
		return dto;
	}
	
	//전체 고객 검색
	public ArrayList<BankDTO> selectAll() throws Exception {
		Connection con = connect();
		
		//SQL문 결정
		String sql = "select * from member";
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		BankDTO dto = null;
		
		ArrayList<BankDTO> list = new ArrayList<>();
		
		while (rs.next()) {
			dto = new BankDTO();
			
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getInt(3));
			dto.setTel(rs.getString(4));
			
			list.add(dto);
		}
		
		return list;
	}
}
