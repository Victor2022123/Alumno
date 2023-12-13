package com.victor.studento;

public class Student {
    private Integer id;
    private String name;
    private String career;
    private String email;
    private String phone;
    private String ci;

    public Student() {
    }

    public Student(Integer id, String name, String carrera, String email, String telefono, String ci) {
        this.id = id;
        this.name = name;
        this.career = carrera;
        this.email = email;
        this.phone = telefono;
        this.ci = ci;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
}



