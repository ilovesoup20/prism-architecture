package _20240518_02.domain.service;

import _20240518_02.domain.model.BusinessLogicNode;
import _20240518_02.domain.model.Visitor;

public class BusinessLogicVisitor implements Visitor {
    @Override
    public void visit(BusinessLogicNode node) {
        if (node.evaluate(node.getPredicate())) {
            node.executeLogic();
        }
    }
}
