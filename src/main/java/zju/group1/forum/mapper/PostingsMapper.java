package zju.group1.forum.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zju.group1.forum.dto.Posting;

import java.util.List;

@Mapper
public interface PostingsMapper {
    @Select("select * from postings where type = 1")
    List<Posting> listStudy();
    @Select("select * from postings where type = 2")
    List<Posting> listEmotion();
    @Select("select * from postings where type = 3")
    List<Posting> listInformation();
    @Select("select * from postings where type = 4")
    List<Posting> listIntern();
    @Select("select * from postings where author = #{email}")
    List<Posting> listPersonalPostings(String email);
    @Select("select * from postings where id = #{postingID}")
    Posting getPostingByID(String postingID);
}
