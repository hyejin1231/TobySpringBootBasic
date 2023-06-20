package tobyspring.helloboot;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 컨트롤러의 중요한 역할 중 하나는 넘어온 파라미터 값을 검증하는 것 !
 */
@Controller
public class HelloController {
    
    // final을 같이 선언하는 이유 : 한번 할당하면 재할당을 할 수 없음
    private final HelloService helloService;
    
    public HelloController(HelloService helloService)
    {
        this.helloService = helloService;
    }
    
    @GetMapping("/hello")
    @ResponseBody
    public String hello(String name) {
        
        return helloService.sayHello(Objects.requireNonNull(name));
    }

}
