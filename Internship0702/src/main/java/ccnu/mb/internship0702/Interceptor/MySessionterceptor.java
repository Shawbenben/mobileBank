package ccnu.mb.internship0702.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MySessionterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        Object currentUser = session.getAttribute("bb");
        if(currentUser==null){
            System.out.println("没有登录，请先登录");
            return false;
        }else{
            System.out.println("已登录，请进行下一步操作");
            return true;
        }
    }
}
