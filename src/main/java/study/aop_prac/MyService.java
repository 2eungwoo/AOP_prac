package study.aop_prac;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @LogExecutionTime
    public void doSomething() {
        System.out.println("doSomething() 메소드 실행");
        try {
            Thread.sleep(1000);
            this.doSomethingElse(); // 내부 호출
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void doSomethingElse() {
        System.out.println("doSomethingElse() 메소드 실행");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
