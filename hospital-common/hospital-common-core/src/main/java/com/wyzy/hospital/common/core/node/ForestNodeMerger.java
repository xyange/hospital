package com.wyzy.hospital.common.core.node;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/10  11:53
 * @Function:
 */
public class ForestNodeMerger {
    public ForestNodeMerger() {
    }

    public static <T extends INode> List<T> merge(List<T> items) {
        ForestNodeManager<T> forestNodeManager = new ForestNodeManager(items);
        items.forEach((forestNode) -> {
            if (forestNode.getParentId() != 0L) {
                INode node = forestNodeManager.getTreeNodeAT(forestNode.getParentId());
                if (node != null) {
                    node.getChildren().add(forestNode);
                } else {
                    forestNodeManager.addParentId(forestNode.getId());
                }
            }

        });
        return forestNodeManager.getRoot();
    }
}
