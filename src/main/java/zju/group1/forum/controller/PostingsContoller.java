package zju.group1.forum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zju.group1.forum.dto.Message;
import zju.group1.forum.interceptor.AuthToken;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Api(tags = "查看帖子")
@RestController
public class PostingsContoller {
    @ApiOperation("查看编号“postingID”的帖子")
    @PostMapping(value = "/postings/{postingID}")
    @AuthToken
    public Message checkPostings(@RequestParam("token") String token,
                                HttpServletRequest request) throws IOException {
        Message message = new Message();
        return message;
    }
}
