package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static Person person;
    static String name;
    static Sex sex;
    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        createPerson(args[i++], args[i++], args[i++]);
                    }
                    break;
                }
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        updatePerson(args[i++], args[i++], args[i++], args[i++]);
                    }
                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        deletePerson(args[i++]);
                    }
                    break;
                }
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        personInfo(args[i++]);
                    }
                    break;
                }
            }
        }
    }

    public static void createPerson(String name, String sex, String dateOfBirth) {
        Solution.name = name;
        switch (sex) {
            case "м": {
                Solution.sex = Sex.MALE;
                break;
            }
            case "ж": {
                Solution.sex = Sex.FEMALE;
                break;
            }
            default:
                Solution.sex = null;
        }
        if (Solution.sex == Sex.MALE) {
            try {
                person = Person.createMale(name, format.parse(dateOfBirth));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            try {
                person = Person.createFemale(name, format.parse(dateOfBirth));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }

    public static void updatePerson(String id, String name, String sex, String dateOfBirth) {
        Solution.name = name;
        switch (sex) {
            case "м": {
                Solution.sex = Sex.MALE;
                break;
            }
            case "ж": {
                Solution.sex = Sex.FEMALE;
                break;
            }
            default:
                Solution.sex = null;
        }
        person = allPeople.get(Integer.parseInt(id));
        person.setName(Solution.name);
        person.setSex(Solution.sex);
        try {
            person.setBirthDate(format.parse(dateOfBirth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void deletePerson(String id) {
        person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }

    public static void personInfo(String id) {
        person = allPeople.get(Integer.parseInt(id));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(person.getName() + " " + ((person.getSex() == Sex.MALE) ? "м" : "ж") + " " + dateFormat.format(person.getBirthDate()));
    }
}
