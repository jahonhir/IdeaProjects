package Sort.objectInsertionSort;



public class ObjectInsertionSort {

    private Person [] persons;
    private  int size;
    private  int nElements;

    ObjectInsertionSort(int size){
        this.size = size;
        nElements = 0;

        persons = new Person[size];
    }

    ObjectInsertionSort(){
        this.size = 100;
        nElements = 0;
        persons = new Person[size];
    }

    public int findByLastName(String lastName){
        for(int i = 0; i < nElements; i++){
            Person isPerson = persons[i];
            if(lastName.equals(isPerson.getLastName())){
                return i;
            }
        }
        return -1;
    }

    public void insert(String fistName, String lastName, int age){

        Person personToAdd = new Person(fistName, lastName, age);
        persons[nElements++] = personToAdd;
    }

    public boolean deleteByLastName(String lastNameToDelete){
        int indexToDelet = findByLastName(lastNameToDelete);
        if(indexToDelet == -1){
            System.out.println("Person to delete not foun");
            return false;
        }
        else{
            System.out.println("Deleting:" );
            persons[indexToDelet].displayPerson();

            for(int i = indexToDelet; i < nElements - 1; i++){
                persons[i] = persons[i+1];
            }
            nElements --;
            return true;
        }
    }

    public void displayAll(){
        for(int i = 0; i < nElements; i++){
            persons[i].displayPerson();
        }
    }

    public Person getPersonByIndex(int index){
        if(index > 0) {
            return persons[index];
        }
        return null;
    }

    public void insertionSort(){

        for(int i = 1; i < nElements; i++){

            Person current = getPersonByIndex(i);
            int ind = i;
            while(ind > 0 && persons[ind - 1].getFirstName().compareTo(current.getFirstName()) > 0){
                persons[ind] = persons[--ind];

            }

            persons[ind] = current;

        }
    }

    class Person {
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



    public static void main(String[] args) {
        ObjectInsertionSort persons = new ObjectInsertionSort(100);
        persons.insert("Evans", "Patty", 24);
        persons.insert("Smith", "Lorraine", 37);
        persons.insert("Yee", "Tom", 43);
        persons.insert("Adams", "Henry", 63);
        persons.insert("Hashimoto", "Sato", 21);
        persons.insert("Stimson", "Henry", 29);
        persons.insert("Velasquez", "Jose", 72);
        persons.insert("Lamarque", "Henry", 54);
        persons.insert("Vang", "Minh", 22);
        persons.insert("Creswell", "Lucinda", 18);

        persons.displayAll();


        persons.insertionSort();

        System.out.println(" ");

        persons.displayAll();




    }



}
