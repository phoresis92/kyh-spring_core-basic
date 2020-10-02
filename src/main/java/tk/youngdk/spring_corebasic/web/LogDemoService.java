package tk.youngdk.spring_corebasic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import tk.youngdk.spring_corebasic.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id) {

        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("LogDemoService.logic id = " + id);

    }
}
