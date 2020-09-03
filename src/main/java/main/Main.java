package main;

import main.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private Publisher publisher;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    //auto-configuration takes care of instantiating config objects
    //overriding run method to call publisher.
    @Override
    public void run(String... args) throws Exception {

        //   publisher.sendMessage("my first kafka message"); //22 bytes (i.e UTF 8) 1 char=1 byte)
        Employee employee = new Employee();
        employee.setEmpId("100");
        employee.setName("harshal");
        employee.setPhone("35262626");
        publisher.sendMessage(employee); //22 bytes (i.e UTF 8) 1 char=1 byte)a


        //above we are sending message of particular format.
        //what if i need to send different formats of messages to kafka? //multiple kafka templates  with appropriate generics need to be created.sa

    }

    @KafkaListener(topics = "harshal", groupId = "test-consumer-group")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}


