package it.peluso.balance.service;

import it.peluso.balance.exception.InvalidBusinessTransactionException;
import it.peluso.balance.model.request.TransactionRequest;
import it.peluso.balance.entity.Transaction;
import it.peluso.balance.model.response.TransactionResponse;
import it.peluso.balance.repository.TransactionRepository;
import it.peluso.balance.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    @Autowired
    public TransactionService(TransactionRepository repository){
        this.repository = repository;
    }

    public ResponseEntity<List<Transaction>> findAllTransactions(){
        LocalDate startDate = LocalDate.EPOCH;
        LocalDate endDate = LocalDate.now();
        return findAllTransactionsBetweenDates(startDate, endDate);
    }

    public ResponseEntity<List<Transaction>> findAllTransactionsBetweenDates(LocalDate startDate, LocalDate endDate){
        List<Transaction> transactions =
                new ArrayList<>(repository.findTransactionsByTransactionDateBetween(startDate, endDate));
        if(transactions.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    public ResponseEntity<TransactionResponse> saveTransaction(TransactionRequest transactionRequest)
            throws InvalidBusinessTransactionException {
        try {
            Transaction transaction = TransactionUtil.transactionRequestToEntity(transactionRequest);
            repository.save(transaction);
            return new ResponseEntity<>(
                    new TransactionResponse(transactionRequest, "object created"),
                    HttpStatus.CREATED
            );
        } catch (InvalidBusinessTransactionException e) {
            throw new InvalidBusinessTransactionException(e.getMessage());
        }
    }
}
