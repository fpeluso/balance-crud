package it.peluso.balance.entity;

import it.peluso.balance.util.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private TransactionType transactionType;

    private int amount;

    private LocalDate transactionDate;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id" )
    private Category category;

}
