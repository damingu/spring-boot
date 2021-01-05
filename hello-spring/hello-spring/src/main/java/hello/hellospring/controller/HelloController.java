package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("test")
    public String hello(Model model){
        model.addAttribute("data", "HelloController부터 넘겨받은 value입니다.") ;
        return "hello" ;
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name) ;
        return "hello-template" ;
    }

    @GetMapping("hello-string")
    //야기서 중요한 한줄
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name ; //"hello spring" 내가 요청한 문자가 그대로 내려감
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello ;
    }

    static class Hello {
        private String name ;

        public String getName() {
            return name ;
        }

        public void setName(String name) {
            this.name = name ;
        }

    }

}
