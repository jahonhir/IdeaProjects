package Array.dataArray;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    Person(String firstName, String lastName, int age){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void displayPerson(){
        System.out.print("First Name: " + firstName);
        System.out.print(", Last Name: " + lastName);
        System.out.print(", Age: " + age);
        System.out.println("");
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
