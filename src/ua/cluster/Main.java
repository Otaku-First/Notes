package ua.cluster;

import ua.cluster.model.Note;
import ua.cluster.view.NoteView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int id;

    private static  ArrayList<Note> arr_note = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = "";
        System.out.println("Hello, let`s use notes");
        while (true) {
            System.out.println("Input command:");
            command = input.nextLine();

            command = command.toLowerCase().trim();
            switch (command) {
                case "add":
                    LocalDate  localdate = LocalDate.now();
                    LocalDateTime localtime = LocalDateTime.now();

                    String note;
                    String date = String.valueOf(localdate.getDayOfMonth()+"."+localdate.getMonthValue()+"."+localdate.getYear()
                            +" "+localtime.getHour()+":"+localtime.getMinute());
                    boolean isChecked;
                    String label;
                    System.out.println("input label");
                    label = input.next();
                    System.out.println("input you note");
                    note = input.next();
                    System.out.println("input is Checked true/false");
                    isChecked = input.nextBoolean();

                    arr_note.add(new Note(note,date,isChecked,label,id));
                    id++;
                    break;
                case "del":
                    int del_id;
                    show(arr_note);
                    System.out.println("input id note for del");
                    del_id = input.nextInt();
                    arr_note.remove(del_id);
                    break;
                case "exit":
                    System.out.println("Buy Buy");
                    System.exit(0);
                    break;
                case "sort_label":
                    Short(arr_note);
                    break;
                case "sort_date":
                    ShortDate(arr_note);
                    break;
                case "all":
                    show(arr_note);
                    break;

                case "comand":
                default:
                    System.out.println("All commands:");
                    System.out.println("all");
                    System.out.println("add");
                    System.out.println("del");
                    System.out.println("sort_label");
                    System.out.println("sort_date");
                    System.out.println("exit");
            }
        }

    }

    public static void show(ArrayList<Note> arr){
        NoteView noteView = new NoteView();
        for(int i =0; i<arr.size();i++){
            Note notes = arr.get(i);
            noteView.printNote(notes);
        }

    }

    public static void Short(ArrayList<Note> notes){
        int povtoriv = 0;
        boolean zmina = true;
        while(zmina){
            zmina = false;
            for(int i=0; i<notes.size()-1-povtoriv; i++){
                Note note = notes.get(i);
                Note note1 = notes.get(i+1);
                String label = note.getLabel();
                String label1 = note1.getLabel();
                String[] c = {label,label1};
                String[] c2 = {label,label1};
                Arrays.sort(c2);
                if(!c[0].equals(c2[0]) && !c[1].equals(c2[1])){
                    notes.remove(i);
                    notes.remove(+i);
                    notes.add(i,note1);
                    notes.add(1+i,note);
                    zmina = true;
                }
            }
            povtoriv ++;
        }
        show(notes);
    }
    public static void ShortDate(ArrayList<Note> notes){
        int povtoriv = 0;
        boolean zmina = true;
        while(zmina){
            zmina = false;
            for(int i=0; i<notes.size()-1-povtoriv; i++){
                Note note = notes.get(i);
                Note note1 = notes.get(i+1);
                String label = note.getDate();
                String label1 = note1.getDate();
                String[] c = {label,label1};
                String[] c2 = {label,label1};
                Arrays.sort(c2);
                if(!c[0].equals(c2[0]) && !c[1].equals(c2[1])){
                    notes.remove(i);
                    notes.remove(+i);
                    notes.add(i,note1);
                    notes.add(1+i,note);
                    zmina = true;
                }
            }
            povtoriv ++;
        }
        show(notes);
    }


}