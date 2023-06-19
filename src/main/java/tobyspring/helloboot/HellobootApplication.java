package tobyspring.helloboot;

import java.io.IOException;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HellobootApplication {

	public static void main(String[] args) {
		/**
		 * 서블릿 컨테이너 띄우기
		 * TomcatServletWebServerFactory : 스프링 부트가 제공하는 내장형 톰캣의 초기화 작업과 설정 지원 클래스
		 */
		TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("frontController", new HttpServlet()
			{
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
				{
					/**
					 *	프론트 컨트롤러로 전환
					 * 인증, 보안, 다국어.. 등등 공통 기능
 					 */
					if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
						// 서블릿 요청 처리
						String name = req.getParameter("name");
						
						resp.setStatus(HttpStatus.OK.value());
						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println("Hello Servlet ! " + name);
					}
					else if (req.getRequestURI().equals("/user")) {
					
					}else
					{
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*");
		});
		webServer.start();
	}

}
