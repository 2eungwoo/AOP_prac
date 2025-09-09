package study.aop_prac;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyService {

    @LogExecutionTime
    public void callExternal() {
        // 이 메소드는 외부(CommandLineRunner) 로부터 호출됨
        // 외부에서 호출되므로 프록시를 거치게 되고, 따라서 AOP가 정상적으로 동작할 것임
        System.out.println("callExternal() 메소드 실행");
        try {
            Thread.sleep(1000);
            this.callInternal(); // 내부 호출
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void callInternal() {
        // 이 메소드는 callExternal() 내부에서 this를 통해 호출됨
        // 내부 호출이므로 프록시를 우회하게 되어 AOP가 동작하지 않을 것
        System.out.println("callInternal() 메소드 실행");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
