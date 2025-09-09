package study.aop_prac;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyService {

    private final InternalService internalService;

    @LogExecutionTime
    public void callExternal() {
        log.info("callExternal() 메소드 실행");
        try {
            Thread.sleep(1000);
            internalService.callInternal(); // 외부 Service의 메소드 호출
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
