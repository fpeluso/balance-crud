package it.peluso.balance.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//TODO: this is just a draft to allow postman to add new categories
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    private String category;
}
