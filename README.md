# Transaction-concept
Spring 3.1 introduces the @EnableTransactionManagement annotation that we can use in a @Configuration class to enable transactional support.

## The annotation supports following:

* the Propagation Type of the transaction
* the Isolation Level of the transaction
* a Timeout for the operation wrapped by the transaction
* a readOnly flag – a hint for the persistence provider that the transaction should be read only
* the Rollback rules for the transaction<br>
<br>
Note that by default, rollback happens for runtime, unchecked exceptions only. The checked exception does not trigger a rollback of the transaction. We can, of course, configure this behavior with the rollbackFor and noRollbackFor annotation parameters.
