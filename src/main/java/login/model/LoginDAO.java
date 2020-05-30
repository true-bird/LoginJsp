package login.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import login.util.DBConnection;

public class LoginDAO {
		
	private static LoginDAO instance;
	private LoginDAO() {}
	public static LoginDAO getInstance() {
		if(instance==null) instance = new LoginDAO();
		return instance;
	}

	public void delFav(String userId, String[] imgPath) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBConnection.getConnection();
			for(String img : imgPath) {
				String sql = "delete from users_fav_tb where user_id = ? and img_path = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, img);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				throw new RuntimeException(e2.getMessage());
			}
		}
	}
	
	
	public Set<String> getFav(String userId) {
		ArrayList<String> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			con = DBConnection.getConnection();
			String sql = "select * from users_fav_tb where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			res = pstmt.executeQuery();
			while(res.next()) {
				list.add(res.getString("img_path"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return new HashSet<>(list);
	}
	
	public void addFav(String userId, String[] imgPath) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBConnection.getConnection();
			for(String img : imgPath) {
				String sql = "insert into users_fav_tb values(?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, img);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				throw new RuntimeException(e2.getMessage());
			}
		}
	}

	public void signUp(LoginDTO bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "insert into users_tb values(?,?,?,?,?)"; // 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getGender());
			pstmt.setDate(4, bean.getBirth());
			pstmt.setString(5, bean.getPassword());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				throw new RuntimeException(e2.getMessage());
			}
		}
	}
	
	
	
	public boolean find(String userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			con = DBConnection.getConnection();
			String sql = "select * from users_tb where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			res = pstmt.executeQuery();
			System.out.println("!!!");
			System.out.println(userId);
			if(res.next()) return true;
			System.out.println("null");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	
	public int find(String userId, String userPassword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			con = DBConnection.getConnection();
			String sql = "select * from users_tb where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			res = pstmt.executeQuery();

			if(res.next()) {
				if(userPassword.equals(res.getString("password"))) {
					return 1;
				}
				System.out.println(res.getString("password"));
				return -2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;
	}
	
}
