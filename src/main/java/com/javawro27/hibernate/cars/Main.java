package com.javawro27.hibernate.cars;

import com.javawro27.hibernate.cars.model.Car;
import com.javawro27.hibernate.cars.model.Colour;
import com.javawro27.hibernate.cars.model.Model;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarDao dao = new CarDao();
        Scanner scanner = new Scanner(System.in);
        String commend;

        do{
            System.out.println("Podaj komendę [add/list/delete/update/quit]");
            commend = scanner.nextLine();
            if(commend.equalsIgnoreCase("add")){
                addCar(scanner);
            } else if(commend.equalsIgnoreCase("list")){
                listCar();
            } else if(commend.equalsIgnoreCase("delete")){
                deleteCar(scanner);
            } else if(commend.equalsIgnoreCase("update")){
                updateCar(scanner);
            }
        } while (
                !commend.equalsIgnoreCase("quit")
        );
    }

    private static void updateCar(Scanner scanner) {
        EntityDao<Car> dao = new EntityDao<>();

        System.out.println("Podaj parametry: Identyfikator");
        Long id = Long.valueOf(scanner.nextLine());

        Optional<Car> carOptional = dao.findById(Car.class, id);
        if(carOptional.isPresent()){
            Car car = carOptional.get();
            System.out.println("Próbujesz edytować rekord: "+car);

            System.out.println("Podaj parametry [numer_rej/marka/poj_silnika/czy_benzyna/kolor]");
            String line = scanner.nextLine();
            String [] words = line.split(" ");
            car = Car.builder()
                    .registrationNumber(words[0])
                    .model(Model.valueOf(words[1].toUpperCase()))
                    .engineCapacity(Double.parseDouble(words[2]))
                    .forPetrol(Boolean.parseBoolean(words[3]))
                    .colour(Colour.valueOf(words[4].toUpperCase()))
                    .id(id)
                    .build();
            dao.saveOrUpdate(car);
        } else {
            System.err.println("Error, Car o takim id nie istnieje.");
        }
    }

    private static void deleteCar(Scanner scanner) {
        EntityDao<Car> dao = new EntityDao<>();
        System.out.println("Podaj parametry: Identyfikator");
        Long id = Long.valueOf(scanner.nextLine());

        Optional<Car> carOptional = dao.findById(Car.class, id);
        if(carOptional.isPresent()){
            Car car = carOptional.get();
            dao.delete(car);
        }
    }

    private static void listCar() {
        System.out.println("Lista samochodów:");
        new EntityDao<Car>().getAll(Car.class).stream().forEach(System.out::println);
    }

    private static void addCar(Scanner scanner) {
        EntityDao<Car> dao = new EntityDao<>();

        System.out.println("Podaj parametry [numer_rej/marka/poj_silnika/czy_benzyna/kolor]");
        String line = scanner.nextLine();
        String [] words = line.split(" ");
        Car car = Car.builder()
                .registrationNumber(words[0])
                .model(Model.valueOf(words[1].toUpperCase()))
                .engineCapacity(Double.parseDouble(words[2]))
                .forPetrol(Boolean.parseBoolean(words[3]))
                .colour(Colour.valueOf(words[4].toUpperCase()))
                .build();
        dao.saveOrUpdate(car);
    }
}
