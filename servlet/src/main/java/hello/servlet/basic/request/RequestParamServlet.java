package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1.파라미터 전송가능
 * http://localhost:8080/request-param
 */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("전체 파라미터 조회-Start-");

        req.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));

        System.out.println("전체 파라미터 조회-end");

        System.out.println("단일 파라미터 조회-start-");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("단일 파라미터 조회-end-");

        System.out.println("이름이 같은 파라미터 조회-start");
        String[] usernames = req.getParameterValues("username");

        for (String name : usernames){
            System.out.println("username = " + username);
        }
        System.out.println("이름이 같은 파라미터 조회-end-");

        resp.getWriter().write("ok");
    }
}
