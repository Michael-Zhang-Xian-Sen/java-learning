package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);

    /**
     * SpittleController构造器.
     * 在结束5.2节时，SpittleRepository还未能实现，故无法自动装载。
     * @param spittleRepository
     */
//    @Autowired
//    public SpittleController(SpittleRepository spittleRepository) {
//        this.spittleRepository = spittleRepository;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle>spittles(@RequestParam(value = "max",defaultValue = "MAX_LONG_AS_STRING") long max,
                                 @RequestParam(value = "count",defaultValue = "20") int count){
        // 在数据层进行了封装
        return spittleRepository.findSpittles(max,count);
    }

    @RequestMapping(value = "show",method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittle_id") long spittleId,
                              Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value = "/{spittleId}",method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId,Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}