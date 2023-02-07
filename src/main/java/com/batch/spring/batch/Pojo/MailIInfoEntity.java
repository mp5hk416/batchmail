package com.batch.spring.batch.Pojo;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 俊翔，學習加油，今天是 2022/11/10 上午 11:43
 * 時間: 11 43
 * 好好努力~桿八爹
 */
@Data
@DynamicUpdate
@Builder
@Entity(name = "mail_server")
@NoArgsConstructor
@AllArgsConstructor
public class MailIInfoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "`index`")
    private Integer index;
	
	@Column(name = "`nt_account`")
	private String ntAccount;
	
	@Column(name = "`exc_case_id`")
	private String excCaseId;
	
	@Column(name = "`status`")
	private Integer status;
	
	@Column(name = "`sendmailtime`")
	private Instant sendMailTime;
	
	@Column(name = "`email_address`")
	private String emailAddress;

}
