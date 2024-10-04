package people;

public class Person {

    private String name;
    private String constituency;
    private Integer birthYear;
    
    
    public Person() {
    }

    

    public Person(String name, String constituency, Integer birthYear) {
        this.name = name;
        this.constituency = constituency;
        this.birthYear = birthYear;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getConstituency() {
        return constituency;
    }
    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }
    public Integer getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    
    
}
