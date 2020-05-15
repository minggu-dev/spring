package kosta.mvc.mino.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
   private String code;
   private String name;
   private int price;
   private String detail;
}
