package com.wkgp.model

import jakarta.persistence.*

@Entity
@Table(name = "TAGI")
class Tag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column("Zawartosc")
    var content: String,
)
