package com.dao;

import java.util.ArrayList;

import com.model.ActionModel;
import com.model.LikedProductsModel;
import com.model.LoginModel;
import com.model.ProductsModel;
import com.model.RegisterModel;

public interface ShoppingInterface {
	public void insertUpdate(RegisterModel rm);
	public String selectQuery(LoginModel lm);
	public String adminQuery(String uname, String psw);
	public String fieldChecksAdmin(String uname);
	public String fieldChecksUser(String uname);
	public void AddProductsQuery(ProductsModel pm);
	public String productIdChecksFields(int productId);
	public ArrayList<RegisterModel> getCustomerDataToAdmin();
	public ArrayList<ProductsModel> getProductsDataToAdmin();
	public ArrayList<RegisterModel> getDataIntoCustomer(LoginModel lm);
	public void deleteProductQuery(Integer productId);
	public ProductsModel getUpdatableData(int productId);
	public void updateProductsQuery(ProductsModel pm);
	public void editCustProfile(RegisterModel rm);
	public ArrayList<RegisterModel> getUpdatedCustList(String userName);
	public int getCustomerId(String username);
	public void actionQuery(ActionModel am);
	public String actionUpadte(ActionModel am);
	public int myFavProducts(int custId);
	public ArrayList<LikedProductsModel> getLikedProducts(int custId);
}
