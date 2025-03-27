package com.tka.springboot.problemStatement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
	
	public Object getAllProducts() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			List <Product> productList = criteria.list();
			if(!productList.isEmpty()) {
				return productList;
			} else {
				return "Product list is empty";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occurred while fetching all products ::"+e;
		} finally {
			session.close();
		}
	}
	public Object getAllProductsInAscOrder(String parameter) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc(parameter));
			List <Product> productList = criteria.list();
			if(!productList.isEmpty()) {
				return productList;
			} else {
				return "Product list is empty!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occurred while fetching all products in Ascending Order :: "+e;
		} finally {
			session.close();
		}
	}
	
	public Object getProductById(String productId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Product product = session.get(Product.class, productId);
			if(product!=null) {
				return product;
			} else {
				return "Product not found";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occured while deleting all the products:: "+e;
		} finally {
			session.close();
		}
	}
	
	public Object getProductsAboveSpecifiedPrice(double productPrice) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", productPrice));
			List <Product> productList = criteria.list();
			if(!productList.isEmpty()) {
				return productList;
			} else {
				return "Product list is empty!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occurred while fetching all products above price :: "+e;
		} finally {
			session.close();
		}
	}
	
	public Object getProductsByNamePattern(String pattern) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "%"+pattern+"%"));
			List <Product> productList = criteria.list();
			if(!productList.isEmpty()) {
				return productList;
			} else {
				return "Product list is empty !!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occured while fetching all the product with name pattern :: "+e;
		} finally {
			session.close();
		}
	}
	public Object getProductsWithinPriceRange(double initialPrice, double maxPrice) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.between("productPrice", initialPrice, maxPrice));
			List <Product> productList = criteria.list();
			if(!productList.isEmpty()) {
				return productList;
			} else {
				return "Product list is empty!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occurred while fetching the products within the price range :: "+e;
		} finally {
			session.close();
		}
	}
	
	public Object getMaxPriceProduct() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria1 = session.createCriteria(Product.class);
			criteria1.setProjection(Projections.max("productPrice"));
			List <Double> maxPriceProduct = criteria1.list();
			
			Criteria criteria2 = session.createCriteria(Product.class);
			criteria2.add(Restrictions.eq("productPrice", maxPriceProduct.get(0)));
			List <Product> productList = criteria2.list();
			if(!productList.isEmpty()) {
				return productList;
			} else {
				return "Product list is empty!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Some error occurred while fetching the max price product :: "+e;
		} finally {
			session.close();
		}
	}
}
