package yc.lab.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private String content;
    private Long amount;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Long getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void decrease(final Long amount) {
        if (this.amount - amount < 0) {
            throw new RuntimeException("재고 부족");
        }
        this.amount -= amount;
    }
}
