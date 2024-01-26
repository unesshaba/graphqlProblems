package org.sid.demographql.web;

import org.modelmapper.ModelMapper;
import org.sid.demographql.dto.CreatorRequest;
import org.sid.demographql.dto.VideoRequest;
import org.sid.demographql.entities.Creator;
import org.sid.demographql.entities.Video;
import org.sid.demographql.mappers.VideoMapper;
import org.sid.demographql.repository.CreatorRepository;
import org.sid.demographql.repository.VideoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;
    private VideoMapper videoMapper;

    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository, VideoMapper videoMapper) {
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
        this.videoMapper = videoMapper;
    }

    @QueryMapping
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Creator %s not found", id)));
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest creator) {
        Creator creator1 = videoMapper.fromCreatorRequest(creator);
        return creatorRepository.save(creator1);
    }
    @MutationMapping
    public Video saveVideo(@Argument VideoRequest video){
        Video video1 = videoMapper.fromVideoRequest(video);
        Creator creator=creatorRepository.save(video1.getCreator());
        video1.setCreator(creator);
        return  videoRepository.save(video1);
    }


}