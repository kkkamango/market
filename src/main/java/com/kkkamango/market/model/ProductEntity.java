package com.kkkamango.market.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 상품 정보 entity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {
    /**
     * 브랜드ID
     */
    @Id

    private Integer brandId;

    /**
     * 브랜드ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 상품명
     */
    private String productName;

    /**
     * 원산지
     */
    private String origin;

    /**
     * 주요소재
     */
    private String material;

    /**
     * 판매가
     */
    private Integer price;

    /**
     * 최초등록가격
     */
    private Integer originalPrice;

    /**
     * 할인율
     */
    private Double discountRate;

    /**
     * 입고가격
     */
    private Integer inbundCost;


    /**
     * 노출이미지
     */
    private String thumbnail;

    /**
     * 상품 설명
     */
    private String description;


    /**
     * 재고 수량
     */
    private Integer stockQuantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(nullable = false, length = 1, columnDefinition = "char default 'N'", insertable = false)
    private String delYn;

}
