package czas.herbate.controller;

import czas.herbate.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Controller: A Spring Bean annotation for the presentation layer.
 * It handles HTTP requests (MVC) and maps them to specific methods.
 * Spring registers this class as a Bean so it can handle web traffic.
 */
@Controller
public class MemberController {

    private final MemberService memberService;

    /**
     * @Autowired: Explicitly tells Spring to inject the MemberService dependency.
     * For constructor injection (like here), if there's only one constructor, 
     * @Autowired can often be omitted, but it's good practice for clarity.
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
