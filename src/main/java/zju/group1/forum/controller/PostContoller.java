package zju.group1.forum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zju.group1.forum.dto.Message;
import zju.group1.forum.dto.Posting;
import zju.group1.forum.interceptor.AuthToken;
import zju.group1.forum.mapper.PostingsMapper;
import zju.group1.forum.mapper.UserMapper;
import zju.group1.forum.provider.RedisProvider;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Date;

@Api(tags = "发送、修改和删除帖")
@RestController
public class PostContoller {
    @Resource
    private PostingsMapper postingsMapper;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisProvider redisProvider;

    @ApiOperation("发送帖子")
    @PostMapping(value = "/post")
    @AuthToken
    public Message emotionBoard(@RequestParam("token") String token,
                                @RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("type") int type) throws IOException {
        Message message = new Message();
        if (token == null) {
            message.setState(false);
            message.setMessage("请重新登录");
            message.setAuthorizeToken(token);
            return message;
        }
        if (title == null) {
            message.setState(false);
            message.setMessage("标题不能为空");
            message.setAuthorizeToken(token);
            return message;
        }
        if (content == null) {
            message.setState(false);
            message.setMessage("内容不能为空");
            message.setAuthorizeToken(token);
            return message;
        }

        Posting newPostings = new Posting();
        String email = redisProvider.getAuthorizedName(token);
        String name = userMapper.searchName(email);
        newPostings.setAuthor(name);
        newPostings.setTitle(title);
        newPostings.setContent(content);
        newPostings.setType(type);
        Date date = new Date(System.currentTimeMillis());
        newPostings.setTime(date);
        postingsMapper.Post(newPostings);
        message.setState(true);
        message.setMessage("发送帖子成功");
        return message;
    }
    @ApiOperation("修改帖子")
    @PostMapping(value = "/modifyposting")
    @AuthToken
    public Message modifyPosting(@RequestParam("token") String token,
                                 @RequestParam("postingID") String postingID,
                                 @RequestParam("title") String title,
                                 @RequestParam("content") String content) throws IOException {
        Message message = new Message();
        if (token == null) {
            message.setState(false);
            message.setMessage("请重新登录");
            message.setAuthorizeToken(token);
            return message;
        }
        if (title == null) {
            message.setState(false);
            message.setMessage("标题不能为空");
            message.setAuthorizeToken(token);
            return message;
        }
        if (content == null) {
            message.setState(false);
            message.setMessage("内容不能为空");
            message.setAuthorizeToken(token);
            return message;
        }

        Posting newPostings = new Posting();
        newPostings.setTitle(title);
        newPostings.setContent(content);
        postingsMapper.modifyPosting(newPostings);
        message.setState(true);
        message.setMessage("修改帖子成功");
        return message;
    }
    @ApiOperation("删除帖子")
    @PostMapping(value = "/deleteposting")
    @AuthToken
    public Message deletePosting(@RequestParam("token") String token,
                                 @RequestParam("postingID") String postingID) throws IOException {
        Message message = new Message();
        if (token == null) {
            message.setState(false);
            message.setMessage("请重新登录");
            message.setAuthorizeToken(token);
            return message;
        }

        postingsMapper.deletePosting(postingID);
        message.setState(true);
        message.setMessage("删除帖子成功");
        return message;
    }
}
