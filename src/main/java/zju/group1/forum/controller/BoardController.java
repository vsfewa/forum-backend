package zju.group1.forum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zju.group1.forum.dto.BoardMessage;
import zju.group1.forum.dto.Message;
import zju.group1.forum.dto.Postings;
import zju.group1.forum.interceptor.AuthToken;
import zju.group1.forum.mapper.PostingsMapper;
import zju.group1.forum.mapper.UserMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api(tags = "板块信息")
@RestController
@RequestMapping("/board")
public class BoardController {
    @Resource
    private PostingsMapper postingsMapper;

    @ApiOperation("学习板块")
    @PostMapping(value = "/study")
    @AuthToken
    public BoardMessage studyBoard(@RequestParam("token") String token) throws IOException {
        BoardMessage message = new BoardMessage();
        if (token == null) {
            message.setState(false);
            message.setMessage("请重新登录");
            message.setAuthorizeToken(token);
            return message;
        }

        List<Postings> postingsList = postingsMapper.listStudy();
        message.setPostings(postingsList);
        message.setMessage("获取学习板块帖子成功");
        return message;
    }

    @ApiOperation("情感板块")
    @PostMapping(value = "/emotion")
    @AuthToken
    public BoardMessage emotionBoard(@RequestParam("token") String token) throws IOException {
        BoardMessage message = new BoardMessage();
        if (token == null) {
            message.setState(false);
            message.setMessage("请重新登录");
            message.setAuthorizeToken(token);
            return message;
        }

        List<Postings> postingsList = postingsMapper.listEmotion();
        message.setPostings(postingsList);
        message.setMessage("获取情感板块帖子成功");
        return message;
    }

    @ApiOperation("校园信息板块")
    @PostMapping(value = "/information")
    @AuthToken
    public BoardMessage informationBoard(@RequestParam("token") String token) throws IOException {
        BoardMessage message = new BoardMessage();
        if (token == null) {
            message.setState(false);
            message.setMessage("请重新登录");
            message.setAuthorizeToken(token);
            return message;
        }

        List<Postings> postingsList = postingsMapper.listInformation();
        message.setPostings(postingsList);
        message.setMessage("获取校园信息板块帖子成功");
        return message;
    }

    @ApiOperation("实习信息板块")
    @PostMapping(value = "/intern")
    @AuthToken
    public BoardMessage interBoard(@RequestParam("token") String token) throws IOException {
        BoardMessage message = new BoardMessage();
        if (token == null) {
            message.setState(false);
            message.setMessage("请重新登录");
            message.setAuthorizeToken(token);
            return message;
        }

        List<Postings> postingsList = postingsMapper.listIntern();
        message.setPostings(postingsList);
        message.setMessage("获取实习信息板块帖子成功");
        return message;
    }

}
