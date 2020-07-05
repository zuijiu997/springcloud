package zuijiu997.springcloud.business.hello.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/hello")
@RefreshScope
//@FeignClient("HelloServer")
public class HelloController {

    @Value("${user}")
    String user;

    @Value("${spring.zipkin.base-url}")
    String zipkin;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    public String index(){
        return "hello " + user;
    }

    @GetMapping("/ziplin")
    public String getZipkin() {
        return zipkin;
    }

    @GetMapping("/services")
    public JSONObject services() {
        JSONObject jsonObject = new JSONObject();
        for (String service : this.discoveryClient.getServices()) {
            jsonObject.put(service, discoveryClient.getInstances(service));
        }

        return jsonObject;
    }

}
