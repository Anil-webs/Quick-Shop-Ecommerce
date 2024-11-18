package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.ActionModel;
import com.model.LikedProductsModel;
import com.model.LoginModel;
import com.model.ProductsModel;
import com.model.RegisterModel;
import com.utility.DBConnection;

public class ShoppingDAO implements ShoppingInterface{
	public String fname;
	DBConnection dbc = new DBConnection();
	
	
	/*
	 * Method: insertUpdate(RegisterModel rm)
	 * Description: This method is insert the data into database and expecting argument is RegisterModel type.
	 */
	public void insertUpdate(RegisterModel rm) {

		try {
			//Register the driver
			//connection
			Connection con  = dbc.getConnection();
			//preparedStmt
			PreparedStatement sp = con.prepareStatement("insert into customer(FirstName,UserName,Passwords)values(?,?,?)");
			sp.setString(1, rm.getFirstname());
			sp.setString(2, rm.getUsername());
			sp.setString(3, rm.getPassword());
			//updateQuery
			sp.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Method:AddProductsQuery(ProductsModel pm).
	 * Description: This method is used to inserts the products into database and expecting argunments are ProductModel type.
	 */
	public void AddProductsQuery(ProductsModel pm) {
		Connection con  = dbc.getConnection();
		System.out.println("daoproduct: "+pm.getProductName());
		try {
			PreparedStatement sp = con.prepareStatement("insert into products values(?,?,?,?)");
			sp.setInt(1, pm.getProductId());
			sp.setString(2, pm.getProductName());
			sp.setInt(3, pm.getProductQuantity());
			sp.setDouble(4, pm.getProductPrice());
			
			sp.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Method: String selectQuery(LoginModel lm).
	 * Description: This method is used to invoke the data from database and expecting argunments are LoginModel type.
	 * and return is String. And LoginServlet is calling this method.
	 */
	public String selectQuery(LoginModel lm) {
		String status = "";
		Connection con  = dbc.getConnection();
		
		try {
			PreparedStatement sp = con.prepareStatement("select * from customer where UserName = ? and Passwords = ?");
			sp.setString(1, lm.getUsername());
			sp.setString(2, lm.getPassword());
			ResultSet rs = sp.executeQuery();
			rs.last();
			int rows = rs.getRow();
			fname = rs.getString(1);
			String userName = rs.getString(2);
			String password = rs.getString(3);
			if(userName.equalsIgnoreCase(lm.getUsername()) && password.equals(lm.getPassword())) {
				status = "success";
			}else {
				status = "failure";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	
	/*
	 * Method: adminQuery(String uname, String psw).
	 * Description: This method is used to invoke the data from database and expecting two argunments are uname & psw.
	 * and return is String. And LoginServlet is calling this method.
	 */
	public String adminQuery(String uname, String psw) {
			String adminStatus = "";
		try {
			Connection con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin where username = ? and Password = ?");
			ps.setString(1, uname);
			ps.setString(2, psw);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int row = rs.getRow();
			//System.out.println("Admin row"+row);
			//System.out.println(rs.getString(1)+rs.getString(2));
			String userName = rs.getString(1);
			String password = rs.getString(2);
			if(userName.equals(uname) && password.equals(psw)) {
				adminStatus = "adminSuccess";
			}else {
				adminStatus = "adminFailure";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return adminStatus;
	}
	
	
	/*
	 * Method: fieldChecksAdmin(String uname).
	 * Description: This method is used to invoke the data from database and expecting argunments are uname.
	 * and return is String. And FieldCheckingServlet is calling this method.
	 * This method returning the string to Jquery for UserName set unique purpose.
	 */
	public String fieldChecksAdmin(String uname) {
		String statusField = "";
		try {
			Connection con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin where username = ?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int row = rs.getRow();
			if(row == 0) {
				statusField = "fieldAdminSuccess";
			}else {
				statusField = "fieldAdminFailure";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return statusField;
	}
	
	
	/*
	 * Method: fieldChecksUser(String uname).
	 * Description: This method is used to invoke the data from database and expecting argunments are uname.
	 * and return is String. And FieldCheckingServlet is calling this method.
	 * This method returning the string to Jquery for UserName set unique purpose.
	 */
	public String fieldChecksUser(String uname) {
		String statusFieldUser = "";
		try {
			Connection con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer where username = ?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int row = rs.getRow();
			if(row == 0) {
				statusFieldUser = "fieldUserSuccess";
			}else {
				statusFieldUser = "fieldUserFailure";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return statusFieldUser;
	}
	
	
	/*
	 * Method: productIdChecksFields(int productId).
	 * Description: This method is used to invoke the data from database and expecting argunments are productId.
	 * and return is String. And ProductIdCheckingField Servlet is calling this method.
	 * This method returning the string to Jquery for ProductId set unique purpose.
	 */
	public String productIdChecksFields(int productId) {
		String status = "";
		try {
			Connection con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from products where productId = ?");
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int row = rs.getRow();
			
			if(row == 0) {
				status = "success";
			}else {
				status = "failure";
			}
			
		}catch(Exception e) {
			
		}
		return status;
	}
	
	
	/*
	 * Method: ArrayList<RegisterModel> getCustomerDataToAdmin().
	 * Description: This method is used to invoke the Customerdata from database.
	 * And this return type ArrayList<RegisterModel> and calling this method is CustomerListServlet.
	 */
	public ArrayList<RegisterModel> getCustomerDataToAdmin() {
		ArrayList<RegisterModel> al = new ArrayList<>();
		try {
			Connection con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer");
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				RegisterModel rm = new RegisterModel();
				rm.setFirstname(rs.getString(1));
				rm.setUsername(rs.getString(2));
				rm.setPassword(rs.getString(3));
				
				al.add(rm);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return al;
		
	}
	
	
	/*
	 * Method: ArrayList<ProductsModel> getProductsDataToAdmin().
	 * Description: This method is used to invoke the Productsdata from database.
	 * And this return type ArrayList<ProductsModel> and calling this methods are DeleteProductsServlet, GetProductsServlets,
	 * LoginServlets, productsServlets which is newly added products & for updating products UpdatingServlet.
	 */
	public ArrayList<ProductsModel> getProductsDataToAdmin() {
		ArrayList<ProductsModel> data = new ArrayList<>();
		try {
			Connection con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from products");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductsModel pm = new ProductsModel();
				pm.setProductId(rs.getInt(1));
				pm.setProductName(rs.getString(2));
				pm.setProductQuantity(rs.getInt(3));
				pm.setProductPrice(rs.getDouble(4));
				
				data.add(pm);
			}
		}
		catch(Exception e){
		e.printStackTrace();
		}
		return data;
	}
	
	
	/*
	 * Method: ArrayList<RegisterModel> getDataIntoCustomer().
	 * Description: This method is used to invoke the Customerdata from database expecting arguments are LoginModel type
	 * And this return type ArrayList<RegisterModel> and calling this method is LoginServlet.
	 */
	public ArrayList<RegisterModel> getDataIntoCustomer(LoginModel lm) {
		ArrayList<RegisterModel> data = new ArrayList<>();
		try {
			Connection con = dbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer where UserName = ? and Passwords = ?");
			ps.setString(1, lm.getUsername());
			ps.setString(2, lm.getPassword());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				RegisterModel rm = new RegisterModel();
				rm.setFirstname(rs.getString(1));
				rm.setUsername(rs.getString(2));
				rm.setPassword(rs.getString(3));
				data.add(rm);
			}
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return data;
		
	}
	
	/*
	 * Method: deleteProductQuery(Integer productId).
	 * Description: This method is deleting the paticular data when we pass the productId that data can delete.
	 * Calling this method is deleteServlet.
	 */
	public void deleteProductQuery(Integer productId) {
		Connection con = dbc.getConnection();
		System.out.println("delete from dao");
		try {
			PreparedStatement ps = con.prepareStatement("delete from products where productId = ?");
			ps.setInt(1, productId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Method:getUpdatableData(int productId)
	 * Description: This method getting productId argument from frontend updateProducts.jsp for
	 * fetching the previous products values and displays in the from.
	 */
	public ProductsModel getUpdatableData(int productId) {
		Connection con = dbc.getConnection();
		ProductsModel pm = new ProductsModel();
		try {
			PreparedStatement ps = con.prepareStatement("select * from products where productId = ?");
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pm.setProductName(rs.getString(2));
				pm.setProductQuantity(rs.getInt(3));
				pm.setProductPrice(rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return pm;
	}
	
	
	/*
	 * Method: updateProductsQuery(ProductsModel pm).
	 * Description: This method is updating the products in database and expecting the arguments ProductsModel type.
	 * Calling this method is UpadateServlet.
	 */
	public void updateProductsQuery(ProductsModel pm) {
		Connection con = dbc.getConnection();
		try {
			PreparedStatement sp = con.prepareStatement("update products set productName = ?, Quantity = ?, price = ? where productId = ?");
			
			sp.setString(1, pm.getProductName());
			sp.setInt(2, pm.getProductQuantity());
			sp.setDouble(3, pm.getProductPrice());
			sp.setInt(4, pm.getProductId());
			sp.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Method: editCustProfile(RegisterModel rm).
	 * Description: This method is edit the customer profile and updating in the database and expecting arguments are RegisterModel type.
	 * Calling this method is editCustServlets.
	 */
	public void editCustProfile(RegisterModel rm) {
		Connection con = dbc.getConnection();
		try {
			PreparedStatement sp = con.prepareStatement("update customer set FirstName = ?, Passwords = ? where UserName = ?");
			sp.setString(1, rm.getFirstname());
			sp.setString(2, rm.getPassword());
			sp.setString(3, rm.getUsername());
			sp.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Method: ArrayList<RegisterModel> getUpdatedCustList(String userName).
	 * Description: This method is getting the updated customerList from the database and expecting arguments is userName.
	 * Calling this method is editCustServlets.
	 */
	public ArrayList<RegisterModel> getUpdatedCustList(String userName) {
		Connection con = dbc.getConnection();
		ArrayList<RegisterModel> al = new ArrayList<>();;
		try {
			PreparedStatement sp = con.prepareStatement("select * from customer where username = ?");
			sp.setString(1, userName);
			ResultSet rs = sp.executeQuery();
			while(rs.next())
			{			
				RegisterModel rm= new RegisterModel();
				rm.setFirstname(rs.getString(1));
				rm.setUsername(rs.getString(2));
				rm.setPassword(rs.getString(3));
				al.add(rm);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	
	//getting the customerId from database
	/*
	 * Method: int getCustomerId(String username).
	 * Description: This method is getting the customerId from the database and expecting arguments is userName.
	 * Calling this method is LoginServlets.
	 */
	public int getCustomerId(String username) {
		Connection con = dbc.getConnection();
		int customerId = 0;
		try {
			PreparedStatement sp = con.prepareStatement("select Cust_SNo from customer where UserName = ?");
			sp.setString(1, username);
			ResultSet rs = sp.executeQuery();
			rs.last();
			customerId = rs.getInt(1);
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerId;
	}
	
	
	/*
	 * Method: actionQuery(ActionModel am).
	 * Description: This method is insert the likes and dislikes in the database and expecting arguments is ActionModel.
	 * Calling this method is ActionServlets.
	 */
	public void actionQuery(ActionModel am) {
		Connection con = dbc.getConnection();
		try {
			PreparedStatement sp = con.prepareStatement("insert into cust_pro(productId, Cust_SNo, Action) values(?,?,?)");
			sp.setInt(1, am.getProductId());
			sp.setInt(2, am.getCustomerId());
			sp.setString(3, am.getLikesDislikes());
			
			sp.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	/*
	 * Method: String actionUpadte(ActionModel am).
	 * Description: This method is update the likes/dislikes in the database and expecting arguments is ActionModel.
	 * Calling this method is ActionServlets.
	 */
	public String actionUpadte(ActionModel am){
		Connection con = dbc.getConnection();
		String status = "";
		try {
		
			PreparedStatement sp = con.prepareStatement("update cust_pro set Action = ? where Cust_SNo = ? and productId = ?");
			
			sp.setString(1, am.getLikesDislikes());
			sp.setInt(2, am.getCustomerId());
			sp.setInt(3, am.getProductId());
			sp.executeUpdate();
			
			//This statement for when new customer likes/dislikes then row is zero its calls actionQuery() method.
			PreparedStatement sp2 = con.prepareStatement("select * from cust_pro where Cust_SNo = ? and productId = ?");
			sp2.setInt(1, am.getCustomerId());
			sp2.setInt(2, am.getProductId());
			ResultSet rs = sp2.executeQuery();
			rs.last();
			int row = rs.getRow();
			if(row == 0) {
				status = "success";
			}else {
				status = "failure";
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	/*
	 * Method: int myFavProducts(int custId).
	 * Description: This method is counting the no. of likes individual customer and expecting arguments is custId.
	 * Calling this method is MyFavProductsServlets.
	 */
	public int myFavProducts(int custId) {
		Connection con = dbc.getConnection();
		int likesCount = 0;
		try {
			PreparedStatement sp = con.prepareStatement("select count(action) from cust_pro where Cust_SNo = ? and action= 'like'");
			sp.setInt(1, custId);
			ResultSet rs = sp.executeQuery();
			rs.last();
			likesCount = rs.getInt(1);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return likesCount;
		
	}
	
	
	/*
	 * Method: ArrayList<LikedProductsModel> getLikedProducts(int custId) .
	 * Description: This method is getting the details of only liking products complete details and expecting arguments is custId.
	 * Calling this method is MyFavProductsServlets.
	 */
	public ArrayList<LikedProductsModel> getLikedProducts(int custId) {
		Connection con = dbc.getConnection();
		ArrayList<LikedProductsModel> al = new ArrayList<>();
		try {
			PreparedStatement sp = con.prepareStatement(
		            "SELECT cu.FirstName, cu.UserName, p.productName, p.price, p.productId, cp.Action " +
		            "FROM customer cu " +
		            "JOIN cust_pro cp ON cu.Cust_SNo = cp.Cust_SNo " +
		            "JOIN products p ON p.productId = cp.productId " +
		            "WHERE cu.Cust_SNo = ? AND cp.Action = 'like'"
					);
			sp.setInt(1, custId);
			ResultSet rs = sp.executeQuery();
			
			while(rs.next()) {
				LikedProductsModel lpm = new LikedProductsModel();
				lpm.setFirstName(rs.getString(1));
				lpm.setUserName(rs.getString(2));
				lpm.setProductName(rs.getString(3));
				lpm.setPrice(rs.getInt(4));
				lpm.setProductId(rs.getInt(5));
				lpm.setAction(rs.getString(6));
				
				al.add(lpm);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}
}
