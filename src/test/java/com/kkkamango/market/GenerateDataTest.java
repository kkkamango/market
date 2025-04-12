package com.kkkamango.market;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkkamango.market.model.user.UserPageHistoryEntity;
import com.kkkamango.market.model.user.UserPageHistoryId;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 데이터 생성 스크립트
 */
//@SpringBootTest
@Slf4j
class GenerateDataTest {

//    @Autowired
//    private UserPageHistoryRepository userPageHistoryRepository;

    private static List<UserPageHistoryEntity> logs = new ArrayList<>();

    /**
     * 테스트 케이스 실행전,
     * sample_user_log.json 파일의 데이터를 추출합니다.
     *
     * @return
     */
    @BeforeAll
    static public void extractData() {
        ObjectMapper objectMapper = new ObjectMapper();

        ClassPathResource resource = new ClassPathResource("sample_user_log.json");
        try (InputStream inputStream = resource.getInputStream()) {

            MappingIterator<UserPageHistoryId> iterator = objectMapper
                    .readerFor(UserPageHistoryId.class).readValues(inputStream);

            // Iterator를 사용하여 요소를 순차적으로 리스트에 추가
            while (iterator.hasNext()) {
                UserPageHistoryId userPageHistoryId = iterator.next();
                log.debug("userPageHistoryId={}", userPageHistoryId);
                logs.add(UserPageHistoryEntity.builder()
                        .userPageHistoryId(userPageHistoryId)
                        .build());
            }
        } catch (IOException e) {
            log.error("IOException {}", e.getStackTrace());
        }
    }

    @AfterAll
    static public void print() {
        log.debug("@AfterAll");
        log.debug("logs={}", logs);
    }

    /**
     * a. 회원 정보를 생성하는 스크립트
     * i. 활동 로그에서 추출한 회원 ID 수 만큼 회원 정보 생성
     * ii. ID 외 정보는 임의 입력
     */
    @Test
    public void 회원_정보_생성() {
        log.debug("회원 정보 생성 start");

    }

    /**
     * b. 상품 정보 100개 랜덤 생성
     * i. 브랜드 A~Z 까지 분산하여 생성할 것
     * ii. 상품 정보가 0건은 브랜드는 없어야 함
     * iii. 브랜드별로 배송비는 모두 달라야 함
     */
    @Test
    public void 상품_정보_생성() {
    }

    /**
     * c. 주문 정보 1000개 랜덤 생성
     * i. 단, 주문일자를 2024-01-01 ~ 현재까지로 분산하여 생성할 것
     * ii. 주문이 0건인 일자는 없어야 함
     * d. 회원 활동 로그 파일을 1-d 에서 만든 로그 테이블에 저장
     */
    @Test
    public void 주문_정보_생성() {
    }
}