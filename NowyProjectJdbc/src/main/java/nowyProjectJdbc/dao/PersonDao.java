package nowyProjectJdbc.dao;

import nowyProjectJdbc.MODEL.Person;
import nowyProjectJdbc.MODEL.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    Connection dbConnection;

    public PersonDao(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Person> readAdults() {
        return null;
    }

    public boolean addPersonToDao(Person person) {
        String insertQuery = "Insert into MY_SCHEMA.PERSON(NAME, SURNAME, AGE) \n" +
                "VALUES (?, ?, ?)";
        String insertPet = "Insert into MY_SCHEMA.PETS(KIND, NAME, AGE, OWNER_ID) VALUES (?, ?, ?, ?)";

        try {
            dbConnection.setAutoCommit(false);
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertQuery);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3, person.getAge());

            PreparedStatement preparedStatement2 = dbConnection.prepareStatement(insertPet);
            Pet pet = person.getPet();
            preparedStatement2.setString(1, pet.getKind());
            preparedStatement2.setString(2, pet.getName());
            preparedStatement2.setInt(3, pet.getAge());
            preparedStatement2.setInt(4, person.getId());


            preparedStatement.executeUpdate();
           ResultSet keys = preparedStatement.getGeneratedKeys();
           // select id from peson where id = 5
           if (keys.next()){
               int id = keys.getInt(1);
               System.out.println("New added key: "  + id);
               person.setId(id);

           }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                dbConnection.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
        return false;
    }

    public List<Person> readAllPerson() {
        List<Person> personList = new ArrayList<>();
        String querySql = "select ID,NAME, SURNAME, AGE\n" +
                "from MY_SCHEMA.PERSON";

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet result = statement.executeQuery(querySql);

            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                String surname = result.getString(3);
                int age = result.getInt(4);

                Person p = new Person(name, surname, age);
                p.setId(id);
                personList.add(p);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }
}
