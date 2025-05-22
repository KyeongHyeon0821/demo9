package com.example.demo9.dto;

import com.example.demo9.constant.ItemSellStatus;
import com.example.demo9.entity.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {

  private Long id;

  @NotEmpty(message = "상품명은 필수입니다.")
  @Column(length = 30)
  @Size(min = 2, max = 30, message = "상품명은 2자 이상 30자 이하로 입력해주세요.")
  private String itemName;

  @NotEmpty(message = "가격은 필수입니다.")
  private int price;

  @NotEmpty(message = "재고수량은 필수입니다.")
  private int stockNumber;

  @Lob
  @NotEmpty(message = "상품상세는 필수입니다.")
  private String itemDetail;

  @Enumerated(EnumType.STRING)
  private ItemSellStatus itemSellStatus;

  // Entity to Dto
  public static ItemDto createItemDto(Optional<Item> optionalItem) {
    return ItemDto.builder()
            .id(optionalItem.get().getId())
            .itemName(optionalItem.get().getItemName())
            .price(optionalItem.get().getPrice())
            .stockNumber(optionalItem.get().getStockNumber())
            .itemDetail(optionalItem.get().getItemDetail())
            .itemSellStatus(optionalItem.get().getItemSellStatus())
            .build();
  }
}
