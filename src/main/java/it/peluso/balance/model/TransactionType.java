package it.peluso.balance.model;

public enum TransactionType {

    IN("in"),
    OUT("out");

    private final String type;

    private TransactionType(String type){
        this.type = type;
    }
}
