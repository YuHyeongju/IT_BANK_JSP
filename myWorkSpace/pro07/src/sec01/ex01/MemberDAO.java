package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {//데이터 베이스에 접속, 데이터 추가,삭제,수정등을 하는 클래스

	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private Connection con;
	private Statement stmt;
	
	
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			connDB();
			String query = "select * from t_member"; 
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query); //executeQuery: select 문 수행
			while(rs.next()){//next()메소드를 사용하여 다음 로우로 이동
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo  = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	private void connDB() { //크롬에서 DB접속 요청을 할때 마다 실행됨
		try {
			Class.forName(driver);
			System.out.println("Oricle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user , pwd);
			System.out.println("Connection 생성 성공");
			stmt = con.createStatement(); //sql문을 작성할수 있는 객체생성
			System.out.println("Statement 생성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
