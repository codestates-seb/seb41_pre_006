package pre006.stackoverflow.domain.tag.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pre006.stackoverflow.domain.tag.dto.TagDto;
import pre006.stackoverflow.domain.tag.entity.Tag;
import pre006.stackoverflow.domain.tag.mapper.TagMapper;
import pre006.stackoverflow.domain.tag.service.TagService;

@RestController
@Validated
@RequestMapping("/tags")
@Slf4j
public class TagController {

    private TagService tagService;

    private TagMapper tagMapper;

    public TagController(TagService tagService, TagMapper tagMapper) {
        this.tagService = tagService;
        this.tagMapper = tagMapper;
    }

    @PostMapping()
    public ResponseEntity postTag(@Validated @RequestBody TagDto.TagPostDto tagPostDto) {
        Tag tag = tagService.createTag(tagMapper.tagDtoToTag(tagPostDto));
        return new ResponseEntity<>(tagMapper.tagToTagResponseDto(tag), HttpStatus.CREATED);
    }

}

