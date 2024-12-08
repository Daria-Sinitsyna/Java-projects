import java.time.LocalDate;
import java.time.Period;

/**
 * Шаг 1 (п.1) Написать классы
 * - покупатель (ФИО, возраст, телефон);
  */


public class Customer {
    private String name;
    private String surname;
    private String middleName;
    private LocalDate dayOfBirth;
    private LocalDate dayOfDeath;
    private long phoneNumber;
    private Gender gender;

    public Customer(String name, String surname, String middleName, Gender gender, LocalDate dayOfBirth, LocalDate dayOfDeath,
                    long phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.dayOfDeath = dayOfDeath;
        this.phoneNumber = phoneNumber;
    }

    public int returnAge(LocalDate dayOfBirth, LocalDate dayOfDeath){
        if(dayOfDeath == null){
            dayOfDeath = LocalDate.now();
        }
        return Period.between(dayOfBirth, dayOfDeath).getYears();
    }

    @Override
    public String toString() {
        return  "name: " + name +
                ", surname: " + surname +
                ", middleName: " + middleName +
                ", gender: " + gender +
                ", dayOfBirth: " + dayOfBirth +
                ", dayOfDeath: " + dayOfDeath +
                ", phoneNumber: " + phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }
}
