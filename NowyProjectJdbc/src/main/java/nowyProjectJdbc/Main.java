package nowyProjectJdbc;

import nowyProjectJdbc.MODEL.Person;
import nowyProjectJdbc.MODEL.Pet;
import nowyProjectJdbc.config.Config;
import nowyProjectJdbc.dao.PersonDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        try (Connection h2connection = Config.getInstance().getConnection()) {
            System.out.println(h2connection);
            PersonDao personDao = new PersonDao(h2connection);
            List<Person> personList = personDao.readAllPerson();

            for (Person p : personList) {
                System.out.println("Person read from db: ");
                System.out.println(p);
                System.out.println();
            }
                Person somebody = new Person ("Marta", "KOC", 15);
                personDao.addPersonToDao(somebody);

            //Pet anypet = new Pet(4, "BigDog", "Killer", 4);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
