package ccnu.mb.internship0702.config;

import ccnu.mb.internship0702.Interceptor.MySessionterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MySessionterceptor())
                //-拦截所有的请求
                .addPathPatterns("/**")
                //-不拦截哪些请求
                .excludePathPatterns("/user/login","/user/register");
    }
}
