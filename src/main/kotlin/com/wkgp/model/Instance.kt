package com.wkgp.model

import jakarta.persistence.*

@Entity
@Table(name = "KOLEKCJA")
class Instance(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Wlasciciel_ID", referencedColumnName = "ID")
    var player: Player,
    @ManyToOne
    @JoinColumn(name = "GRA_ID", referencedColumnName = "ID")
    var game: BoardGame,
    @Column(name = "Dostepna")
    var available: Boolean,
    @Column(name = "Ocena")
    var rating: Double,
    @ManyToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable(
        name = "TAG_GRY",
        joinColumns = [(JoinColumn(name = "Instancja_Id"))],
        inverseJoinColumns = [(JoinColumn(name = "Tag_Id"))]
    )
    var gameTags: MutableSet<Tag>?
)
