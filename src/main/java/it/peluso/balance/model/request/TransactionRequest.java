package it.peluso.balance.model.request;

import it.peluso.balance.model.CategoryModel;
import it.peluso.balance.util.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionRequest {

    private TransactionType transactionType;

    private int amount;

    private LocalDate transactionDate;

    private String description;

    private String category;
}
