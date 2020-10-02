package tk.youngdk.spring_corebasic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tk.youngdk.spring_corebasic.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String id) {

        myLogger.log("LogDemoService.logic id = " + id);

    }
}
