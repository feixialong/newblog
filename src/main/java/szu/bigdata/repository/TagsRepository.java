package szu.bigdata.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import szu.bigdata.domain.Blog;
import szu.bigdata.domain.TagList;

import java.util.List;

/**
 * Created by longhao on 2017/4/13.
 */
@Mapper
@Repository
public interface TagsRepository {

    @Select({
            "select tag,count(*) as num",
            "from tags",
            "group by tag"
    })
    List<TagList> groupByTag();

    @Select({
            "select vid,title,date",
            "from tags",
            "where tag=#{st}"
    })
    List<Blog> selectByTag(@Param("st") String tagName);
}
