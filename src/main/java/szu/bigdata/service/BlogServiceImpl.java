package szu.bigdata.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szu.bigdata.domain.Blog;
import szu.bigdata.domain.Categories;
import szu.bigdata.domain.TagList;
import szu.bigdata.repository.BlogRepository;
import szu.bigdata.repository.TagsRepository;
import szu.bigdata.service.ServiceInterface.BlogService;

import java.util.List;

/**
 * Created by longhao on 2017/4/7.
 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private TagsRepository tagsRepository;

    @Override
    public void addBlog(Blog blog) {

    }

    @Override
    public List<TagList> getTagList() {
        return tagsRepository.groupByTag();
    }

    @Override
    public List<Categories> getCategoriesList() {
        return blogRepository.groupByCategories();
    }

    @Override
    public List<Blog> getFirstPage() {
        return blogRepository.selectFirstPage();
    }

    @Override
    public Blog getBlog(int vid) {
        return blogRepository.selectBlog(vid);
    }

    @Override
    public List<Blog> getBlogByPage(int page) {
        int start=(page-1)*10;
        return blogRepository.selectByPage(start);
    }

    @Override
    public int getNumOfBlog() {
        return 0;
    }

    @Override
    public int getNumOfTag() {
        return 0;
    }

    @Override
    public int getArchiveNum() {
        return 0;
    }

    @Override
    public Blog getPrevBlog(int vid) {
        return null;
    }

    @Override
    public Blog getNextBlog(int vid) {
        return null;
    }

    @Override
    public List<Blog> getBlogByTag(String tagName) {
        return tagsRepository.selectByTag(tagName);
    }

    @Override
    public List<Blog> getBlogByCategories(String categoriesName) {

        return blogRepository.selectByCategories(categoriesName);
    }
}
