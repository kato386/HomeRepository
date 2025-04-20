package com.example.hw1.model;

import com.example.hw1.exception.InvalidHomeDataException;

public abstract class Home {
    protected double price;
    protected double squareMeter;
    protected int numberOfRooms;
    protected int numberOfLivingRooms;

    protected Home(){

    }

    protected Home(double price, double squareMeter, int numberOfRooms, int numberOfLivingRooms){
        validateHomeData(price, squareMeter, numberOfRooms, numberOfLivingRooms);
        this.price = price;
        this.squareMeter = squareMeter;
        this.numberOfRooms = numberOfRooms;
        this.numberOfLivingRooms = numberOfLivingRooms;
    }

    private void validateHomeData(double price, double squareMeter, int numberOfRooms, int numberOfLivingRooms){
        if(price <= 0){
            throw new InvalidHomeDataException("Price must be greater than 0");
        }
        if(squareMeter <= 0){
            throw new InvalidHomeDataException("Square meter must be greater than 0");
        }
        if(numberOfRooms <= 0){
            throw new InvalidHomeDataException("Number of rooms must be greater than 0");
        }
        if(numberOfLivingRooms <= 0){
            throw new InvalidHomeDataException("Number of living rooms must be greater than 0");
        }
    }

    public double getPrice() {
        return price;
    }

    public double getSquareMeter() {
        return squareMeter;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfLivingRooms(){return numberOfLivingRooms;}

    public String toString() {
        return "Home price="
                + price
                + ", squareMeter:"
                + squareMeter
                + ", numberOfRooms:"
                + numberOfRooms
                + ", numberOfLivingRooms:"
                + numberOfLivingRooms
                + '.';
    }
}
