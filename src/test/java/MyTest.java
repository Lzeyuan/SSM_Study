import com.shaoda.user.model.Student;
import com.shaoda.user.model.User;
import com.shaoda.user.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void MyBatis() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = new User("123123", "1111", "wqefsa", 23, new Date());
        Student student = new Student("2", "llren");
        context.getBean("studentService", StudentServiceImpl.class).update(student,user);
    }
}
