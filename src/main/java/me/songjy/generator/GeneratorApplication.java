//package me.songjy.generator;
//
//import me.songjy.generator.core.Generator;
//import me.songjy.generator.core.GeneratorParam;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class GeneratorApplication implements ApplicationRunner {
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(GeneratorApplication.class, args);
//
//    }
//
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        Generator.genCode(
//                GeneratorParam.builder()
//                        .author("songjiyuan")
//                        .tableName("member_behavior")
//                        .basePackage("nxcloud.middle.member")
//                        .logicDelColumn("is_delete")
//                        .outputBasePath("../../")
//                        .build()
//        );
//
//
//    }
//}
