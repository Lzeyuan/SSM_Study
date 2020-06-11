import com.shaoda.user.model.User;
import com.shaoda.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void MyBatis() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (Object user : context.getBean("userServiceImpl", UserService.class).selectAll()) {
            System.out.println((User)user);
        }
    }
}
