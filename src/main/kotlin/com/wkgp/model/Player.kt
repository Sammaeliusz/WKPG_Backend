package com.wkgp.model

import jakarta.persistence.*
import java.sql.Time

@Entity
@Table(name = "GRACZ")
class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column(name = "Email")
    var email: String,
    @Column(name = "Nazwa_gracza")
    var name: String,
    @Column(name = "PIN")
    var pin: Int,
    @Column(name = "Max_ciezkosc")
    var maxWeight: Double?,
    @Column(name = "Preferowany_czas")
    var prefTime: Time?,
    @ManyToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable(
        name = "ZNAJOMI",
        joinColumns = [(JoinColumn(name = "Gracz1_id"))],
        inverseJoinColumns = [(JoinColumn(name = "Gracz2_id"))]
    )
    var friends: MutableSet<Player>?,
    @ManyToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable(name = "TAG_GRACZE", joinColumns = [(JoinColumn(name = "Grace_Id"))])
    var playerTags: MutableSet<Tag>
)
