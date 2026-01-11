package Assignment1;

import java.io.*;
import java.util.*;

public class p1 {
    private static Vector<Student> myStudents = new Vector<>();

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java p1 -n|-f|-l <inputfile>");
            return;
        }

        String arg = args[0];
        String filename = args[1];

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;

                String[] parts = line.split(",");

                if (parts.length < 4)
                    continue;

                if (!parts[1].matches("\\d+"))
                    continue;

                String sid = parts[1].trim();
                String fname = parts[2].trim();
                String lname = parts[3].trim();

                myStudents.add(new Student(sid, fname, lname));
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        boolean ok = mySort(myStudents, arg);
        if (!ok) {
            System.out.println("Invalid argument: " + arg);
            return;
        }

        for (Student s : myStudents) {
            System.out.println(
                    s.Getsid() + " " +
                            s.Getfname() + " " +
                            s.Getlname());
        }

    }

    private static boolean mySort(Vector<Student> v, String arg) {
        if (arg.equals("-n")) {
            Collections.sort(v, new Comparator<Student>() {
                public int compare(Student a, Student b) {
                    int lastA = Integer.parseInt(
                            a.Getsid().substring(a.Getsid().length() - 3));
                    int lastB = Integer.parseInt(
                            b.Getsid().substring(b.Getsid().length() - 3));

                    return Integer.compare(lastA, lastB);
                }
            });
            return true;
        } else if (arg.equals("-f")) {
            Collections.sort(v, new Comparator<Student>() {
                public int compare(Student a, Student b) {
                    return a.Getfname().compareToIgnoreCase(b.Getfname());
                }
            });
            return true;
        } else if (arg.equals("-l")) {
            Collections.sort(v, new Comparator<Student>() {
                public int compare(Student a, Student b) {
                    return a.Getlname().compareToIgnoreCase(b.Getlname());
                }
            });
            return true;
        }

        return false;
    }
}
