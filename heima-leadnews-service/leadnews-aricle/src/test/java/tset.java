import com.me.article.ArticleApplication;

import com.me.article.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ArticleApplication.class)
public class tset {
    @Autowired
    ArticleService apUserService;
    @Test
    public  void test()
    {
        apUserService.list().forEach(System.out::println);
    }

}
