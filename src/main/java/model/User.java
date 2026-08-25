package model;

/**
 * POJO dai dien cho du lieu nguoi dung gui tu form khao sat.
 */
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String source;              // radio: bo, tu ban be, mang xa hoi, khac
    private boolean wantOffers;         // checkbox "offers"
    private boolean emailAnnouncements; // checkbox "emailAnnouncements"
    private String contact;             // select: email_or_postal, email, postal

    public User() {
    }

    public User(String firstName, String lastName, String email, String dateOfBirth,
                String source, boolean wantOffers, boolean emailAnnouncements, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.source = source;
        this.wantOffers = wantOffers;
        this.emailAnnouncements = emailAnnouncements;
        this.contact = contact;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isWantOffers() {
        return wantOffers;
    }

    public void setWantOffers(boolean wantOffers) {
        this.wantOffers = wantOffers;
    }

    public boolean isEmailAnnouncements() {
        return emailAnnouncements;
    }

    public void setEmailAnnouncements(boolean emailAnnouncements) {
        this.emailAnnouncements = emailAnnouncements;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", source='" + source + '\'' +
                ", wantOffers=" + wantOffers +
                ", emailAnnouncements=" + emailAnnouncements +
                ", contact='" + contact + '\'' +
                '}';
    }
}