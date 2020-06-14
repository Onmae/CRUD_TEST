package com0.main.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table

public class Profile implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String username;

    @Column
    private String url;

    @Column
    private LocalDateTime createdDate;

    @Builder

    public Profile(String network, String username, String url, LocalDateTime createdDate) {
        this.network = network;
        this.username = username;
        this.url = url;
        this.createdDate = createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void update(Profile profile) {
        this.network = profile.getNetwork();
        this.username = profile.getUsername();
        this.url = profile.getUrl();
    }
}
