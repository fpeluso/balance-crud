package it.peluso.balance.model.response;

import it.peluso.balance.model.TransactionModel;
import it.peluso.balance.model.request.TransactionRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransactionResponse {

    //TODO: what kind of information do we want to send the client?

    private String successMessage;
    private String errorMessage;
    private TransactionRequest request;

    public TransactionResponse(TransactionRequest request, String successMessage){
        this.request = request;
        this.successMessage = successMessage;
    }
}
