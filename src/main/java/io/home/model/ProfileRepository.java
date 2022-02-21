package io.home.model;

import java.util.Optional;

public interface ProfileRepository {

    Profile save(Profile e);

    Optional<Profile> findById(Long id);

    void remove(Node node);
}