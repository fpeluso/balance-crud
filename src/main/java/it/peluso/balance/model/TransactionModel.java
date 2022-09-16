package it.peluso.balance.model;

import it.peluso.balance.util.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionModel {

    protected TransactionType transactionType;

    protected int amount;

    protected LocalDate transactionDate;

    protected String description;

    protected String category;
}
