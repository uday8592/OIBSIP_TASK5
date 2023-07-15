import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char r;
        do {
            System.out.println("********Library management system********");
            System.out.println("press 1 to add book");
            System.out.println("press 2 to issue a book");
            System.out.println("press 3 to return a book");
            System.out.println("press 4 to print complete issue details");
            System.out.println("press 5 to exit");
            Scanner obj = new Scanner(System.in);
            System.out.println("enter any number:");
            int a = obj.nextInt();
            switch (a) {
                case 1:
                    Library aa = new Library();
                    aa.add();
                    break;
                case 2:
                    Library bb = new Library();
                    bb.iss();
                    break;
                case 3:
                    Library cc = new Library();
                    cc.ret();
                    break;
                case 4:
                    Library dd = new Library();
                    dd.detail();
                    break;
                case 5:
                    Library ee = new Library();
                    ee.exit();
                    break;
                default:
                    System.out.println("invalid number");
            }
            System.out.println("you want to select the next option? (y/n)");
            r = obj.next().charAt(0);
        } while (r == 'y' || r == 'Y');

        if (r == 'n' || r == 'N') {
            Library z = new Library();
            z.exit();
        }

    }
}

class Library {
    static String str, b, date;
    static int a, c;

    void add() {
        System.out.println("enter book name, price, and book_no");
        Scanner obj2 = new Scanner(System.in);
        String str = obj2.nextLine();
        String price = obj2.nextLine();
        int bookno = obj2.nextInt();
        System.out.println("your details are: " + str + ", " + price + ", " + bookno);
    }

    void iss() {
        Scanner obj3 = new Scanner(System.in);
        System.out.println("book name");
        str = obj3.nextLine();
        System.out.println("book_id");
        a = obj3.nextInt();
        obj3.nextLine();
        System.out.println("issue date");
        b = obj3.nextLine();
        System.out.println("total no of books issued");
        c = obj3.nextInt();
        obj3.nextLine();
        System.out.println("return book date");
        date = obj3.nextLine();

    }

    int getid() {
        return a;
    }

    void ret() {
        System.out.println("enter student_name and book_id:");
        Scanner c = new Scanner(System.in);
        String name = c.nextLine();
        int bookid = c.nextInt();
        if (a == bookid) {
            System.out.println("total details");
            System.out.println("book name: " + Library.str);
            System.out.println("book id: " + Library.a);
            System.out.println("issue date: " + Library.b);
            System.out.println("total no of books issued: " + Library.c);
            System.out.println("book return date: " + Library.date);
        } else {
            System.out.println("wrong id, please enter correct id");
        }
    }

    void detail() {
        System.out.println("book name: " + Library.str);
        System.out.println("book id: " + Library.a);
        System.out.println("issue date: " + Library.b);
        System.out.println("total no of books issued: " + Library.c);
        System.out.println("book return date: " + Library.date);

    }

    void exit() {
        System.out.println("Exiting the program...");
    }
}