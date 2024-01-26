package org.sid.demographql.mappers;

import org.modelmapper.ModelMapper;
import org.sid.demographql.dto.CreatorRequest;
import org.sid.demographql.dto.VideoRequest;
import org.sid.demographql.entities.Creator;
import org.sid.demographql.entities.Video;
import org.springframework.stereotype.Service;

@Service
public class VideoMapper {
    private final ModelMapper modelMapper=new ModelMapper();


    public CreatorRequest fromCreator(Creator creator) {
        return modelMapper.map(creator, CreatorRequest.class);
    }
    public VideoRequest fromVideo(Video video){
        return modelMapper.map(video,VideoRequest.class);
    }
    public  Creator fromCreatorRequest(CreatorRequest creatorRequest){
        return modelMapper.map(creatorRequest,Creator.class);
    }
    public Video fromVideoRequest(VideoRequest videoRequest){
        return modelMapper.map(videoRequest,Video.class);
    }
}
