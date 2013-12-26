package net.okjsp.member;/**
 * Created by langerhans on 2013. 12. 26..

 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: langerhans
 * Date: 2013. 12. 26..
 * Time: 오후 2:07
 * Description : MemberController
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    /**
     * 회원 로그인 Form
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/html")
    public String loginForm() {

        return "member/login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET, produces = "text/html")
    public String signup() {

        return "member/signup";
    }
}
