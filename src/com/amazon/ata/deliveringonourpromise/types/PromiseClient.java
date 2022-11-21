package com.amazon.ata.deliveringonourpromise.types;

/**
 * Promise interface to abstract calls.
 */
public interface PromiseClient {
    /**
     * Returns the promise history's promises.
     * @param customerOrderItemId the order item ID to fetch promise for
     * @return a List of promises for the given order item ID
     */
    Promise getPromise(String customerOrderItemId);
}
