# CUBA example: 1:1 composition with Fragments

This example shows how to display one-to-one compositions with different techniques of code reuse.

Mainly the Fragments functionality is utilized in different ways.

The example is based on the following resources:

* [Reference documentation on Fragments](https://doc.cuba-platform.com/manual-7.0/using_screen_fragments.html)
* [CUBA guide - Composition](https://www.cuba-platform.com/guides/data-modelling-composition)

## Problem Domain

* Customer <>---invoiceAddress-----> Address (1:1 Composition)
* Order <>---deliveryAddress-----> Address (1:1 Composition)
* Producer <>---address-----> Address (1:1 Composition)

The `Address` entity is a dedicated entity which is referenced as a One-to-One composition.


## UI Solutions

The different UI solutions to render the Address information in the corresponding editors differ in how the code-reuse
of the address editor is used.

![overview](https://github.com/mariodavid/cuba-example-one-to-one-composition-fragment/blob/master/img/overview.gif)



### Solution 1: Address Editor


![solution-1](https://github.com/mariodavid/cuba-example-one-to-one-composition-fragment/blob/master/img/solution-1.png)

The first option is not using Fragments. Instead it uses the normal rendering mechanism of a 1:1 composition in CUBA:

A dedicated entity editor is created and displayed via a PickerField which only contains an Open action.

This can be seen in action in the  Customer editor screen:



### Solution 2: Address Fragment with Input Fields


![solution-2](https://github.com/mariodavid/cuba-example-one-to-one-composition-fragment/blob/master/img/solution-2.png)


The second option uses a Fragment for rendering the input fields of the address. It defines a particular grid layout
in which the fields are rendered. The Fragments defines a Data container, which is used for binding the data from the input fields.

Note, that the attribute of the data container `provided="true"` is set. This requires
the outer editor to have a data container defined with the same name. In this example, since
the address is a nested data container of the order instance through the One-to-One composition,
this will be the data container which is used so that the composition is correctly saved.

```xml
<fragment xmlns="http://schemas.haulmont.com/cuba/screen/fragment.xsd">
    <data>
        <instance id="addressDc"
                  class="com.rtcab.ceotocf.entity.Address"
                  view="_local"
                  provided="true">
            <loader/>
        </instance>
    </data>
    <layout spacing="true">
        <grid spacing="true">
            <columns count="6"/>
            <rows>
                <row>
                    <textField
                            colspan="5"
                            width="100%"
                            inputPrompt="msg://com.rtcab.ceotocf.entity.Address/Address.street"
                            dataContainer="addressDc"
                            id="streetField"
                            property="street"/>
                    <textField
                            width="100%"
                            inputPrompt="msg://houseNumberShort"
                            dataContainer="addressDc"
                            id="houseNumberField"
                            property="houseNumber"/>
                </row>
                <row>
                    <textField
                            colspan="2"
                            inputPrompt="msg://com.rtcab.ceotocf.entity.Address/Address.postcode"
                            dataContainer="addressDc"
                            id="postcodeField"
                            property="postcode"/>
                    <textField
                            colspan="4"
                            inputPrompt="msg://com.rtcab.ceotocf.entity.Address/Address.city"
                            dataContainer="addressDc"
                            id="cityField"
                            property="city"/>
                </row>
            </rows>
        </grid>
    </layout>
</fragment>
```
Within the outer editor (order-edit.xml), the fragment is loaded within a Form component:

```xml
<form id="form" dataContainer="orderDc">
    <column width="495px">
        <lookupPickerField id="customerField" optionsContainer="customersDc" property="customer">
            <actions>
                <action id="lookup" type="picker_lookup"/>
                <action id="open" type="picker_open"/>
            </actions>
        </lookupPickerField>

        <fragment screen="ceotocf_AddressFormFieldsFragment"/>

        <dateField id="orderDateField" property="orderDate"/>
    </column>
</form>
```

The limitation of this example is, that the Form component don't play nicely together with the input fields
in terms of the Labels etc.

### Solution 3: Fragment with dedicated Form component



![solution-3](https://github.com/mariodavid/cuba-example-one-to-one-composition-fragment/blob/master/img/solution-3.png)


In the last solution, another Address Fragment is used. But instead of only defining the input fields,
a complete Form component is defined within the Fragment. The data binding mechanism is exactly the same
as for the second solution.

```xml
<fragment xmlns="http://schemas.haulmont.com/cuba/screen/fragment.xsd">
    <data>
        <instance id="addressDc"
                  class="com.rtcab.ceotocf.entity.Address"
                  view="_local"
                  provided="true">
            <loader/>
        </instance>
    </data>
    <layout>
        <form id="form" dataContainer="addressDc">
            <column width="250px">
                <textField id="streetField" property="street"/>
                <textField id="houseNumberField" property="houseNumber"/>
                <textField id="postcodeField" property="postcode"/>
                <textField id="cityField" property="city"/>
            </column>
        </form>
    </layout>
</fragment>
```


The usage editor (producer-edit.xml) defines only a border box for the Fragment:

```xml
<hbox spacing="true">
    <groupBox id="producerBox" caption="msg://producerInfo" height="200px">
        <form id="form" dataContainer="producerDc">
            <column width="250px">
                <textField id="nameField" property="name"/>
            </column>
        </form>
    </groupBox>
    <groupBox id="addressBox" caption="msg://addressInfo" height="200px">
        <fragment screen="ceotocf_AddressFormFragment"/>
    </groupBox>
</hbox>
```
