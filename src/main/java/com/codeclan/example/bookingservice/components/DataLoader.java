package com.codeclan.example.bookingservice.components;

import com.codeclan.example.bookingservice.models.Booking;
import com.codeclan.example.bookingservice.models.Course;
import com.codeclan.example.bookingservice.models.Customer;
import com.codeclan.example.bookingservice.repositories.BookingRepository;
import com.codeclan.example.bookingservice.repositories.CourseRepository;
import com.codeclan.example.bookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Course python = new Course("Intro To Python", "Inverness", 3);
        courseRepository.save(python);
        Course java = new Course("Advanced Java", "Edinburgh", 5);
        courseRepository.save(java);
        Course ruby = new Course("Intermediate Ruby", "Dundee", 4);
        courseRepository.save(ruby);

        Customer joBloggs = new Customer("Jo Bloggs", "Elgin", 55);
        customerRepository.save(joBloggs);

        Booking booking = new Booking("01-09-20", python, joBloggs);
        bookingRepository.save(booking);

    }
}
