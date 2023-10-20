package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링 컨테이너에 MemberController의 객체를 생성해서 관리하고있음 / 기본적으로 싱글톤으로 생성됨.
public class MemberController {
    private final MemberService memberService;

    //memberService도 빈으로 등록해야함.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
