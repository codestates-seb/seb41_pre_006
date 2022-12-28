package pre006.stackoverflow.domain.tag.mapper;
import pre006.stackoverflow.domain.tag.entity.Tag;
import org.mapstruct.Mapper;
import pre006.stackoverflow.domain.tag.dto.TagDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    default Tag tagDtoToTag(TagDto.TagPostDto tagDto) {
        Tag tag = new Tag();
        tag.setTagName(tagDto.getTagName());
        return tag;
    }

    TagDto tagToTagResponseDto(Tag tag);
}
