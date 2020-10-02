package tk.youngdk.spring_corebasic.beanFind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.youngdk.spring_corebasic.AppConfig;
import tk.youngdk.spring_corebasic.member.service.MemberService;
import tk.youngdk.spring_corebasic.member.service.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName (){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("객체 타입으로 조")
    void findBeanByType (){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2 (){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX (){
//        MemberService xxx = ac.getBean("xxx", MemberService.class);

        assertThrows(NoSuchBeanDefinitionException.class,
                () -> {
                    ac.getBean("xxx", MemberService.class);
                });
    }


}
