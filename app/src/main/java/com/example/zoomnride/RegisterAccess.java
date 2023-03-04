package com.example.zoomnride;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RegisterAccess {
    @Insert
    void insert(Register register);

    @Delete
    void delete(Register register);

    @Update
    void update(Register register);

    @Query("SELECT * FROM Register_table ORDER BY id ASC")
    LiveData<List<Register>> getAllRegister();

}
