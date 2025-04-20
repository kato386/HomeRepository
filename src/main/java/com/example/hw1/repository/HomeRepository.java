package com.example.hw1.repository;
import com.example.hw1.enums.HomeType;
import com.example.hw1.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeRepository implements IHomeRepository{
    private final List<Home> homeList;

    public HomeRepository(){
        homeList = new ArrayList<>();
    }

    @Override
    public List<Home> getAllSummerHouses() {
        return homeList.stream()
                .filter(SummerHome.class::isInstance)
                .collect(Collectors.toList());
    }

    @Override
    public List<Home> getAllVillas() {
        return homeList.stream()
                .filter(Villa.class::isInstance)
                .collect(Collectors.toList());
    }

    @Override
    public List<Home> getAllNormalHomes() {
        return homeList.stream()
                .filter(NormalHome.class::isInstance)
                .collect(Collectors.toList());
    }

    @Override
    public List<Home> getAllHomes() {
        return new ArrayList<>(homeList);
    }

    @Override
    public List<Home> getAllHomesByNumberOfRoomsAndNumberOfHalls(int numberOfRooms, int numberOfLivingRooms) {
        return homeList.stream()
                .filter(home -> home.getNumberOfRooms() == numberOfRooms && home.getNumberOfLivingRooms() == numberOfLivingRooms)
                .collect(Collectors.toList());
    }

    public void addHomeByType(HomeType homeType, double price, int squareMeter, int numberOfRooms, int numberOfLivingRooms) {
        Home newHome;

        switch (homeType) {
            case VILLA -> newHome = new Villa(price, squareMeter, numberOfRooms, numberOfLivingRooms);
            case SUMMER_HOME -> newHome = new SummerHome(price, squareMeter, numberOfRooms, numberOfLivingRooms);
            case NORMAL_HOME -> newHome = new NormalHome(price, squareMeter, numberOfRooms, numberOfLivingRooms);
            default -> throw new IllegalArgumentException("Home type " + homeType + " is not valid.");
        }

        homeList.add(newHome);
    }
}
