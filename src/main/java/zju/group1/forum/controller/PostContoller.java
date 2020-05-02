package zju.group1.forum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zju.group1.forum.dto.Message;
import zju.group1.forum.interceptor.AuthToken;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Api(tags = "发送、修改和删除帖")
@RestController
public class PostContoller {

    @ApiOperation("发送帖子")
    @PostMapping(value = "/post")
    @AuthToken
    public Message emotionBoard(@RequestParam("token") String token,
                                @RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("type") String type,
                                HttpServletRequest request) throws IOException {
        Message message = new Message();
        return message;
    }
    @ApiOperation("修改帖子")
    @PostMapping(value = "/modifyposting")
    @AuthToken
    public Message modifyPosting(@RequestParam("token") String token,
                                 @RequestParam("postingID") String postingID,
                                 @RequestParam("title") String title,
                                 @RequestParam("content") String content,
                                 HttpServletRequest request) throws IOException {
        Message message = new Message();
        return message;
    }
    @ApiOperation("删除帖子")
    @PostMapping(value = "/deleteposting")
    @AuthToken
    public Message deletePosting(@RequestParam("token") String token,
                                 @RequestParam("postingID") String postingID,
                                 HttpServletRequest request) throws IOException {
        Message message = new Message();
        return message;
    }
}
