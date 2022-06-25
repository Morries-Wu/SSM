package Items.item01.controller;

import Items.item01.Bean.Student;
import Items.item01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     * 声明引用类型,调用引用类型的业务方法
     * 引用类型自动注入@Autowired,@Resource
     * 添加学生
     */

    @Autowired
    private StudentService service;


    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView mv = new ModelAndView();

        //调用service,处理业务逻辑,把处理结果返回给用户
        int rows = service.addStudent(student);
        String msg = "注册失败!";
        if (rows > 0) {
            //注册成功,给用户成功的数据和视图
            msg = "注册成功";
        }
        mv.addObject("msg", student.getName() + "," + msg);
        mv.setViewName("result");
        return mv;
    }


    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudents() {
        List<Student> stulist = service.queryStudents();
        return stulist;
    }

}
