package com.wkgp.model

import jakarta.persistence.*

@Entity
@Table(name = "tag_gracze")
class PlayerTag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @ManyToOne
    @JoinColumn(name = "tag_id")
    var tag: Tag,
    @Column(name = "Lubi")
    var like: Boolean
)
