package com.wkgp.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.sql.Time

@Entity
@Table(name = "GRACZ")
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(name = "Email")
    val email: String,
    @Column(name = "Nazwa_gracza")
    val name: String,
    @Column(name="PIN")
    val pin: Int,
    @Column(name = "Max_ciezkosc")
    val maxWeight:Double?,
    @Column(name = "Preferowany_czas")
    val prefTime: Time?,
    @ManyToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable(name = "ZNAJOMI", joinColumns = [(JoinColumn(name = "Gracz1_id"))], inverseJoinColumns = [(JoinColumn(name = "Gracz2_id"))])
    val friends: MutableSet<Player>?,
    @ManyToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable(name = "TAG_GRACZE", joinColumns = [(JoinColumn(name = "Gracz_Id"))])
    val playerTags: MutableSet<Tags>?
)