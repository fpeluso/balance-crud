package it.peluso.balance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Getter
@Builder
@Entity
@Table(name = "category")
public class Category {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;
}
