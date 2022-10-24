package com.bookshop.bookshop.Mappers;

import com.bookshop.bookshop.dto.PublishingDTO;
import com.bookshop.bookshop.models.Publishing;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface PublishingMapper {
    PublishingMapper MAPPER = Mappers.getMapper(PublishingMapper.class);

    List<PublishingDTO> fromPublishingList(List<Publishing> pubs);
}
