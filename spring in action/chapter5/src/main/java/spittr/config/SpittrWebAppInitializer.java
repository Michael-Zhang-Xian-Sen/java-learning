package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

/**
 * 这是web.xml的一个替代方案.
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 将一个或多个路径映射到DispatcherServlet上.
     * @return
     */
    @Override
    protected String[] getServletMappings(){
        return new String[]{
                "/"
        };
    }

    /**
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[]{
                RootConfig.class
        };
    }

    /**
     * 要求DispatcherServlet加载应用上下文时 使用定义在WebConfig配置类中的Bean
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[]{
                WebConfig.class
        };
    }
}
