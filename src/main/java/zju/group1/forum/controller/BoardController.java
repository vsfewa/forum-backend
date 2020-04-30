package zju.group1.forum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zju.group1.forum.dto.Message;
import zju.group1.forum.interceptor.AuthToken;
import zju.group1.forum.mapper.UserMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Api(tags = "板块信息")
@RestController
@RequestMapping("/board")
public class BoardController {
    @Resource
    private UserMapper userMapper;

    @ApiOperation("学习板块")
    @PostMapping(value = "/study")
    @AuthToken
    public Message studyBoard(@RequestParam("token") String token,
                          HttpServletRequest request) throws IOException {
        Message message = new Message();
//        HttpSession session = request.getSession();
//        String token = UUID.randomUUID().toString();
//
//        session.setAttribute(email, token);
//        mailService.sendToken(email, token);
//        System.out.println(session.getAttribute(email));
//        message.setState(true);
//        message.setMessage("邮件发送成功!");
//        return message;
        return message;
    }

    @ApiOperation("情感板块")
    @PostMapping(value = "/emotion")
    @AuthToken
    public Message emotionBoard(@RequestParam("token") String token,
                              HttpServletRequest request) throws IOException {
        Message message = new Message();
        return message;
    }

    @ApiOperation("校园信息板块")
    @PostMapping(value = "/information")
    @AuthToken
    public Message informationBoard(@RequestParam("token") String token,
                                HttpServletRequest request) throws IOException {
        Message message = new Message();
        return message;
    }

    @ApiOperation("实习信息板块")
    @PostMapping(value = "/intern")
    @AuthToken
    public Message interBoard(@RequestParam("token") String token,
                                HttpServletRequest request) throws IOException {
        Message message = new Message();
        return message;
    }

}
