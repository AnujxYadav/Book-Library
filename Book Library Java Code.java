package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader.init();
        ArrayList<Book> b = new ArrayList<>();
        ArrayList<racks> r = new ArrayList<>();
        System.out.println("Welcome User,");
        System.out.println("Enter number of books and racks : ");
        int num_book = Reader.nextint();
        int num_racks = Reader.nextint();
        for(int i = 0; i<num_book; i++)
        {
            Book temp = new Book();
            temp.input(i+1);
            b.add(temp);
        }
        System.out.println("All books are added successfully!\n");
        Collections.sort(b);
        int number_of_books = num_book/num_racks;
        for(int i = 0; i<num_racks; i++)
        {
            racks temp = new racks(number_of_books, b, i);
            r.add(temp);
        }
        display_rack(r);
    }
    public static void display_rack(ArrayList<racks> r)
    {
        System.out.println("The final book list will be : ");
        int i = 1;
        for (racks obj : r)
        {
            System.out.println("Output of " + (i) + " rack is : ");
            i++;
            obj.display();
            System.out.println();
        }
    }
}

class Book implements Comparable<Book>{
    private String name;
    private int isbn, barcode;
    public void input(int i) throws IOException {
        System.out.println("Enter the name of " + i + " the Book : ");
        name = Reader.nextline();
        System.out.println("Enter the ISBN and Barcode of " + i + " the Book : ");
        isbn = Reader.nextint();
        barcode = Reader.nextint();
        System.out.println();
    }
    @Override
    public int compareTo(Book obj) {
        if (this.name.compareToIgnoreCase(obj.name) != 0) {
            return this.name.compareToIgnoreCase(obj.name);
        }
        else
        {
            if (this.isbn == obj.isbn) {
                if(this.barcode > (obj.barcode)) {
                    return 1;
                }
                else
                    return -1;
            }
            else
            {
                if(this.isbn > obj.isbn)
                    return 1;
                else
                    return -1;
            }
        }
    }
    @Override
    public String toString() {
        String s = "";
        s = s + "Name of book : " + name;
        s = s + " ISBN : " + isbn;
        s =s + " Barcode : " + barcode;
        return s;
    }
}

class racks{
    private Book b[];
    racks(){}
    racks(int number, ArrayList<Book> arr_b, int rep)
    {
        b = new Book[number];
        for(int i = 0; i<number; i++)
        {
            b[i] = arr_b.get(rep*number + i);
        }
    }
    public void display()
    {
        for(int i = 0; i<b.length; i++)
        {
            System.out.println(b[i]);
        }
    }
}





class Reader{

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in) );
        tokenizer = new StringTokenizer("");
    }

    static String nextline() throws IOException {
        return reader.readLine();
    }


    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TO DO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextint() throws IOException {
        return Integer.parseInt( next() );
    }

    static long nextlong() throws IOException {
        return Long.parseLong( next() );
    }

    static double nextdouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static float nextfloat() throws IOException {
        return Float.parseFloat( next() );
    }

    static Boolean nextboolean() throws IOException {
        return Boolean.parseBoolean( next() );
    }

}
