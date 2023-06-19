package tobyspring.helloboot;

import java.util.Objects;

/**
 * 컨트롤러의 중요한 역할 중 하나는 넘어온 파라미터 값을 검증하는 것 !
 */
public class HelloController {

    public String hello(String name) {
        SimpleHelloService helloService = new SimpleHelloService();
        
        return helloService.sayHello(Objects.requireNonNull(name));
    }

}
