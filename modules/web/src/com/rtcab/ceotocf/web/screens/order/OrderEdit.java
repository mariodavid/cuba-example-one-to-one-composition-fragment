package com.rtcab.ceotocf.web.screens.order;

import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstancePropertyContainer;
import com.haulmont.cuba.gui.screen.*;
import com.rtcab.ceotocf.entity.Address;
import com.rtcab.ceotocf.entity.Customer;
import com.rtcab.ceotocf.entity.Order;
import com.rtcab.ceotocf.entity.Producer;

import javax.inject.Inject;

@UiController("ceotocf_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    protected DataContext dataContext;

    @Inject
    protected InstancePropertyContainer<Address> addressDc;

    @Subscribe
    protected void onInitEntity(InitEntityEvent<Order> event) {
        Order order = event.getEntity();
        order.setDeliveryAddress(createAddress());
    }

    private Address createAddress() {
        return dataContext.create(Address.class);
    }

    @Subscribe("customerField")
    protected void onCustomerFieldValueChange(HasValue.ValueChangeEvent<Customer> event) {
        Customer value = event.getValue();
        if (value != null) {
            Address invoiceAddress = value.getInvoiceAddress();

            Address deliveryAddress = getEditedEntity().getDeliveryAddress();

            deliveryAddress.setStreet(invoiceAddress.getStreet());
            deliveryAddress.setHouseNumber(invoiceAddress.getHouseNumber());
            deliveryAddress.setPostcode(invoiceAddress.getPostcode());
            deliveryAddress.setCity(invoiceAddress.getCity());
        }
    }

    
    
    
    
    
}