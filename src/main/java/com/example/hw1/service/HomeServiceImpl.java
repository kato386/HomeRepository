package com.example.hw1.service;

import com.example.hw1.enums.HomeType;
import com.example.hw1.exception.InvalidHomeDataException;
import com.example.hw1.model.Home;
import com.example.hw1.repository.HomeRepository;

import java.util.List;

public class HomeServiceImpl implements IHomeService{
    private final HomeRepository homeRepository;

    public HomeServiceImpl(HomeRepository homeRepository) {
        if(homeRepository == null){
            throw new InvalidHomeDataException("Home repository cannot be null");
        }
        this.homeRepository = homeRepository;
    }

    @Override
    public double getTotalPriceOfNormalHomes() {
        return calculateTotalPrice(homeRepository.getAllNormalHomes());
    }

    @Override
    public double getTotalPriceOfVillas() {
        return calculateTotalPrice(homeRepository.getAllVillas());
    }

    @Override
    public double getTotalPriceOfSummerHomes() {
        return calculateTotalPrice(homeRepository.getAllSummerHouses());
    }

    @Override
    public double getTotalPriceOfAllTypeHome() {
        return calculateTotalPrice(homeRepository.getAllHomes());
    }

    @Override
    public double getAverageSquareMeterOfNormalHomes() {
        return calculateAverageSquareMeters(homeRepository.getAllNormalHomes());
    }

    @Override
    public double getAverageSquareMeterOfVillas() {
        return calculateAverageSquareMeters(homeRepository.getAllVillas());
    }

    @Override
    public double getAverageSquareMeterOfSummerHomes() {
        return calculateAverageSquareMeters(homeRepository.getAllSummerHouses());
    }

    @Override
    public double getAverageSquareMeterOfAllTypeHomes() {
        return calculateAverageSquareMeters(homeRepository.getAllHomes());
    }

    @Override
    public List<Home> getAllTypesOfHomesByTheNumberOfRoomsAndLivingRooms(int numberOfRooms, int numberLivingRooms) {
        return homeRepository.getAllHomesByNumberOfRoomsAndNumberOfHalls(numberOfRooms,numberLivingRooms);
    }

    private double calculateTotalPrice(List<Home> homes){
        return homes.stream()
                .mapToDouble(Home::getPrice)
                .sum();
    }

    private double calculateAverageSquareMeters(List<Home> homes){
        return homes.stream()
                .mapToDouble(Home::getSquareMeter)
                .average()
                .orElse(0);
    }

    @Override
    public void addHomeByType(HomeType homeType, double price, int squareMeter, int numberOfRooms, int numberOfLivingRooms) {
        homeRepository.addHomeByType(homeType, price, squareMeter, numberOfRooms, numberOfLivingRooms);
    }
}
