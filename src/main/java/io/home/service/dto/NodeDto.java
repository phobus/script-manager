package io.home.service.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Set;

public class NodeDto implements Serializable {
    private Long id;
    private String name;
    private NodeDto parent;
    private LinkedList<NodeDto> children = new LinkedList<>();
    private Long profileId;

    public NodeDto() {
    }

    public NodeDto(Long id) {
        this.id = id;
    }

    public NodeDto(Long id, String name, Long profileId) {
        this.id = id;
        this.name = name;
        this.profileId = profileId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeDto getParent() {
        return parent;
    }

    public void setParent(NodeDto parent) {
        this.parent = parent;
    }

    public LinkedList<NodeDto> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<NodeDto> children) {
        this.children = children;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
