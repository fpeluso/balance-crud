package it.peluso.balance.util;

import it.peluso.balance.entity.Category;
import it.peluso.balance.entity.Transaction;
import it.peluso.balance.exception.InvalidBusinessTransactionException;
import it.peluso.balance.model.request.TransactionRequest;

public class TransactionUtil {

    public static boolean isTransactionValid(TransactionRequest transaction) {
        return  transaction != null &&
                transaction.getTransactionType() != null &&
                transaction.getTransactionDate() != null &&
                transaction.getAmount() != 0 &&
                transaction.getCategory() !=null;

    }

    public static Transaction transactionRequestToEntity(TransactionRequest transactionRequest)
            throws InvalidBusinessTransactionException {

        if(isTransactionValid(transactionRequest)) {
            return Transaction.builder()
                    .transactionType(transactionRequest.getTransactionType())
                    .amount(transactionRequest.getAmount())
                    .transactionDate(transactionRequest.getTransactionDate())
                    .category(
                            Category.builder().
                                    category(transactionRequest.getCategory())
                                    .build()
                    ).build();
        }
        throw new InvalidBusinessTransactionException("");
    }
}
