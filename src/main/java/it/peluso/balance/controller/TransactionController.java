package it.peluso.balance.controller;

import it.peluso.balance.entity.Transaction;
import it.peluso.balance.exception.InvalidBusinessTransactionException;
import it.peluso.balance.model.request.TransactionRequest;
import it.peluso.balance.model.response.CustomError;
import it.peluso.balance.model.response.TransactionResponse;
import it.peluso.balance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/transactions"))
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactionsByDate(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ){
        return service.findAllTransactionsBetweenDates(startDate, endDate);
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
            @RequestBody TransactionRequest request
            ) {
        try {
            return service.saveTransaction(request);
        } catch (InvalidBusinessTransactionException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); //TODO: I'm not convinced about that
        }
    }
}
