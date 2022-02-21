package io.home.service;

import io.home.model.Profile;
import io.home.model.ProfileRepository;
import io.home.service.dto.ProfileDto;

import java.io.File;
import java.util.Optional;

public class ProfileService {

    private ProfileRepository profileRepository;

    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileDto save(ProfileDto dto) {
        Profile entity = toModel(dto);
        profileRepository.save(entity);
        return toResource(entity, dto);
    }

    private Profile toModel(ProfileDto dto) {
        return new Profile(dto.getId(),
                dto.getFile().getAbsolutePath(),
                Optional.ofNullable(dto.getWorkingPath()).map(File::getAbsolutePath).orElse(null),
                dto.getArguments(),
                dto.getEnvironment());
    }

    private ProfileDto toResource(Profile entity, ProfileDto dto) {
        dto.setId(entity.getId());
        dto.setFile(new File(entity.getFile()));
        dto.setWorkingPath(Optional.ofNullable(entity.getWorkingPath()).map(File::new).orElse(null));
        dto.setArguments(entity.getArguments());
        dto.setEnvironment(entity.getEnvironment());
        return dto;
    }
}
