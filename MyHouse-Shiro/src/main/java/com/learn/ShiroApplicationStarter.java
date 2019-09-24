package com.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author XieWei
 * @Description TODO
 * @Created Date 2019/9/24 15:49
 **/
@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.learn.mapper"})
public class ShiroApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplicationStarter.class);

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
