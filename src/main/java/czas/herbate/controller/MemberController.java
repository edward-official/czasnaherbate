package czas.herbate.controller;

import czas.herbate.domain.Member;
import czas.herbate.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.signUp(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
