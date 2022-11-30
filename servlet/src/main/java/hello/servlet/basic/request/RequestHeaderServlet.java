package hello.servlet.basic.request;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.lang.model.SourceVersion;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;

@WebServlet(name="requestHeaderServlet",urlPatterns="/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printInfo(req);
        printHeaders(req);
    }

    private void printInfo(HttpServletRequest request) {
        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol = " + request.getProtocol());
        System.out.println("request.getHeader() = " + request.getQueryString());
    }

    private void printHeaders(HttpServletRequest request){
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));
    }



}
