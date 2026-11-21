package com.wkgp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "gracze_rozgrywki")
data class Scores(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne
    @JoinColumn(name = "gracz_id")
    val player: Player,
    @Column(name = "Miejsce")
    val place : Int,
    @Column(name = "Punkty")
    val points:Int,
    @Column(name="Rozgrywka_Id")
    val rozgrywkaId:Int,
)
