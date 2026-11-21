package com.wkgp

import com.wkgp.dataSources.*
import com.wkgp.model.*
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.sql.Time

@Configuration
class DataInitializer {

    @Bean
    fun seedDatabase(
        playerRepository: PlayerRepository,
        boardGameRepository: BoardGameRepository,
        instancesRepository: InstancesRepository,
        tagRepository: TagRepository,
        playsRepository: PlaysRepository,
        borrowingsRepository: BorrowingsRepository
    ) = CommandLineRunner {
        if (playerRepository.count() > 0L) {
            return@CommandLineRunner
        }

        val tag1 = tagRepository.save(Tags(id = 0, content = "Deck-building"))
        val tag2 = tagRepository.save(Tags(id = 0, content = "Imprezowa"))
        val tag3 = tagRepository.save(Tags(id = 0, content = "Przygodowa"))

        val p1 = playerRepository.save(
            Player(
                id = 0,
                email = "adam@example.com",
                name = "AdamStrateg",
                pin = 1234,
                maxWeight = 3.5,
                prefTime = Time.valueOf("02:00:00"),
                friends = mutableSetOf(),
                playerTags = mutableSetOf(tag1)
            )
        )

        val p2 = playerRepository.save(
            Player(
                id = 0,
                email = "ewa@example.com",
                name = "EwaEuro",
                pin = 5678,
                maxWeight = 4.0,
                prefTime = Time.valueOf("03:00:00"),
                friends = mutableSetOf(p1),
                playerTags = mutableSetOf(tag2, tag3)
            )
        )

        val p3 = playerRepository.save(
            Player(
                id = 0,
                email = "tomek@example.com",
                name = "TomekKostka",
                pin = 0,
                maxWeight = 2.5,
                prefTime = Time.valueOf("01:00:00"),
                friends = mutableSetOf(p1),
                playerTags = mutableSetOf()
            )
        )

        val g1 = boardGameRepository.save(
            BoardGame(
                id = 0,
                name = "Diuna: Imperium",
                weight = 3.04,
                minPlayers = 1,
                maxPlayers = 4,
                time = Time.valueOf("02:00:00"),
                genre = "STRATEGICZNA",
                coop = false,
                gameTags = mutableSetOf(tag1, tag2)
            )
        )
        val g2 = boardGameRepository.save(
            BoardGame(
                id = 0,
                name = "Tajniacy",
                weight = 1.26,
                minPlayers = 2,
                maxPlayers = 8,
                time = Time.valueOf("00:00:15"),
                genre = "IMPREZOWA",
                coop = true,
                gameTags = mutableSetOf(tag3)
            )
        )

        val inst1 = instancesRepository.save(
            Instance(id = 0, player = p1, game = g1, available = true, rating = 9, gameTags = mutableSetOf(tag1, tag2))
        )
        val inst2 = instancesRepository.save(
            Instance(id = 0, player = p1, game = g2, available = false, rating = 8, gameTags = mutableSetOf(tag1))
        )

        borrowingsRepository.save(
            Borrowings(
                id = 0,
                game = inst2,
                borrower = p3,
                borrowDate = LocalDate.now().minusDays(5),
                returnDate = LocalDate.now().plusDays(9)
            )
        )

        playsRepository.save(
            Plays(
                id = 0,
                game = inst1,
                playtime = Time.valueOf("01:00:00"),
                dateOfPlay = LocalDate.now().minusDays(2),
                players = mutableListOf(p1, p2, p3),
                scores = mutableListOf()
            )
        )

    }
}