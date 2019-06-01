package com.rtcab.ceotocf.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.ceotocf.entity.Customer;

@UiController("ceotocf_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}