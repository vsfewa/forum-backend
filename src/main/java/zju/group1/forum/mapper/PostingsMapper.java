package zju.group1.forum.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zju.group1.forum.dto.Postings;

import java.util.List;

@Mapper
public interface PostingsMapper {
    @Select("select * from postings where type = 1")
    List<Postings> listStudy();
    @Select("select * from postings where type = 2")
    List<Postings> listEmotion();
    @Select("select * from postings where type = 3")
    List<Postings> listInformation();
    @Select("select * from postings where type = 4")
    List<Postings> listIntern();
    @Select("select * from postings where author = #{email}")
    List<Postings> listPersonalPostings(String email);
}
