package it.peluso.balance.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionResponse {

    //TODO: what kind of information do we want to send the client?

    private String successMessage;
}
