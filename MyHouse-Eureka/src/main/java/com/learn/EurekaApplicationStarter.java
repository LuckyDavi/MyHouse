package com.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author XieWei
 * @Description Eureka启动类
 * @Created Date 2019/9/24 17:07
 **/
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationStarter.class, args);
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
