package com.example.teampotentialfitness

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "set_table")
data class Set(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val reps: Int,
    val weight: Float,
    val exerciseId: Int // Foreign key linking to Exercise
)
