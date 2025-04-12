package com.kkkamango.market.repository;

import com.kkkamango.market.model.BrandEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
@Slf4j
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    /**
     * 상품 정보 100개 랜덤 생성
     * i. 브랜드 A~Z 까지 분산하여 생성할 것
     * ii. 상품 정보가 0건은 브랜드는 없어야 함
     * iii. 브랜드별로 배송비는 모두 달라야 함
     * 필요시 @Test 주석 해제
     */
//    @Test
    public void 상품_등록_테스트() {
        List<BrandEntity> brandList = brandRepository.findAll();

        brandList.stream()
                .map(brand -> CompletableFuture.runAsync(() -> createRandomProductsForBrand(brand)));
    }


    /**
     * 브랜드에 대한 상품 생성 메서드
     */
    private void createRandomProductsForBrand(BrandEntity brand) {
//
//        for (int i = 0; i < 100; i++) {
//            ProductEntity productEntity = ProductEntity.builder().brandId(brand.getId())
//                    .productName("상품" + (i + 1))
//                    .price(random.nextInt(100000) + 1000) // 1000 ~ 100000 사이의 가격
////            productEntity.setOriginalPrice(productEntity.getPrice());
//                    .discountRate(BigDecimal.valueOf(random.nextDouble() * 0.5)) // 0 ~ 50% 할인율
//                    .inboundCost(random.nextInt(50000) + 500) // 500 ~ 50000 사이의 입고가격
//                    .thumbnail("thumbnail_" + generateRandomString(5) + ".jpg")
//                    .description("상품 설명 " + generateRandomString(15))
//                    .stockQuantity(random.nextInt(100) + 1) // 재고 수량 1 ~ 100
//                    .delYn("N")
//                    .createdDate(LocalDateTime.now())
//                    .build();
//
//            log.debug("상품 데이터 등록 {}", productEntity);
////            productRepository.save(productEntity);
//        }
    }
}