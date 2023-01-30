package ptf.rs.parcijala2.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime = "", prezime = "", email = "", telefon = "", komentar = "";
    @Enumerated(EnumType.ORDINAL)
    private Tip tip;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }


    public enum Tip {
        DOKTOR, INZENJER, BRAVAR, STOLAR, DRVOSJECA, POLICAJAC;

        private final String name;

        Tip() {
            this.name = Arrays.stream(name().split("_")).map(s -> s.charAt(0) + s.substring(1).toLowerCase()).collect(Collectors.joining(" "));
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
