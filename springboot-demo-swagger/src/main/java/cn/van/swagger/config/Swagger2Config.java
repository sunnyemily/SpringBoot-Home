/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Swagger2Config
 * Author:   zhangfan
 * Date:     2019-04-08 16:20
 * Description: Swagger配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.van.swagger.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Swagger配置类〉
 *
 * @author zhangfan
 * @create 2019-04-08
 * @since 1.0.0
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        //header中增加 token_id参数，没有可以去掉
//        ParameterBuilder token = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        token.name("token_id").description("user token")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        pars.add(token.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                .apis(RequestHandlerSelectors.basePackage("cn.van.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("这里是Swagger文档标题")
                // 文档描述
                .description("这里是文档描述")
                .termsOfServiceUrl("https://www.dustyblog.cn")
                .version("v1.0")//定义版本号
                .build();
    }
    //
    /**
     * 取消 security 对接口的拦截，只在 swaggerui 进行拦截
     *
     * @param web
     * @throws Exception
     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//        //这里填写需要过滤的路径
//        web.ignoring().antMatchers("/api/v1/admin/**");
//    }

}