package hobby.ccgame;

import com.fasterxml.jackson.databind.ObjectMapper;
import hobby.ccgame.mapper.DTOMapper;
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


    @Bean
    public ObjectMapper objectMapper() {

        return new ObjectMapper();
    }


    @Bean
    public DTOMapper dtoMapper() {

        DTOMapper dtoMapper = new DTOMapper();


        return dtoMapper;
    }



}
