package Model;

public class Person {
    private String _firstName;
    private String _lastName;

    public Person(String firstName, String lastName){
        _firstName = firstName;
        _lastName = lastName;
    }

    @Override
    public String toString() {
        return _firstName + " " + _lastName;
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        if ( this._firstName.equals(p._firstName) && this._lastName.equals(p._lastName)){
            return true;
        }
        else {
            return false;
        }
    }
}
