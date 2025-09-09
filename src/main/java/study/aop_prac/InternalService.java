package study.aop_prac;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InternalService {

    @LogExecutionTime
    public void callInternal() {
        log.info("callInternal() 메소드 실행");
        try {
            Thread.sleep(500);
            log.info("callInternal() 메소드 try 내부");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
