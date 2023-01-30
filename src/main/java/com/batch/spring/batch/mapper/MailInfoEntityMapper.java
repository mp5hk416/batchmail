package com.batch.spring.batch.mapper;

import com.batch.spring.batch.Pojo.MailIInfoEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;


/**
 * 俊翔，學習加油，今天是 2022/11/10 下午 02:22
 * 時間: 14 22
 * 好好努力~桿八爹
 */
public class MailInfoEntityMapper implements RowMapper<MailIInfoEntity> {

    @Override
    public MailIInfoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        return MailIInfoEntity.builder()
                .id(rs.getLong("id"))
                .senderAddress(rs.getString("sender_address"))
                .recipientAddress(rs.getString("recipient_address"))
                .subject(rs.getString("subject"))
                .content(rs.getString("content"))
                .state(rs.getShort("state"))
                .emailSent(rs.getInt("email_sent"))
                //Date轉LocalDateTime
                .sendingDate(rs.getTimestamp("sending_date"))
                .build();
    }
}
