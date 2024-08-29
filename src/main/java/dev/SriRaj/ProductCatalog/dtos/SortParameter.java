package dev.SriRaj.ProductCatalog.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParameter {
    private String parameterName;

    //"ASC" if ascending DSC if descending
    private String sortType;
}
