package com.crimsonlogic.tradesystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName; // ✅ Added

    @Column(nullable = false)
    private String lastName; // ✅ Added

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // USER or ADMIN

    public User(Long id, String firstName, String lastName, String username, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual(this)) return false;
        return id.equals(other.id) &&
                firstName.equals(other.firstName) &&
                lastName.equals(other.lastName) &&
                username.equals(other.username) &&
                password.equals(other.password) &&
                role.equals(other.role);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (id == null ? 43 : id.hashCode());
        result = result * PRIME + (firstName == null ? 43 : firstName.hashCode());
        result = result * PRIME + (lastName == null ? 43 : lastName.hashCode());
        result = result * PRIME + (username == null ? 43 : username.hashCode());
        result = result * PRIME + (password == null ? 43 : password.hashCode());
        result = result * PRIME + (role == null ? 43 : role.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() +
                ", firstName=" + this.getFirstName() +
                ", lastName=" + this.getLastName() +
                ", username=" + this.getUsername() +
                ", password=" + this.getPassword() +
                ", role=" + this.getRole() + ")";
    }

    public static class UserBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String role;

        UserBuilder() {}

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder role(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this.id, this.firstName, this.lastName, this.username, this.password, this.role);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id +
                    ", firstName=" + this.firstName +
                    ", lastName=" + this.lastName +
                    ", username=" + this.username +
                    ", password=" + this.password +
                    ", role=" + this.role + ")";
        }
    }
}
