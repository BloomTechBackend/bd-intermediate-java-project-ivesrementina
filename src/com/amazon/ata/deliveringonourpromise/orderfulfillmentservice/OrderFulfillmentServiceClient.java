package com.amazon.ata.deliveringonourpromise.orderfulfillmentservice;

import com.amazon.ata.deliveringonourpromise.types.Promise;
import com.amazon.ata.deliveringonourpromise.types.PromiseClient;
import com.amazon.ata.deliverypromiseservice.service.DeliveryPromise;
import com.amazon.ata.deliverypromiseservice.service.DeliveryPromiseService;
import com.amazon.ata.orderfulfillmentservice.OrderFulfillmentService;
import com.amazon.ata.orderfulfillmentservice.OrderPromise;

public class OrderFulfillmentServiceClient implements PromiseClient {
    private OrderFulfillmentService ofService;

    public OrderFulfillmentServiceClient(OrderFulfillmentService ofService) {
        this.ofService = ofService;
    }

    @Override
    public Promise getPromise(String customerOrderItemId) {
        OrderPromise orderPromise = ofService.getOrderPromise(customerOrderItemId);

        if (null == orderPromise) {
            return null;
        }

        return Promise.builder()
                .withPromiseLatestArrivalDate(orderPromise.getPromiseLatestArrivalDate())
                .withCustomerOrderItemId(orderPromise.getCustomerOrderItemId())
                .withPromiseLatestShipDate(orderPromise.getPromiseLatestShipDate())
                .withPromiseEffectiveDate(orderPromise.getPromiseEffectiveDate())
                .withIsActive(orderPromise.isActive())
                .withPromiseProvidedBy(orderPromise.getPromiseProvidedBy())
                .withAsin(orderPromise.getAsin())
                .build();
    }

}

