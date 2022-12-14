package it.peluso.balance.controller;

import it.peluso.balance.exception.InvalidBusinessTransactionException;
import it.peluso.balance.model.request.TransactionRequest;
import it.peluso.balance.model.response.TransactionResponse;
import it.peluso.balance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(("/api/v1/transactions"))
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<TransactionResponse> getTransactionsByDate(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ){
        TransactionResponse response = service.findAllTransactionsBetweenDates(startDate, endDate);
        return new ResponseEntity<>(
             response,
             HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
            @RequestBody TransactionRequest request
    ) {
        try {
            return
                    new ResponseEntity<>(service.saveTransaction(request), HttpStatus.OK);
        } catch (InvalidBusinessTransactionException e) {
//            TransactionResponse responseError = TransactionResponse.builder()
//                    .error(TransactionErrorResponse.builder()
//                            .type("Unable to parse request") //need constants for this
//                            .build()
//                    ).build();
            return null;
//            return new ResponseEntity<Transaction>(
//                    null,
//                    HttpStatus.BAD_REQUEST
//            );
        }
    }
}
