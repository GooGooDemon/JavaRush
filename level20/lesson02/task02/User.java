package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(firstName);
        writer.println(lastName);
        writer.println(new SimpleDateFormat("dd.MM.yyyy").format(birthDate));
        writer.println(isMale);
        writer.println(country);
        writer.flush();
    }

    public void load(BufferedReader reader) throws Exception {
        firstName = reader.readLine();
        lastName = reader.readLine();
        birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(reader.readLine());
        isMale = Boolean.parseBoolean(reader.readLine());
        String countryString = reader.readLine();
        country = Country.valueOf(countryString);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;

        User other = (User) obj;

        return firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && birthDate.equals(other.birthDate)
                && isMale == other.isMale
                && country.equals(other.country);
    }
}
