package com.demoqa.array;

import com.demoqa.Base;

import java.util.Random;

public class Full_Name_Random_Array extends Base {
    String[] surnames = {"Иванов", "Степанов", "Швальц", "Доротов", "Змееедов", "Иванов"};
    String[] names = {"Игорь", "Степан", "Александр", "Егор", "Дмитрий", "Ян"};
    String[] middleNames = {"Иванович", "Степанович", "Игорьевич", "Юрьевич", "Янович", "Николаевич"};

    //String[] randomNamesArray = new String[10];
    Random random = new Random();


    public String arrayFullName() {

        String surname = surnames[random.nextInt(surnames.length)];
        String name = names[random.nextInt(names.length)];
        String middleName = middleNames[random.nextInt(middleNames.length)];

        return surname + " " + name + " " + middleName;

    }
}




