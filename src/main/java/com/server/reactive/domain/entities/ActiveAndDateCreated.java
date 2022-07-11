package com.server.reactive.domain.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class ActiveAndDateCreated {
    @Column(name="text",nullable = false, columnDefinition = "TEXT")
    private Boolean IsActive;
    @Temporal(TemporalType.DATE)
    @Column(name="datecreated",nullable = false)
    private Date DateCreated;
}
