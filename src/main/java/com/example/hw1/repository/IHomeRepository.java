package com.example.hw1.repository;

import com.example.hw1.enums.HomeType;
import com.example.hw1.model.Home;

import java.util.List;

public interface IHomeRepository {
    List<Home> getAllSummerHouses();
    List<Home> getAllVillas();
    List<Home> getAllNormalHomes();
    List<Home> getAllHomes();
    List<Home> getAllHomesByNumberOfRoomsAndNumberOfHalls(int numberOfRooms, int numberOfHalls);
    void addHomeByType(HomeType homeType, double price, int squareMeter, int numberOfRooms, int numberOfLivingRooms);
}
