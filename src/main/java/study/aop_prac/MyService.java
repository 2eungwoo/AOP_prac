package study.aop_prac;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @LogExecutionTime
    public void callExternal() {
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
        System.out.println("callInternal() 메소드 실행");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
