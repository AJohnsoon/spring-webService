### CRUD - Spring Web Service


*In this project is being used:*
```java
    Java: 17,
    Springframework: 3.0.0,
    Spring Dependency-management: 1.0.14
```

```mermaid
sequenceDiagram
    participant User
    participant Order
    participant Category
    Participant Product
    Participant OrderItem
    
    User->>Order: Start Transaction
    loop Healthcheck
    
        Order-->>Product: Select product
        Product ->> Category: get product category
        Category ->> Product: return relationship
        Product ->> OrderItem: Story Products
        OrderItem ->> Order: Verify Payment
    end    
        Order -->> Payment: Await Payment
        Payment -->> Order:  Status Transaction (PAYMENT STATUS)
        Order ->> User: End Transaction
        Note right of Payment: PAYMENT STATUS <br /> 1- WAITING PAYMENT <br /> 2- PAID <br /> 3- SHIPPED <br /> 4- DELIVERED <br /> 5- CANCELED


