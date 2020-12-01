package com.cloud.controlelr;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/10 14:31
 */
@RestController
public class TestControlelr {
    @GetMapping("/testa")
    public String testA(){
        return "testA";
    }

    @GetMapping("/testb")
    public String testB() throws InterruptedException {
        Thread.sleep(3000);
        return "testb";
    }

    @GetMapping("/testd")
    public String testD() {
        int i = 1/0;
        return "testd";
    }

    @GetMapping("/testhotkey")
    @SentinelResource(value = "testhotkey", blockHandler = "deal_testHotkey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2){
        return "testHotKey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException blockException){
        return "testhotkey出问题了，执行兜底的deal_testHotkey";//sentinel系统默认的提示：blocked by sentinel（flow limiting）
    }
}
