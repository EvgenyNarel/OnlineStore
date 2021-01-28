package com.narel.online_store.service;

import com.narel.online_store.model.Product;
import com.narel.online_store.repository.ProductRepository;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service
public class ProductServiceImpl {

    private final ProductRepository productRepository;
//    private SessionFactory sessionFactory;
//    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

//    public void updateProduct(Product product) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.update(product);
//        logger.info("Product successfully update: " + product);
//    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.getOne(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
