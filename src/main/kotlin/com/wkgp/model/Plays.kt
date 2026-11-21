package com.wkgp.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.sql.Date
import java.sql.Time
import java.time.LocalDate

@Entity
@Table(name = "ROZGRYWKI")
class Plays(
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
    val scores: MutableList<Scores>,
) {
}
