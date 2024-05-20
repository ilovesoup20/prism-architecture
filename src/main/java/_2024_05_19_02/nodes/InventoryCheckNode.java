package _2024_05_19_02.nodes;

import _2024_05_19_02.BaseContext;
import _2024_05_19_02.LeafProcessingNode;
import _2024_05_19_02.impl.InventoryCheckAction;

import java.util.function.Consumer;

public class InventoryCheckNode {

    private InventoryCheckNode() {

    }

    public static <T extends BaseContext> LeafProcessingNode<T> newInstance() {
        return new LeafProcessingNode<T>((Consumer<T>) new InventoryCheckAction());
    }
}
