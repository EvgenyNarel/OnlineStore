//package com.narel.online_store.dao.daoImplementation;
//
//import com.narel.online_store.model.Product;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import lombok.Setter;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Setter
//
//@Repository
//public class ProductDaoImpl implements ProductDao {
//
//    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
//
//    private SessionFactory sessionFactory;
//
//
//    @Override
//    public void addProduct(Product product) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.persist(product);
//        logger.info("Product successfully saved: " + product);
//    }
//
//    @Override
//    public void updateProduct(Product product) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.update(product);
//        logger.info("Product successfully update: " + product);
//    }
//
//    @Override
//    public void deleteProduct(Long id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Product product = (Product) session.load(Product.class, new Long(id));
//        if (product != null) {
//            session.delete(product);
//        }
//        logger.info("Product successfully delete: " + product);
//
//    }
//
//    @Override
//    public Product getProductById(Long id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Product product = (Product) session.load(Product.class, new Long(id));
//        logger.info("Product successfully loaded: " + product);
//        return product;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Product> listProduct() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Product> productList = session.createQuery("from product").list();
//        for (Product product : productList) {
//            logger.info("Product list: " + product);
//        }
//
//        return productList;
//    }
//}
