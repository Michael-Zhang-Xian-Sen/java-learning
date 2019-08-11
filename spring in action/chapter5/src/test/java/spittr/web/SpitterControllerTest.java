//package spittr.web;
//
//import org.junit.Test;
//import org.springframework.test.web.servlet.MockMvc;
//import spittr.Spitter;
//import spittr.data.SpitterRepository;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//public class SpitterControllerTest {
//    /**
//     * 测试展现表单的控制器方法.
//     * @throws Exception
//     */
//    @Test
//    public void shouldShowRegiostration() throws Exception{
//        SpitterController controller = new SpitterController();
//        MockMvc mockMvc = standaloneSetup(controller).build();
//
//        mockMvc.perform(get("/spitter/register"))
//                .andExpect(view().name("registerForm"));
//    }
//
//    /**
//     * 测试处理表单的控制器方法.
//     * @throws Exception
//     */
//    @Test
//    public void shouldProcessRegistration() throws Exception {
//        // 构建repository
//        SpitterRepository mockRepository = mock(SpitterRepository.class);
//        Spitter unsaved = new Spitter("jbauer","24hours","Jack","Bauer");
//        when(mockRepository.save(unsaved)).thenReturn(saved);
//
//        // 构建Mockmvc
//        SpitterController controller = new SpitterController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//
//        // 执行请求
//        mockMvc.perform(post("/spitter/register")
//                .param("firstName","Jack")
//                .param("lastName","Bauer")
//                .param("username","jbauer")
//                .param("passwrod","24hours"))
//                .andExpect(redirectedUrl("/spitter/jbauer"));
//
//        // 检验保存情况
//        verify(mockRepository,atLeastOnce()).save(unsaved);
//    }
//
//
//}
