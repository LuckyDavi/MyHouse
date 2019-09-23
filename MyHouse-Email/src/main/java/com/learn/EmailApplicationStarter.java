package com.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author XieWei
 * @Description 邮件服务启动器
 * @Created Date 2019/9/23 12:17
 **/
@SpringBootApplication
@Slf4j
public class EmailApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(EmailApplicationStarter.class);

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
