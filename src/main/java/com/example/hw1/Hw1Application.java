package com.example.hw1;

import com.example.hw1.enums.HomeType;
import com.example.hw1.model.Home;
import com.example.hw1.repository.HomeRepository;
import com.example.hw1.service.HomeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Hw1Application {

	public static void main(String[] args) {

		HomeRepository homeRepository = new HomeRepository();
		HomeServiceImpl homeService = new HomeServiceImpl(homeRepository);

		homeService.addHomeByType(HomeType.VILLA, 500000, 100, 5,2);
		homeService.addHomeByType(HomeType.VILLA, 200000, 300, 8,3);
		homeService.addHomeByType(HomeType.VILLA, 300000, 400, 11,4);

		homeService.addHomeByType(HomeType.SUMMER_HOME, 400000, 200, 5,2);
		homeService.addHomeByType(HomeType.SUMMER_HOME, 200000, 300, 8,3);
		homeService.addHomeByType(HomeType.SUMMER_HOME, 300000, 700, 11,4);

		homeService.addHomeByType(HomeType.NORMAL_HOME, 100000, 200, 5,2);
		homeService.addHomeByType(HomeType.NORMAL_HOME, 200000, 300, 8,3);
		homeService.addHomeByType(HomeType.NORMAL_HOME, 300000, 500, 11,4);

		System.out.println("Total price of normal homes : " + homeService.getTotalPriceOfNormalHomes());
		System.out.println("Total price of summer homes : " + homeService.getTotalPriceOfSummerHomes());
		System.out.println("Total price of villas : " + homeService.getTotalPriceOfVillas());
		System.out.println("Total price of all types of homes: " + homeService.getTotalPriceOfAllTypeHome());

		System.out.println("______________________________________________________________________________");

		System.out.println("Average square meter of normal homes: " + homeService.getAverageSquareMeterOfNormalHomes());
		System.out.println("Average square meter of summer homes: " + homeService.getAverageSquareMeterOfSummerHomes());
		System.out.println("Average square meter of villas: " + homeService.getAverageSquareMeterOfVillas());
		System.out.println("Average square meter of villas: " + homeService.getAverageSquareMeterOfAllTypeHomes());

		System.out.println("______________________________________________________________________________");
		System.out.println("Homes with 5 rooms and 2 living rooms: " );
		homeService.getAllTypesOfHomesByTheNumberOfRoomsAndLivingRooms(5,2).forEach(System.out::println);
	}

}
