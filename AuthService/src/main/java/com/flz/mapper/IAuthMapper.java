package com.flz.mapper;

import com.flz.dto.request.DoRegisterRequestDto;
import com.flz.dto.request.UserProfileSaveRequestDto;
import com.flz.model.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);
    Auth toAuth(final DoRegisterRequestDto dto);
   // @Mapping(target = "authId", source = "id")
    //UserProfileSaveRequestDto fromAuth (final Auth auth);
}