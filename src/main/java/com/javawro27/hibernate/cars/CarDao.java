package com.javawro27.hibernate.cars;

import com.javawro27.hibernate.cars.model.Car;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDao {

//    public List<Car> getAll(){
//        List<Car> list = new ArrayList<>();
//
//        SessionFactory sessionFactory = HibernateUtil.getOurSessionFactory();
//        try (Session session = sessionFactory.openSession()){
//            Query<Car> carQuery = session.createQuery("SELECT a from Car a", Car.class);
//            list.addAll(carQuery.getResultList());
//        } catch (HibernateException he){
//            he.printStackTrace();
//        }
//        return list;
//    }



}
