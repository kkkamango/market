package com.kkkamango.market.repository;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Random;

public class RandomUtil {
    public static String[] ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    private static final Random random = new Random();

    /**
     * 랜덤한 datetime을 생성 (1 ~ 12월 사이)
     *
     * @return LocalDateTime
     */
    public static LocalDateTime generateRandomDateTime() {
        // 랜덤 범위 설정
        final int year = 2024;
        int month = random.nextInt(12) + 1;  // 1 ~ 12 월
        YearMonth yearMonth = YearMonth.of(year, month);
        int day = random.nextInt(yearMonth.lengthOfMonth()) + 1;  // 1 ~ 마지막 일
        int hour = random.nextInt(24);       // 0 ~ 23 시간
        int minute = random.nextInt(60);     // 0 ~ 59 분
        int second = random.nextInt(60);     // 0 ~ 59 초

        // LocalDateTime으로 변환
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }

    /**
     * @param digit 1~10
     * @return
     */
    public static Integer generateRandomInterger(Integer digit) {
        // 10^digit이 최소값이고, 10^(digit+1) - 1이 최대값
        int min = (int) Math.pow(10, digit - 1);  // 최소값 (예: 2자리일 경우 10)
        int max = (int) Math.pow(10, digit) - 1;  // 최대값 (예: 2자리일 경우 99)

        // 범위 내에서 랜덤 값 생성
        return random.nextInt(max - min + 1) + min;
    }
}
