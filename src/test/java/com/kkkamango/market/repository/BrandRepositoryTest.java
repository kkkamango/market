package com.kkkamango.market.repository;

import com.kkkamango.market.model.BrandEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
@Slf4j
class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    /**
     * i. 브랜드 A~Z 까지 분산하여 생성할 것
     * 필요시 @Test 주석 해제
     */
//    @Test
    public void 브랜드_등록_테스트() {

        // 랜덤하게 섞기
        Collections.shuffle(Arrays.asList(RandomUtil.ALPHABETS));
        // 20개의 브랜드명 및 대표자명 생성
        for (int i = 0; i < 20; i++) {
            // 예시로 brand 테이블에 삽입
            insertBrandData(RandomUtil.ALPHABETS[i]);
        }
    }


    /**
     * 브랜드 데이터 등록
     *
     * @param randomLetter
     */
    private void insertBrandData(String randomLetter) {
        BrandEntity brandEntity = BrandEntity.builder()
                .name("브랜드" + randomLetter)
                .representative_name("대표자" + randomLetter)
                .business_no("123-45-" + (RandomUtil.generateRandomInterger(5)))
                .phone("010-" + (RandomUtil.generateRandomInterger(4) + "-" + RandomUtil.generateRandomInterger(4)))
                .createdDate(RandomUtil.generateRandomDateTime())
                .build();

        log.debug("브랜드 데이터 등록 {}", brandEntity);
        brandRepository.save(brandEntity);
    }
}