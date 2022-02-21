package io.home.service;

import io.home.model.Node;
import io.home.model.NodeRepository;
import io.home.model.Profile;
import io.home.model.ProfileRepository;
import io.home.service.dto.NodeDto;
import io.home.ui.model.ProfileTreeNode;

import java.util.Optional;

public class NodeService {

    private NodeRepository nodeRepository;
    private ProfileRepository profileRepository;
    private Assembler assembler = new Assembler();

    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void setNodeRepository(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public ProfileTreeNode findAll() {
        return assembler.toResource(nodeRepository.findAll());
    }

    public NodeDto insert(NodeDto dto) {
        if (dto.getId() != null) {
            throw new RuntimeException("ID must be null on insert");
        }

        Node parent = Optional.ofNullable(dto.getParent())
                .map(NodeDto::getId)
                .flatMap(nodeRepository::findById)
                .orElse(null);

        Profile profile = Optional.ofNullable(dto.getProfileId())
                .flatMap(profileRepository::findById)
                .orElse(null);

        Node node = new Node();
        node.setName(dto.getName());
        node.setParent(parent);
        node.setProfile(profile);
        nodeRepository.save(node);
        dto.setId(node.getId());
        return dto;
    }

    public NodeDto update(NodeDto dto) {
        if (dto.getId() == null) {
            throw new RuntimeException("ID must be not null on update");
        }
        Node node = nodeRepository.findById(dto.getId()).orElseThrow(RuntimeException::new);
        node.setName(dto.getName());
        nodeRepository.save(node);
        return dto;
    }

    public boolean remove(NodeDto nodeDto) {
        Node node = nodeRepository.findById(nodeDto.getId()).orElseThrow(RuntimeException::new);
        profileRepository.remove(node);
        return true;
    }
}
