package org.mukund.entity;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name="User.findAll",query="SELECT usr from User usr ORDER BY usr.email ASC"),
        @NamedQuery(name="User.findByEmail",
                    query="SELECT usr from User usr WHERE usr.email=:pEmail")

})
public class User {
    //String query="SELECT user from User usr ORDER BY user.email ASC";

    @Id
    @Column(columnDefinition = "varchar(36)")
    private String uuid;

    @Column(unique=true)
    private String userId;

    private String firstName;
    private String lastName;

    @Column(nullable =false )
    private Boolean isFaculty;


    @Column(unique=true)

    private String email;

    //@OneToOne
    //private Address address;

    public User(){
        this.uuid= UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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


    public Boolean getIsFaculty() {
        return isFaculty;
    }

    public void setIsFaculty(Boolean faculty) {
        isFaculty = faculty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  //  public Address getAddress() {
  //      return address;
  //  }

    //public void setAddress(Address address) {
    //    this.address = address;
    //}

    @Override
    public String toString() {
        return "Users{" +
                "uuid='" + uuid + '\'' +
                ", userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isFaculty=" + isFaculty +
                ", email='" + email + '\'' +
    //            ", streetAddress='" + address + '\''+
                '}';
    }
}


