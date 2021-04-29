package com.revature.intro.daos;

import com.revature.intro.models.AppUser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void saveUserToFile(AppUser newUser)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/users.txt", true)))
        {
            writer.write(newUser.toFileString());
            writer.write("\n");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public List<AppUser> loadUserProfile()
    {
        String[] result = new String[10];
        List<AppUser> userList = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("resources/users.txt")))
        {
            int index = 0;
            while ((result[index] = reader.readLine()) != null)
            {
                String[] resultArray = result[index].split(";");
                userList.add(new AppUser(resultArray[0], resultArray[1], resultArray[2], resultArray[3], resultArray[4], Integer.parseInt(resultArray[5])));

                index++;
            }
        } catch (FileNotFoundException e)
        {
            System.err.println("File not found!");

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return userList;
    }
}
