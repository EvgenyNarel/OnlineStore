package com.narel.online_store;

import com.narel.online_store.dao.User;
import com.narel.online_store.model.CartItem;
import com.narel.online_store.model.Product;
import com.narel.online_store.repository.CartItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ShoppingCartTests {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddOneCartItem() {
        Product product = entityManager.find(Product.class, 5l);
        User user = entityManager.find(User.class, 19l);

        CartItem newItem = new CartItem();
        newItem.setUser(user);
        newItem.setProduct(product);
        newItem.setQuantity(2);

        CartItem savedCartItem = cartRepo.save(newItem);
        assertTrue(savedCartItem.getId() > 0);

    }

    @Test
    public void testGetUserItemByUser() {
        User user = new User();
        user.setId(19l);

        List<CartItem> cartItems = cartRepo.findByUser(user);
        assertEquals(2l, cartItems.size());

    }
}
