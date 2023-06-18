package tobyspring.helloboot;

import java.io.IOException;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

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
			servletContext.addServlet("hello", new HttpServlet()
			{
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
				{
					resp.setStatus(200);
					resp.setHeader("Content-Type", "text/plain");
					resp.getWriter().println("Hello Servlet !");
				}
			}).addMapping("/hello");
		});
		webServer.start();
	}

}
