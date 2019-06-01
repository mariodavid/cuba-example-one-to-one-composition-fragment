package com.rtcab.ceotocf.web.screens.address;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.ceotocf.entity.Address;

@UiController("ceotocf_Address.edit")
@UiDescriptor("address-edit.xml")
@EditedEntityContainer("addressDc")
@LoadDataBeforeShow
public class AddressEdit extends StandardEditor<Address> {
}