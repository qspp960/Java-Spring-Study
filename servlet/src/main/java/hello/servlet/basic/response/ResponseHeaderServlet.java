package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Status-line
        resp.setStatus(HttpServletResponse.SC_OK);
        //response-headers
        resp.setHeader("Content-Type","text/plain;charset=utf-8");
        resp.setHeader("Cache-Control","no-cache, no-store, no-revalidate");
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("my-header","hello");

        //Header 편의 메서드
        content(resp);

        // message body
        PrintWriter writer = resp.getWriter();
        writer.println("ok");

    }

    private void content(HttpServletResponse response){
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response){
        Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException{
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location","/basic/hello-form.html");
//        편리하게 사용 가능
        response.sendRedirect("basic/hello-form.html");
    }
}
