package szu.bigdata.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import szu.bigdata.domain.Blog;
import szu.bigdata.domain.Categories;

import java.util.List;

/**
 * Created by longhao on 2017/4/7.
 */

@Repository
@Mapper
public interface BlogRepository {

    @Select({
        "select title,tags,Categories,article,date",
        "from blog",
        "where vid=#{st}"
    })
    Blog selectBlog(@Param("st") int vid);

    @Select({
            "select vid,title,tags,Categories,article,date,abstracts",
            "from blog",
            "order by date limit 7"
    })
    List<Blog> selectFirstPage();

    @Select({
            "select vid,title,Categories,date",
            "from blog",
            "limit #{st},10"
    })
    List<Blog> selectByPage(@Param("st") int start);

    @Select({
            "select categories,count(*) as num",
            "from blog",
            "group by categories"
    })
    List<Categories> groupByCategories();

    @Select({
            "select vid,title,date",
            "from blog",
            "where categories=#{st}"
    })
    List<Blog> selectByCategories(@Param("st") String categoriesName);
}
