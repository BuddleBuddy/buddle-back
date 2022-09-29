//package buddle.buddlebuddy.config.auth;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpSession;
//
//@RequiredArgsConstructor
//@Controller
//public class IndexController {
//
//    private final HttpSession httpSession;
//
//    @GetMapping("/")
//    public String index(Model model)
//    {
//        // userName을 사용할 수 있게 model에 저장
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
//        return "index";
//    }
//}