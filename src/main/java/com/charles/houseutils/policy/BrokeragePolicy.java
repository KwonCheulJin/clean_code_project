package com.charles.houseutils.policy;

/**
 * @author chars
 * @version 1.0.0
 * 작성일 2022/01/06
 *
 *
**/
public interface BrokeragePolicy {

    BrokerageRule createBrokerageRule(Long price);

    default Long calculate(Long price){
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price);
    }

}
