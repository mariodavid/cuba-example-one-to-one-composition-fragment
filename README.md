# CUBA example: 1:1 composition with Fragments

This example shows how to display one-to-one compositions with different techniques of code reuse.

Mainly the Fragments functionality is utilized in different ways.

### Problem Domain

* Customer <>---invoiceAddress-----> Address (1:1 Composition)
* Order <>---deliveryAddress-----> Address (1:1 Composition)
* Producer <>---address-----> Address (1:1 Composition)

The `Address` entity is a dedicated entity which is referenced as a One-to-One composition.


### UI Solutions

The different UI solutions to render the Address information in the corresponding editors differ in how the code-reuse
of the address editor is used.

#### Solution 1: Address Editor

The first option is not using Fragments. Instead it uses the normal rendering mechanism of a 1:1 composition in CUBA:

A dedicated entity editor is created