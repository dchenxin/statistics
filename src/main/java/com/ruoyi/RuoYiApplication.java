package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * User: Luz
 * Date: 2020/9/12
 * Description：
 */
@EnableCaching
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class})
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {com.ruoyi.common.config.FlywayConfig.class})})
public class RuoYiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuoYiApplication.class, args);
		System.out.println("(♥◠‿◠)ﾉﾞ  若依启动成功   ლ(´ڡ`ლ)ﾞ  ");
		System.out.println("  __                                    __                 __   \n" +
				"_/  |_  ____ _____    _____     _______/  |______ ________/  |_ \n" +
				"\\   __\\/ __ \\\\__  \\  /     \\   /  ___/\\   __\\__  \\\\_  __ \\   __\\\n" +
				" |  | \\  ___/ / __ \\|  Y Y  \\  \\___ \\  |  |  / __ \\|  | \\/|  |  \n" +
				" |__|  \\___  >____  /__|_|  / /____  > |__| (____  /__|   |__|  \n" +
				"           \\/     \\/      \\/       \\/            \\/             ");
	}
}
