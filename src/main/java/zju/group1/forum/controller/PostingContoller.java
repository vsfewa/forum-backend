package zju.group1.forum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zju.group1.forum.dto.Posting;
import zju.group1.forum.dto.PostingMessage;
import zju.group1.forum.interceptor.AuthToken;
import zju.group1.forum.mapper.PostingsMapper;
import zju.group1.forum.provider.RedisProvider;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Api(tags = "查看帖子")
@RestController
public class PostingContoller {
    @Resource
    private PostingsMapper postingsMapper;
    @Autowired
    private RedisProvider redisProvider;

    @ApiOperation("查看编号“postingID”的帖子")
    @PostMapping(value = "/postings/{postingID}")
    @AuthToken
    public PostingMessage checkPostings(@PathVariable("postingID") String posingID,
                                 @RequestParam("token") String token) throws IOException {
        PostingMessage message = new PostingMessage();
        if (token == null) {
            message.setState(false);
            message.setMessage("请重新登录");
            message.setAuthorizeToken(token);
            return message;
        }
        Posting posting = postingsMapper.getPostingByID(posingID);
        message.setState(true);
        message.setMessage("查看该贴成功！");
        message.setPostingInfo(posting);
        /*============================*/
        /*!!!!!第四周迭代需完成回复!!!!!*/
        message.setReplyList(null);
        /*!!!!!第四周迭代需完成回复!!!!!*/
        /*============================*/
        return message;
    }
}
