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

@Entity
@Table(name = "ROZGRYWKI")
data class Plays(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(cascade = [(CascadeType.MERGE)])
    @JoinColumn(name = "Gra_id")
    val game: BoardGame,
    @Column(name = "Czas_rozgrywki")
    val playtime: Time,
    @Column(name = "Data_rozgrywki")
    val dateOfPlay: Date,
    @OneToMany(cascade = [(CascadeType.MERGE)])
    @JoinColumn("rozgrywka_id")
    val scores: MutableList<Scores>,
)
