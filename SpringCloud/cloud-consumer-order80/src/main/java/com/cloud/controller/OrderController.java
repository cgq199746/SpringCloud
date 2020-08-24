package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.service.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //单机版
    //public static final String PAYMENT_URL = "http://localhost:8001";

    //集群版
    public static final String PAYMENT_URL = "http://CGQ-CLOUD-PAYMENT-SERVCIE";

    @Resource
    private RestTemplate restTemplate;


    @Resource
    private LoadBalancer loadBalancer ;


    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/create",payment,CommonResult.class);
    }


    @GetMapping("/consumer/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/getPaymentById/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/getPaymentEntityById/{id}")
    public CommonResult<Payment> getPaymentEntityById(@PathVariable("id") Integer id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/getPaymentById/" + id, CommonResult.class);
        System.out.println(forEntity);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult<>(404,"failed");
        }

    }

    @GetMapping("/consumer/getLb")
    public String getLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances(PAYMENT_URL);
        if(instances == null || instances.size() <0 ){
            return null;
        }

        ServiceInstance serviceInstance =  loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/getServerPort",String.class);

    }

}
