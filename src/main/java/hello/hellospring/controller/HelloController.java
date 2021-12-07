package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    //URL hello로 들어오면 타는 컨트롤러
    @GetMapping("hello")
    public String hello(Model model) {
        //model은 스프링이 넣어준다.
        model.addAttribute("data", "hello!data from model!");
        //리턴값을 다음과 같이 문자로 반환하면, viewResolver가 화면을 찾아서 처리한다.
        //스프링부트 템플릿엔진 기본 viewName매핑
        //resources:templates/ + {viewName} + .html 
        return "hello";
    }

    //hello-mvc URL로 요청이 온 경우
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        //쿼리스트링으로 받은 name값을 모델에 담아 넘긴다.
        model.addAttribute("name", name);
        //viewResolver가 hello-template.html을 찾는다.
        return "hello-template";
    }
}
