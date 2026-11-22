package com.wkgp.model

import jakarta.persistence.*
import java.sql.Time
import java.time.LocalDate

@Entity
@Table(name = "ROZGRYWKI")
class Play(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @ManyToOne(cascade = [(CascadeType.MERGE)])
    @JoinColumn(name = "Gra_id")
    var game: Instance,
    @Column(name = "Czas_rozgrywki")
    var playtime: Time,
    @Column(name = "Data_rozgrywki")
    var dateOfPlay: LocalDate?,
    @OneToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable("GRACZE_ROZGRYWKI", joinColumns = [JoinColumn(name = "id")])
    @JoinColumn(name = "Gracz_Id")
    var players: MutableList<Player>,
    @OneToMany(cascade = [(CascadeType.MERGE)])
    @JoinColumn("rozgrywka_id")
    var scores: MutableList<Score>,
)
