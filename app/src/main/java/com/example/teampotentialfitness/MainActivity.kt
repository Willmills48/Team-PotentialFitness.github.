package com.example.teampotentialfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Accessing the database
        val database = WorkoutDatabase.getDatabase(applicationContext)
        val workoutDao = database.workoutDao()

        // Dummy data for display purposes
        val workouts = listOf(
            Workout(id = 1, workoutName = "Morning Routine"),
            Workout(id = 2, workoutName = "Evening Workout")
        )
        val exercises = listOf(
            Exercise(id = 1, name = "Push-up", workoutId = 1),
            Exercise(id = 2, name = "Squat", workoutId = 1),
            Exercise(id = 3, name = "Running", workoutId = 2)
        )

        setContent {
            WorkoutList(workouts = workouts, exercises = exercises)
        }
    }
}

@Composable
fun WorkoutList(workouts: List<Workout>, exercises: List<Exercise>) {
    LazyColumn {
        items(workouts) { workout ->
            Text(text = "Workout: ${workout.workoutName}")
            WorkoutExercises(exercises = exercises.filter { it.workoutId == workout.id })
        }
    }
}

@Composable
fun WorkoutExercises(exercises: List<Exercise>) {
    Column {
        exercises.forEach { exercise ->
            Text(text = "Exercise: ${exercise.name}")
        }
    }
}

