package camt.se234.project.service;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    ProductDao productDao;
    ProductServiceImpl productService;

    @Before
    public void setup() {
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("P1", "Beef", "Very delicious", "xxx1", 10.0));
        mockProducts.add(new Product("P2", "Pork", "Very delicious", "xxx2", 11.0));
        mockProducts.add(new Product("P3", "Chicken", "Very delicious and can cause gout", "xxx3", 50.0));
        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts().size(), is(3));
    }

    @Test
    public void testGetAvailableProducts() {

    }

    @Test
    public void testGetUnavailableProductSize() {

    }

    @Test
    public void testGetSaleOrders() {

    }

    @Test
    public void testAverageSaleOrderPrice() {

    }
}
