package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 控制器类.
 * 注解@Controller 声明该类为一个控制器。使用@Component注解的效果一致。
 * 目的：辅助实现组件扫描。
 * 在类级别上添加@RequestMapping注解，该注解会应用至控制器的所有处理器方法。
 * 处理器方法上的RequestMapping会对类级别的RequestMapping进行补充。
 * 使用数组的方式，可以映射到多个路径的请求。
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * 处理对"/"的控制请求.
     * 注解@RequestMapping中的method属性，处理的HTTP方法。
     * @return 名为home的视图
     */
    @RequestMapping(method = GET)
    public String home(){
        System.out.println("return home?");
        return "home";
    }
}
