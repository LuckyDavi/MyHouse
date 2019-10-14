package com.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author XieWei
 * @Description 邮件服务启动器
 * @Created Date 2019/9/23 12:17
 **/
@SpringBootApplication
//此注解可以支持Dubbo、SpringCloud等其他注册中心
//@EnableDiscoveryClient
//@EnableEurekaClient
@Slf4j
public class UserApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserApplicationStarter.class);

        log.info("                                                                                                \n\n\n\n \n" +
                "               NNN        NN            II              CCC C CC                   EEEEEEEEEEEEE           \n"+
                "             NN NN       NN            II             CCC       CC                EE                       \n"+
                "            NN  NN      NN            II             CC                          EE                        \n"+
                "           NN   NN     NN            II             CC                          EE                         \n"+
                "          NN    NN    NN            II             CC                          EEEEEEEEEEEEEE              \n"+
                "         NN     NN   NN            II             CC                          EE                           \n"+
                "        NN      NN  NN            II              CC          CC             EE                            \n"+
                "       NN       NN NN            II               CC       CCC              EE                             \n"+
                "      NN        NNN             II                  CC CC CC               EEEEEEEEEEEEEEE                 \n");
    }
}
