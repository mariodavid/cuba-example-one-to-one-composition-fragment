package com.rtcab.ceotocf.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.ceotocf.entity.Order;

@UiController("ceotocf_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}