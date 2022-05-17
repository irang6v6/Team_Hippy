package net.skhu.config;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public MyModelMapper createModelMapper() {
        return new MyModelMapper();
    }

    public static class MyModelMapper extends ModelMapper {
        public <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass) {
            return sourceList
                    .stream()
                    .map(element -> this.map(element, targetClass))
                    .collect(Collectors.toList());
        }
    }

}
