package szu.bigdata.service.ServiceInterface;

import szu.bigdata.domain.Blog;
import szu.bigdata.domain.Categories;
import szu.bigdata.domain.TagList;

import java.util.List;

/**
 * Created by longhao on 2017/4/7.
 */
public interface BlogService {

    //后台添加博客
    void addBlog(Blog blog);

    //前端标签页面获取标签列表
    List<TagList> getTagList();

    //前端页面获取分类信息
    List<Categories> getCategoriesList();

    //前端时间线页获取档案
    List<Blog> getFirstPage();

    //前端博客显示界面获取博客html文本，对应post/id
    Blog getBlog(int vid);

    //archive 归档页面
    List<Blog> getBlogByPage(int page);

    //前端显示文章总数
    int getNumOfBlog();

    //前端显示标签总数
    int getNumOfTag();

    //前端显示获取article页面总数
    int getArchiveNum();
    //前端获取上一篇博客的id和title
    Blog getPrevBlog(int vid);

    //前端获取下一篇博客的id和title
    Blog getNextBlog(int vid);

    //前端依据tag名称获取博客列表
    List<Blog> getBlogByTag(String tagName);

    //前端依据categories名称获取博客列表
    List<Blog> getBlogByCategories(String tagName);



}
