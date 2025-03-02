package com.example.Springboot_JPA;

import com.example.Springboot_JPA.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class invoker {

    @Autowired
    StudentService studentService;

    @Bean
    public CommandLineRunner cmdLR(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                askDetails.line();
                int op = -1;
                while(op!=0){
                    op = askDetails.crud();

                    switch (op){
                        case 1:
                            studentService.insertData(askDetails.All());
                            break;
                        case 2:
                            studentService.updateData(askDetails.All());
                            break;
                        case 3:
                            studentService.deleteData();
                            break;
                        case 4:
                            studentService.getData();
                            break;
                        default:
                            System.out.println("Invalid Choice!!");
                            break;
                    }
                    askDetails.line();
                }
            }
        };
    }
}
