package com.mz.kafka.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Integer orderID;

    @Column(nullable = false, columnDefinition = "varchar", length = 36, updatable = false)
    private String number;

    @Column(nullable = false, length = 20)
    private String location;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private String creditCardNumber;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
