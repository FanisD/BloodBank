package gr.hua.dit.ds.BloodBank.entity;

import jakarta.persistence.*;

@Entity
@Table(name="requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="LivingArea")
    private String LivingArea;

    @Column(name="BloodType")
    private String BloodType;

    public Request() {
    }

    public Request(int id, String LivingArea, String BloodType) {
        this.id = id;
        this.LivingArea = LivingArea;
        this.BloodType = BloodType;
    }

    @OneToOne(mappedBy = "request",cascade = CascadeType.ALL)
    private BloodTest bloodTest;

    public BloodTest getBloodTest() {
        return bloodTest;
    }

    public void setBloodTest(BloodTest bloodTest) {
        this.bloodTest = bloodTest;
    }

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getLivingArea() {
        return LivingArea;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLivingArea(String LivingArea) {
        this.LivingArea = LivingArea;
    }

    public void setBloodType(String BloodType) {
        this.BloodType = BloodType;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", LivingArea='" + LivingArea + '\'' +
                ", BloodType='" + BloodType + '\'' +
                '}';
    }

}
