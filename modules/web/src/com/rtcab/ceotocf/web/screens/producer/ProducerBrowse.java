package com.rtcab.ceotocf.web.screens.producer;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.ceotocf.entity.Producer;

@UiController("ceotocf_Producer.browse")
@UiDescriptor("producer-browse.xml")
@LookupComponent("producersTable")
@LoadDataBeforeShow
public class ProducerBrowse extends StandardLookup<Producer> {
}