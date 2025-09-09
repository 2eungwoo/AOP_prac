package study.aop_prac;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    private final InternalService internalService;

    @LogExecutionTime
    public void callExternal() {
        System.out.println("callExternal() 메소드 실행");
        try {
            Thread.sleep(1000);
            internalService.callInternal(); // 외부 Service의 메소드 호출
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
