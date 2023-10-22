package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //스프링 컨테이너에 MemberController의 객체를 생성해서 관리하고있음 / 기본적으로 싱글톤으로 생성됨.
public class MemberController {
    private final MemberService memberService;

    //memberService도 빈으로 등록해야함.
    //DI는 세가지 방법이 있음. (필드주입, setter주입-public으로 열려서 메소드 호출이 될 수 잇음. 안좋아서 잘 안씀. ,생성자 주입을 가장 많이 사용함. )

    //아래가 생성자 주입.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public  String createForm(){
        return "members/createMemberForm";
    }
    //실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 이용함.
    //그리고 정형화되지 않거나 상황에 따라 구현 클래스를 변경해야하면 설정을 통해 스프링 빈으로 이동한다.

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";

    }
}
