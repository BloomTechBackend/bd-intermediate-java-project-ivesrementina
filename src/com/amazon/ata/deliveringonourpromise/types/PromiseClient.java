package com.amazon.ata.deliveringonourpromise.types;

public interface PromiseClient {
    Promise getPromise(String customerOrderItemId);
}
