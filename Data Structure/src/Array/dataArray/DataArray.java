package Array.dataArray;


public class DataArray {

    private Person [] persons;
    private  int size;
    private  int nElements;

    DataArray(int size){
        this.size = size;
        nElements = 0;

        persons = new Person[size];
    }

    DataArray(){
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

    public static void main(String[] args) {
        DataArray persons = new DataArray(100);
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


        String searchKey = "Lucinda";
        Person found = persons.getPersonByIndex(persons.findByLastName(searchKey));

        if (found != null )
        {
            System.out.println("Found: ");
            found.displayPerson();
        }
        else {
            System.out.println("");
            System.out.println("Can't find " + searchKey);
        }

        persons.deleteByLastName ("Minh");
        persons.deleteByLastName("Henry");

        System.out.println("");
        persons.displayAll();

    }

}
