package org.sid.demographql;

import org.sid.demographql.entities.Creator;
import org.sid.demographql.entities.Video;
import org.sid.demographql.repository.CreatorRepository;
import org.sid.demographql.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphQlApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            List<Creator> creators = List.of(Creator.builder().name("youness").email("youness@gmail.com").build(),
                    Creator.builder().name("mohammed").email("mohammed@gmail.com").build(),
                    Creator.builder().name("test").email("test@gmail.com").build());
            for (Creator creator : creators) {
                creatorRepository.save(creator);
            }
            List<Video> videos = List.of(Video.builder().name(" youtube").url("/youtube").datePublication(new Date()).description("amazing vedio").creator(creators.get(1)).build(),
                    Video.builder().name(" animal ").url("/animal").datePublication(new Date()).description("animal vedio").creator(creators.get(2)).build(),
                    Video.builder().name(" car").url("/car").datePublication(new Date()).description("cars vedio").creator(creators.get(0)).build());
            for (Video video : videos) {
                videoRepository.save(video);
            }
        };
}
}
