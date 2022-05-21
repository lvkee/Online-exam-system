package top.liuweiqi;

import com.sy.dao.QuestionMapper;
import com.sy.dao.StudentMapper;
import com.sy.dao.TeacherMapper;
import com.sy.entity.Organization;
import com.sy.entity.Question;
import com.sy.entity.Teacher;
import com.sy.service.BaseService;
import com.sy.service.QuestionService;
import com.sy.service.impl.QuestionServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AppTest {

//    private final QuestionService questionService;

    private SqlSession session;

    /*private AppTest(QuestionService questionService) {
        this.questionService = questionService;
    }*/

    @Before
    public void start() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session = factory.openSession();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 测试 teacherMapper.getTeachers
     */
    @Test
    public void test01() {
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        List<Teacher> list = teacherMapper.getTeachers(1);
        for (Teacher teacher : list) {
            for (int j = 0; j < teacher.getOrganizationList().size(); j++) {
                Organization organization = teacher.getOrganizationList().get(j);
                System.out.println(teacher.gettNickname() + " " + organization.getoName());
            }
        }
    }

    /**
     * 测试添加教师
     */
    @Test
    public void test02() {
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        System.out.println(new Date());
        teacherMapper.addTeachers("1986985788ab", "张老师", "123456a", "1986985788@qq.com", new Date(), new Date());
    }

    /**
     * 测试添加学生
     */
    @Test
    public void test03() {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Date date = new Date();
        studentMapper.addStudent("1986985788aaa", "张三", "123456a", "1986985788@qq.com", date, date, date);
    }

    @Test
    public void test04() {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.queryStudent(34));
    }

    /**
     * 测试添加题目
     */
    @Test
    public void test05() {
        QuestionMapper questionMapper = session.getMapper(QuestionMapper.class);
        QuestionService questionService = new QuestionServiceImpl(questionMapper);
        Question question = new Question();
        question.setId(1);
        questionService.insert(question);
    }

    /**
     * 测试删除题目 （软删除）
     */
    @Test
    public void test06() {
        QuestionMapper questionMapper = session.getMapper(QuestionMapper.class);
        QuestionService questionService = new QuestionServiceImpl(questionMapper);
        Question question = new Question();
        question.setId(1);
        questionService.insert(question);
    }
    
    

    /*@Test
    public void test02() throws IOException {
        OrgnizationMapper orgnizationMapper = session.getMapper(OrgnizationMapper.class);
        List<Orgnization> list = orgnizationMapper.getOrgnizations(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getoName());
        }
    }*/

    @After
    public void end() {
        if (session != null) {
            session.commit();
            session.close();
        }
    }

}
