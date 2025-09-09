package study.aop_prac;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @LogExecutionTime
    public void doSomething() {
        try {
            // 1초간 대기하여 실행 시간을 인위적으로 만듦
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
