package com.cloud.controlelr;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.handle.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/12/1 14:41
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
   // @SentinelResource(value = "byResource",blockHandler = "handleException")
    @SentinelResource(value = "byResource",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException")
    public CommonResult byRescource(){
        return new CommonResult(200,"按资源名称限流测试ok", new Payment(2020,"serial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

}
