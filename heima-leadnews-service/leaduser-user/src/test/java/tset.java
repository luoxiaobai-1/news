import com.me.article.service.ApUserService;
import com.me.article.userApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = userApplication.class)
public class tset {
    @Autowired
    ApUserService apUserService;
    @Test
    public  void test()
    {
        apUserService.list().forEach(System.out::println);
    }

}
