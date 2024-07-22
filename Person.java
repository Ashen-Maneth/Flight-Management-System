class Person {    
    private String name ;
    private String surname ;
    private String email ;

    // constructor //https://www.youtube.com/watch?v=JiW5UO35E0A //https://www.youtube.com/watch?v=pHOnYI-qJTA
    public Person(String name , String surname , String email ){
        this.name = name;
        this.surname = surname ;
        this.email = email ;
    }

    // setters
    public void setName(String name) { // name setter
        this.name = name ;
    }
    public void setSurname(String surname) { // surname setter
        this.surname = surname ;
    }
    public void setEmail(String email) { // email setter
        this.email = email ;
    }

    // getters
    public String getName(){  // name getter
        return name ;
    }
    public String getSurname() { // surname getter
        return surname ;
    }
    public String getEmail() { // email getter
        return email ;
    }


    public void personinfo() {
        System.out.println("Name : "+name);
        System.out.println("Surname : " + surname);
        System.out.println("Email : " + email);

    }
}