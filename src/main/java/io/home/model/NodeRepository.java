package io.home.model;

import java.util.List;
import java.util.Optional;

public interface NodeRepository {

    Node save(Node e);

    List<Node> findAll();

    Optional<Node> findById(Long aLong);

    List<Node> findByIdIn(List<Long> collect);
}