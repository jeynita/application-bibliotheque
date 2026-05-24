package com.example.bibliothequeapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// @Database indique à Room quelles entités font partie de la base.
// version = 1 indique la première version de notre schéma.
@Database(entities = {Livre.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // Instance unique de la base.
    private static volatile AppDatabase INSTANCE;

    // Méthode abstraite qui donne accès au DAO.
    public abstract LivreDAO livreDao();

    // Singleton thread-safe avec double-checked locking.
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "bibliotheque_database"
                            )
                            // Pour un TP d’initiation.
                            // En production, on utiliserait des migrations.
                            .fallbackToDestructiveMigration(false)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
