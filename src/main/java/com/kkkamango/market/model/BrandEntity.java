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
 * 브랜드 정보 entity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "brand")
public class BrandEntity {

    /**
     * 브랜드ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 브랜드명
     */
    private String name;

    /**
     * 대표자명
     */
    private String representative_name;

    /**
     * 사업자등록번호
     */
    private String business_no;

    /**
     * 전화번호
     */
    private String phone;

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
