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

@Entity
@Table(name = "ROZGRYWKI")
data class Plays(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(cascade = [(CascadeType.MERGE)])
    @JoinColumn(name = "Gra_id")
    val gra: BoardGame,
    @Column(name = "Czas_rozgrywki")
    val playtime: Long,
    @Column(name = "Data_rozgrywki")
    val dateOfPlay: String,
    @OneToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable("GRACZE_ROZGRYWKI", joinColumns = [JoinColumn(name = "ID")])
    @JoinColumn(name = "Gracz_Id")
    val players:MutableList<Player>
)
