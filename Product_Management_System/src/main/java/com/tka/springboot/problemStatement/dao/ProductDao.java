package com.tka.springboot.problemStatement.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.springboot.problemStatement.entity.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public String addProduct(Product product) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Product checkProductById = session.get(Product.class, product.getProductId());
			Session sessionCriteria = sessionFactory.openSession();
			Criteria criteria = sessionCriteria.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", product.getProductName()));
			Product checkProductByName = (Product)criteria.uniqueResult();
			if(checkProductById==null && checkProductByName==null) {
				session.save(product);
				session.beginTransaction().commit();
				return "Product added successfully";
			} else {
				return "Product already exists";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occured while adding the product :: "+e;
		} finally {
			session.close();
		}
	}

	public String deleteProductById(String productId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Product product = session.get(Product.class, productId);
			if(product!=null) {
				session.delete(product);
				session.beginTransaction().commit();
				return "Product deleted successfully";
			} else {
				return "Product doesn't exists! Can't delete product";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occured while deleting the product :: "+e;
		} finally {
			session.close();
		}
	}
	
	public String deleteProductByName(String productName) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", productName));
			Product product = (Product)criteria.uniqueResult();
			if(product!=null) {
				session.delete(product);
				session.beginTransaction().commit();
				return "Product deleted successfully";
			} else {
				return "Product doesn't exists! Can't delete product";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occured while deleting the product :: "+e;
		} finally {
			session.close();
		}
	}
	
	public Object getProductByName(String productName) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", productName));
			Product product = (Product)criteria.uniqueResult();
			if(product!=null) {
				return product;
			} else {
				return "Product not found!";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occured while fetching the product details!";
		} finally {
			session.close();
		}
	}
	
	public String updateProduct(Product product) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Session innerSession = sessionFactory.openSession();
			Product checkProduct = session.get(Product.class, product.getProductId());
			if(checkProduct!=null) {
				innerSession.update(product);
				innerSession.beginTransaction().commit();
				return "Product updated successfully";
			} else {
				return "Product not found! Can't update product";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occured while updating the product :: "+e;
		} finally {
			session.close();
		}
	}
}
