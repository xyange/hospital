package com.wyzy.hospital.common.core.node;

import java.io.Serializable;
import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/10  11:50
 * @Function:
 */
public interface INode extends Serializable {
    Long getId();

    Long getParentId();

    List<INode> getChildren();

    default Boolean getHasChildren() {
        return false;
    }
}
