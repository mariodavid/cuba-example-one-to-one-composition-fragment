package com.rtcab.ceotocf.web.screens.producer;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstancePropertyContainer;
import com.haulmont.cuba.gui.screen.*;
import com.rtcab.ceotocf.entity.Address;
import com.rtcab.ceotocf.entity.Producer;

import javax.inject.Inject;

@UiController("ceotocf_Producer.edit")
@UiDescriptor("producer-edit.xml")
@EditedEntityContainer("producerDc")
@LoadDataBeforeShow
public class ProducerEdit extends StandardEditor<Producer> {

    @Inject
    protected DataContext dataContext;

    @Inject
    protected InstancePropertyContainer<Address> addressDc;

    @Subscribe
    protected void onInitEntity(InitEntityEvent<Producer> event) {
        Producer producer = event.getEntity();
        producer.setAddress(createAddress());
    }

    private Address createAddress() {
        return dataContext.create(Address.class);
    }
}