package _2024_05_18_02.domain.service;

import _2024_05_18_02.domain.model.BusinessLogicNode;
import _2024_05_18_02.domain.model.Visitor;

public class BusinessLogicVisitor implements Visitor {
    @Override
    public void visit(BusinessLogicNode node) {
        if (node.evaluate(node.getPredicate())) {
            node.executeLogic();
        }
    }
}
