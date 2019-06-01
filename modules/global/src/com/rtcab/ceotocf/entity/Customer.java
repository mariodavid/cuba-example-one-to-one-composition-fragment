package com.rtcab.ceotocf.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;

@NamePattern("%s|name")
@Table(name = "CEOTOCF_CUSTOMER")
@Entity(name = "ceotocf_Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 5774866627564849287L;

    @Column(name = "NAME")
    protected String name;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ADDRESS_ID")
    protected Address invoiceAddress;

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}