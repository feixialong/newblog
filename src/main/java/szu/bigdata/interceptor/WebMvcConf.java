package szu.bigdata.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

/**
 * Created by longhao on 2017/4/14.
 */

@Configuration
public class WebMvcConf extends WebMvcConfigurerAdapter{


    private UserSecurityInterceptor userSecurityInterceptor;

    @Autowired
    public WebMvcConf(UserSecurityInterceptor userSecurityInterceptor) {
        super();
        this.userSecurityInterceptor = userSecurityInterceptor;
    }

    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(userSecurityInterceptor).addPathPatterns("/admin/**");//配置登录拦截路径
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration=new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowedMethods(Arrays.asList("GET","PUT","POST","DELETE"));
        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
    }
}
