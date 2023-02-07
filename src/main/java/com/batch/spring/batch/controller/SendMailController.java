//package com.batch.spring.batch.controller;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.batch.spring.batch.Pojo.MailTemplateDTO;
//import com.batch.spring.batch.service.SingleMailSending;
//import com.batch.spring.batch.service.impl.SpringMailService;
//import com.batch.spring.batch.utils.JsonResult;
//import com.batch.spring.batch.utils.ReplyMessage;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 俊翔，學習加油，今天是 2022/11/10 下午 05:23
// * 時間: 17 23
// * 好好努力~桿八爹
// */
//@RestController
//@RequestMapping("/springMail")
//@CrossOrigin(origins = "http://localhost:9955")
//@Api("寄件模塊")
//@Slf4j
//public class SendMailController {
//
//    @Autowired
//    SpringMailService springMailService;
//
//    @Autowired
//    SingleMailSending singleMailSending;
//
//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    @Qualifier("generateJob")
//    Job job;
//
//
//    @GetMapping("/sendTest")
//    @ApiOperation("單封手動寄件")
//    public JsonResult<ReplyMessage> sendTest(MailTemplateDTO mailTemplateDTO){
//
//        singleMailSending.SingleMailSend(mailTemplateDTO);
//
//        return JsonResult.ok(new ReplyMessage("寄送成功"));
//    }
//}
