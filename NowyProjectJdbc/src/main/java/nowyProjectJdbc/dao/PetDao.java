package nowyProjectJdbc.dao;

import nowyProjectJdbc.MODEL.Person;
import nowyProjectJdbc.MODEL.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDao {

    Connection dbConnection;

    public PetDao(Connection dbConnection) {

       this.dbConnection = dbConnection;
    }
    public boolean addPetToDao(Pet pet) {
        String insertQuery = "Insert into MY_SCHEMA.PETS(KIND, NAME, AGE) \n" +
                "VALUES (?, ?, ?)";
        try {
                PreparedStatement preparedStatement = dbConnection.prepareStatement(insertQuery);
                preparedStatement.setString(1, pet.getKind());
                preparedStatement.setString(2, pet.getName());
                preparedStatement.setInt(3, pet.getAge());

                preparedStatement.executeUpdate();
                preparedStatement.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Pet> readAllPet() {
        List<Pet> petList = new ArrayList<>();
        String querySql = "select ID, KIND, NAME, AGE\n" +
                "from MY_SCHEMA.PETS";

        try {
            Statement statement = dbConnection.createStatement();
            ResultSet result = statement.executeQuery(querySql);

            while (result.next()) {
                int id = result.getInt(1);
                String kind = result.getString(2);
                String name = result.getString(3);
                int age = result.getInt(4);

                Pet p = new Pet(id, name, kind, age);
                p.setId(id);
                petList.add(p);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

