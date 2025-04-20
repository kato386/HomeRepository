package com.example.hw1.service;

import com.example.hw1.enums.HomeType;
import com.example.hw1.model.Home;

import java.util.List;

public interface IHomeService {
    double getTotalPriceOfNormalHomes();
    double getTotalPriceOfVillas();
    double getTotalPriceOfSummerHomes();
    double getTotalPriceOfAllTypeHome();
    double getAverageSquareMeterOfNormalHomes();
    double getAverageSquareMeterOfVillas();
    double getAverageSquareMeterOfSummerHomes();
    double getAverageSquareMeterOfAllTypeHomes();
    List<Home> getAllTypesOfHomesByTheNumberOfRoomsAndLivingRooms(int numberOfRooms, int numberOfLivingRooms);

    void addHomeByType(HomeType homeType, double price, int squareMeter, int numberOfRooms, int numberOfLivingRooms);
}