package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServiceImplTest {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;

    @Before
    public void setup() {
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }

    @Test
    public void testGetSaleOrders() {
        List<SaleOrder> mockOrders = new ArrayList<>();
        mockOrders.add(new SaleOrder("S1", new ArrayList<SaleTransaction>()));
        mockOrders.add(new SaleOrder("S2", new ArrayList<SaleTransaction>()));
        mockOrders.add(new SaleOrder("S3", new ArrayList<SaleTransaction>()));
        when(orderDao.getOrders()).thenReturn(mockOrders);
        assertThat(saleOrderService.getSaleOrders(), hasItems(new SaleOrder("S1", new ArrayList<SaleTransaction>()),
                new SaleOrder("S2", new ArrayList<SaleTransaction>()),
                new SaleOrder("S3", new ArrayList<SaleTransaction>())));
    }

    @Test
    public void testAverageSaleOrderPrice() {
        List<SaleTransaction> mockTransactions1 = new ArrayList<>();
        List<SaleTransaction> mockTransactions2 = new ArrayList<>();
        mockTransactions1.add(new SaleTransaction("T1", new SaleOrder("S1", mockTransactions1),
                new Product("P1", "Carrot", "Can cause gout", "xxx1", 10.0), 10));
    }
}
