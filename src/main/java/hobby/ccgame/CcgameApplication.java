package hobby.ccgame;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CcgameApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcgameApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapper() {

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setSkipNullEnabled(true);

    return  modelMapper;
    }



}
