package dev.SriRaj.ProductCatalog.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDto {
    private String query;
    private int pageNumber;
    private int sizeOfEachPage;
    //private List<String> sortByParameters;
    private List<SortParameter> sortByParameters;


}
