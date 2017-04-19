package szu.bigdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import szu.bigdata.domain.Blog;
import szu.bigdata.repository.BlogRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewblogApplicationTests {
	@Autowired
	private BlogRepository blogRepository;

	@Test
	public void contextLoads() {
		System.out.println("running ok");
	}
	@Test
	public void databaseChineseTest(){
		List<Blog> blogList=blogRepository.selectByCategories("感慨");
		System.out.println(blogList);
		for(Blog blog:blogList){
			System.out.println("title:"+ blog.getTitle());
		}
	}

	@Test
    public void loginTest(){

    }

}
