package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	ResultSet rs;
	Connection conn;
	PreparedStatement pstmt;

	public void getCon() {
		

		try {
			Context initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/Oracle11g");
			conn=ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//rs.close();
				//pstmt.close();
				//conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	// 하나의 새로운 게시글이 넘어와서 DB에 저장되는 메서드
	public void insertBoard(BoardBean bean) {
		getCon();
		
		int ref= 0;
		int re_step= 1;
		int re_level= 1;
		
		try {
		String refsql ="select max(ref) from board";
		pstmt=conn.prepareStatement(refsql);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			ref=rs.getInt(1)+1; // 아직 답글 없고 글만 ㅇㅇ
		}
		String sql = "insert into board values(board_seq.nextval,?,?,?,?,sysdate,?,?,?,0,?)";
		
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, bean.getWriter());
        pstmt.setString(2, bean.getEmail());
        pstmt.setString(3, bean.getSubject());
        pstmt.setString(4, bean.getPassword());
        pstmt.setInt(5, ref);
        pstmt.setInt(6, re_step);
        pstmt.setInt(7, re_level);
        pstmt.setString(8, bean.getContent());
        pstmt.executeUpdate();
		
		
		pstmt.close();
		conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	// 모든 게시글을 리턴해주는 메서드
	public Vector<BoardBean> getAllBoard(int start, int end){
		Vector<BoardBean> vec = new Vector<>();
		getCon();
		
		try {
			String sql="select * from(select A.*, Rownum Rnum from(select * from board order by ref desc, re_step asc)A)"+" where Rnum >= ? and Rnum <= ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean bean = new BoardBean();
				
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getString(6).toString()	);
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				vec.add(bean);
				
			}
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vec;
	
	}
	
	//BoardInfo 일 때 :하나의 게시글을 리턴하는 메서드
	public BoardBean getOneBoard(int num) {
		BoardBean bean = new BoardBean();
		getCon();
		
		try {
			// 조회수 증가 쿼리
			String readsql = "update board set readcount=readcount+1 where num=?";
			pstmt=conn.prepareStatement(readsql);
			pstmt.setInt(1, num);
			pstmt.execute();
			
			// 하나의 게시글 정보(BoardBean)을 보기 위한 쿼리
			
			String sql = "select * from board where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			

            if (rs.next()) { 
                bean.setNum(rs.getInt(1));
                bean.setWriter(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setSubject(rs.getString(4));
                bean.setPassword(rs.getString(5));
                bean.setReg_date(rs.getDate(6).toString()); // reg데이터가 String타입으로 변한다.
                bean.setRef(rs.getInt(7));
                bean.setRe_step(rs.getInt(8));
                bean.setRe_level(rs.getInt(9));
                bean.setReadcount(rs.getInt(10));
                bean.setContent(rs.getString(11));
            }
            pstmt.close();
            conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return bean;
	}
	
	// 답변글이 저장되는 메서드
	public void reWriteBoard(BoardBean bean) {
		int ref = bean.getRef();
		int re_step = bean.getRe_step();
		int re_level = bean.getRe_level();
		
		getCon();
		
		try {
			String levelsql = "update board set re_level=re_level+1 where ref=? and re_level > ? ";
			pstmt=conn.prepareStatement(levelsql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_level);
			pstmt.executeUpdate();
			
			
			String sql="insert into board values(board_seq.nextval,?,?,?,?,sysdate,?,?,?,0,?)";
			pstmt=conn.prepareStatement(sql);
	        pstmt.setString(1, bean.getWriter());
	        pstmt.setString(2, bean.getEmail());
	        pstmt.setString(3, bean.getSubject());
	        pstmt.setString(4, bean.getPassword());
	        pstmt.setInt(5, ref);
	        pstmt.setInt(6, re_step+1);
	        pstmt.setInt(7, re_level+1);
	        pstmt.setString(8, bean.getContent());
	        pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Boardupdate용 하나의 게시글을 리턴
	//Boardupdate용 delete시 하나의 게시글을 리턴
	public BoardBean getOneUpdateBoard(int num) {
		BoardBean bean = new BoardBean();
		getCon();
		try {
			String sql="select * from board where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getString(6).toString()	);
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				
			}
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return bean;
	}
	
	// update와 delete시 필요한 패스워드 값을 리턴해주는 메서드
	public String getPass(int num) {
		String pass="";
		getCon();
		try {
			//쿼리 준비
			String sql="select password from board where num=?"; 
			// 쿼리 실행할 객체 선언
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			//쿼리 실행 후 결괄를 리턴
			rs=pstmt.executeQuery();			
			//패스워드값을저장
			
			if(rs.next()) {
				pass=rs.getString(1);
			}else {
				pstmt.close();
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return pass;
	}
	
	//하나의 게시글을 수정하는 메서드
	public void updateBoard(BoardBean bean){
		getCon();

		try {
			String sql = "update board set subject=?, content=? where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getContent());
			pstmt.setInt(3, bean.getNum());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	// 하나의 게시글을 삭제하는 메서드
	public void deleteBoard(int num) {
		getCon();
		
		try {
			String sql = "delete board where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);	
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 전체글의 개수를 리턴하는 메서드
	public int getAllCount() {
		getCon();
		int count = 0;
		
		try {
			String sql = "select count(*) from board";
			pstmt=conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
				
			}
			
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
	
	
}
//회원가입, db,
//본프할땐 그걸 바탕으로 머리맞대서 