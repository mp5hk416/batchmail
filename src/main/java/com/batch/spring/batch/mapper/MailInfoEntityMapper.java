package com.batch.spring.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

import org.springframework.jdbc.core.RowMapper;

import com.batch.spring.batch.Pojo.MailIInfoEntity;


/**
 * 俊翔，學習加油，今天是 2022/11/10 下午 02:22
 * 時間: 14 22
 * 好好努力~桿八爹
 */
public class MailInfoEntityMapper implements RowMapper<MailIInfoEntity> {

    @Override
    public MailIInfoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        return MailIInfoEntity.builder()
        		.index(rs.getInt("index"))
                .emailAddress(rs.getString("email_address")) 
                .ntAccount(rs.getString("nt_account"))
                .excCaseId(rs.getString("exc_case_id"))
                .status(rs.getInt("status"))
                .sendMailTime(Instant.now())
                .build();
    }
}
