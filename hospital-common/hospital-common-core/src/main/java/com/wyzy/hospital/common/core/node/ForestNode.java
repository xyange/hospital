package com.wyzy.hospital.common.core.node;

/**
 * @Author aqie
 * Date on 2021/4/10  11:53
 * @Function:
 */
public class ForestNode extends BaseNode {
    private static final long serialVersionUID = 1L;
    private Object content;

    public ForestNode(Long id, Long parentId, Object content) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContent(final Object content) {
        this.content = content;
    }

    public String toString() {
        return "ForestNode(content=" + this.getContent() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ForestNode)) {
            return false;
        } else {
            ForestNode other = (ForestNode)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ForestNode;
    }

}
