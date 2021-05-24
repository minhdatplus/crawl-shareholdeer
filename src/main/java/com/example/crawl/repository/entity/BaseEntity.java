package com.example.crawl.repository.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 15949425370209050L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdTime;

    @Basic
    @Column(name = "CREATOR_ID", updatable = false)
    private Long creatorId;

    @Basic
    @UpdateTimestamp
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;

    @Basic
    @Column(name = "MODIFIED_ID")
    private Long lastUpdatedId;

    @Basic
    @Column(name = "IS_ACTIVE")
    private Boolean isActive = true;

    @Basic
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;

}
