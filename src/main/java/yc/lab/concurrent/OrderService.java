package yc.lab.concurrent;

//동시성 테스트용

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //동시성 문제 해결 안함
//    @Transactional 트랜잭션 없음.
    public void cancelOrder(Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("엔티티 없음"));

        order.setStatus("주문 취소");

        orderRepository.saveAndFlush(order);
    }

    //synchronized 이용
    //    @Transactional 트랜잭션 없음.
    public synchronized void decreaseAmountSynchronized(Long orderId, Long amount){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("엔티티 없음"));

        order.decrease(amount);

        orderRepository.saveAndFlush(order);
    }

    //UPDATE 이용
    @Transactional
    public void decreaseAmountUpdate(Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("엔티티 없음"));

        orderRepository.decreaseAmount(order.getId());
    }
}
