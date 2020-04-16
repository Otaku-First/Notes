package ua.cluster.model;

import java.util.Objects;

public class Note {
    public int id;
    private String note;
    private String date;
    private boolean isChecked;
    public String label;

    public Note(String note, String date, boolean isChecked, String label, int id) {
        this.note = note;
        this.date = date;
        this.isChecked = isChecked;
        this.label = label;
        this.id = id;
    }

    public Note() {
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public String getLabel() {
        return label;
    }
    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "#"+id+"  Note{" +
                "label='" + label + '\'' +
                ", note='" + note + '\'' +
                ", date='" + date + '\'' +
                ", isChecked=" + isChecked +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return isChecked == note1.isChecked &&
                Objects.equals(note, note1.note) &&
                Objects.equals(date, note1.date) &&
                Objects.equals(label, note1.label)&&
                Objects.equals(id, note1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, date, isChecked, label,id);
    }


}
