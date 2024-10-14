package org.jpa_study.entity;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(
        name = "BOARD_SEQ_GENERATOR",
        sequenceName = "BOARD_SEQ", // 매핑할 DB 시퀀스 이름
        initialValue = 1, allocationSize = 1)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "BOARD_SEQ_GENERATOR")
    private Long id;
}

// TABLE 전략
//@Entity
//@TableGenerator(
//        name = "MY_BOARD_SEQ_GENERATOR", // 사용할 table sequence 이름
//        table = "MY_BOARD_SEQ", // 실제 데이터베이스 table 이름
//        pkColumnValue = "BOARD_SEQ", allocationSize = 1
//)
//public class Board{
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.TABLE,
//            generator = "MY_BOARD_SEQ_GENERATOR" // 위의 sequence 이름
//    )
//    private Long id;
//}

// AUTO
//public class Board{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//}