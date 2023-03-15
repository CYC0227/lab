package yc.lab;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yc.lab.concurrent.Order;
import yc.lab.concurrent.OrderRepository;
import yc.lab.concurrent.OrderService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void insert() {
        Order order = Order.builder()
                .content("수정 전")
                .status("주문 생성")
                .amount(100L)
                .build();

        orderRepository.saveAndFlush(order);
    }

    @AfterEach
    public void delete() {
        orderRepository.deleteAll();
    }

//    동시성 고려 안함
    @Test
    public void 동시에_100명이_주문취소() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    orderService.cancelOrder(1L);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        Order order = orderRepository.findById(1L).orElseThrow();

        Assertions.assertThat("주문 취소").isEqualTo(order.getStatus());
    }

    //sychronized 이용
    @Test
    public void 동시에_100명이_수량감소_synchronized() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    orderService.decreaseAmountSynchronized(1L, 1L);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        Order order = orderRepository.findById(1L).orElseThrow();

        Assertions.assertThat(order.getAmount()).isEqualTo(0);
    }

    //update 이용
    @Test
    public void 동시에_100명이_수량감소_update() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    orderService.decreaseAmountUpdate(1L);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        Order order = orderRepository.findById(1L).orElseThrow();

        Assertions.assertThat(order.getAmount()).isEqualTo(0);
    }
}