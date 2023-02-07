package com.batch.spring.batch.Repository;


import com.batch.spring.batch.Pojo.MailIInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//寄件持久層
@Repository
public interface MailRepository extends JpaRepository<MailIInfoEntity, Long> {

    List<MailIInfoEntity> findMailInfoDTOByStatus(Integer status);

    Long countByStatus(Integer status);



}
