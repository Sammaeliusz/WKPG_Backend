package com.wkgp.model

import jakarta.persistence.*

@Entity
@Table(name = "gracze_rozgrywki")
class Score(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @ManyToOne
    @JoinColumn(name = "gracz_id")
    var player: Player,
    @Column(name = "Miejsce")
    var place: Int,
    @Column(name = "Punkty")
    var points: Int,
    @Column(name = "Rozgrywka_Id")
    var rozgrywkaId: Int,
)
