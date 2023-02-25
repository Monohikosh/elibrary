package ru.sbercourses.library.mapper;

import ru.sbercourses.library.dto.GenericDto;
import ru.sbercourses.library.model.GenericModel;

public interface Mapper<E extends GenericModel, D extends GenericDto> {

    E toEntity(D dto);

    D toDto(E entity);

}
