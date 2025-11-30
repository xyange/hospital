package com.wyzy.hospital.common.core.node;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/10  11:51
 * @Function:
 */
public class BaseNode implements INode {
    private static final long serialVersionUID = 1L;
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    protected Long id;
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    protected Long parentId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<INode> children = new ArrayList();
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Boolean hasChildren;

    public Boolean getHasChildren() {
        return this.children.size() > 0 ? true : this.hasChildren;
    }

    public BaseNode() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public List<INode> getChildren() {
        return this.children;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setParentId(final Long parentId) {
        this.parentId = parentId;
    }

    public void setChildren(final List<INode> children) {
        this.children = children;
    }

    public void setHasChildren(final Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseNode)) {
            return false;
        } else {
            BaseNode other = (BaseNode)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label59;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label59;
                    }

                    return false;
                }

                Object this$parentId = this.getParentId();
                Object other$parentId = other.getParentId();
                if (this$parentId == null) {
                    if (other$parentId != null) {
                        return false;
                    }
                } else if (!this$parentId.equals(other$parentId)) {
                    return false;
                }

                Object this$hasChildren = this.getHasChildren();
                Object other$hasChildren = other.getHasChildren();
                if (this$hasChildren == null) {
                    if (other$hasChildren != null) {
                        return false;
                    }
                } else if (!this$hasChildren.equals(other$hasChildren)) {
                    return false;
                }

                Object this$children = this.getChildren();
                Object other$children = other.getChildren();
                if (this$children == null) {
                    if (other$children != null) {
                        return false;
                    }
                } else if (!this$children.equals(other$children)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BaseNode;
    }

    public String toString() {
        return "BaseNode(id=" + this.getId() + ", parentId=" + this.getParentId() + ", children=" + this.getChildren() + ", hasChildren=" + this.getHasChildren() + ")";
    }
}
