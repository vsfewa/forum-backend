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

import javax.annotation.Resource;
import java.io.IOException;

@Api(tags = "查看帖子")
@RestController
public class PostingContoller {
    @Resource
    private PostingsMapper postingsMapper;

    @ApiOperation("查看编号“postingID”的帖子")
    @PostMapping(value = "/postings/{postingID}")
    @AuthToken
    public PostingMessage checkPostings(@PathVariable("postingID") String postingID) throws IOException {
        PostingMessage message = new PostingMessage();

        Posting posting = postingsMapper.getPostingByID(postingID);
        message.setState(true);
        message.setMessage("查看该贴成功！");
        message.setPostingInfo(posting);
        postingsMapper.updateVisitNumber(postingID);
        /*============================*/
        /*!!!!!第四周迭代需完成回复!!!!!*/
        message.setReplyList(null);
        /*!!!!!第四周迭代需完成回复!!!!!*/
        /*============================*/
        return message;
    }
}
