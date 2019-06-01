package com.rtcab.ceotocf.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.ceotocf.entity.Customer;

@UiController("ceotocf_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}