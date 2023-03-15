//package yc.lab;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//public class TestContoller {
//
//
//    @GetMapping(value = "/fcmtest.do")
//    public String fcmTest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
//        String tokenId="e-5ZPqkSSKKb0H8vsyXhQJ:APA91bGdE9yHaInvoTUxW-C4XG6N3tfHQ-6HMhTjO0IcRbRR36vgkGVunlfhCCOPmn6zf4lyx1vpZTnNMuj83eRmZebEiWyd0kjKVCZt0aIP2ls7YhlSR8eKziSOHPxbettR_mAoQerx";
//
////        String tokenId="fI2o_mwWRaqcln-G5sb9x4:APA91bEYqfMXo4VTjqucvO7N_vGqG2OeIizwhCmDpHQhKk7H97tNwW_t3JK46JKco8jUyF2OAw4aLtJPaYeFIQyRsN6JC5YIZapx4M-E_mSwbNzJRpM3z9h-qC59GzNgyI2VJkk5Vn6E";
//        String title="제목입니다";
//        String content="내용입니다";
//
//        FcmUtil FcmUtil = new FcmUtil();
//        FcmUtil.send_FCM(tokenId, title, content);
//
//        return "test";
//    }
//}
