import java.io.*;
import java.util.*;

class inventory {

    String name;
    int code, qty;
    double rate;

    inventory() {
        name = null;
        code = 0;
        qty = 0;
        rate = 0;

    }

    Scanner sc = new Scanner(System.in);

    void add() {
        System.out.println("Enter the item details -> ");
        System.out.print("\nItem code :");
        code = sc.nextInt();
        // System.out.print("\nItem name :");
        // name = sc.next();
        // System.out.print("\nItem rate :");
        // rate = sc.nextDouble();
        // System.out.print("\nItem quentity :");
        // qty = sc.nextInt();

        System.out.println();
        try {
            boolean ok = false;

            File list = new File("list.txt");
            File tmp = new File("tmp.txt");

            Scanner Reader_list = new Scanner(list);
            FileWriter Writer_tmp = new FileWriter(tmp, true);

            while (Reader_list.hasNext()) {
                String tname = null;
                int tcode = 0, tqty = 0;
                double trate = 0;
                if (Reader_list.hasNextInt()) {

                    tcode = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (Reader_list.hasNext()) {

                    tname = Reader_list.next();
                    // System.out.println(name);

                }
                if (Reader_list.hasNextDouble())

                {

                    trate = Reader_list.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_list.hasNextInt()) {
                    tqty = Reader_list.nextInt();
                }
                if (tcode == code) {
                    System.out.print("\nItem quentity :");
                    qty = sc.nextInt();
                    tqty += qty;
                    if (tqty<=0) {
                        tqty=0;
                    }
                    // System.out.println(tcode + "\t" + tname + "\t" + trate + "\t" + (tqty));
                    Writer_tmp.write(tcode + "\t\t" + tname + "\t\t" + trate + "\t\t" + tqty + "\n");
                    ok = true;
                    continue;
                } else
                    Writer_tmp.write(tcode + "\t\t" + tname + "\t\t" + trate + "\t\t" + tqty + "\n");

            }

            
            if (!ok) {
                System.out.print("\nItem name :");
                name = sc.next();
                System.out.print("\nItem rate :");
                rate = sc.nextDouble();
                System.out.print("\nItem quentity :");
                qty = sc.nextInt();
                Writer_tmp.write(code + "\t\t" + name + "\t\t" + rate + "\t\t" + qty + "\n");
            }
            Writer_tmp.close();
            Reader_list.close();

            // for clear list
            FileWriter fwOb = new FileWriter("list.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();

            Scanner Reader_tmp = new Scanner(tmp);
            FileWriter Writer_list = new FileWriter("list.txt", true);
            while (Reader_tmp.hasNext()) {
                String tname = null;
                int tcode = 0, tqty = 0;
                double trate = 0;
                if (Reader_tmp.hasNextInt()) {

                    tcode = Reader_tmp.nextInt();
                    // System.out.println(code);

                }
                if (Reader_tmp.hasNext()) {

                    tname = Reader_tmp.next();
                    // System.out.println(name);

                }
                if (Reader_tmp.hasNextDouble())

                {

                    trate = Reader_tmp.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_tmp.hasNextInt()) {
                    tqty = Reader_tmp.nextInt();
                }
                Writer_list.write(tcode + "\t\t" + tname + "\t\t" + trate + "\t\t" + tqty + "\n");

            }
            Writer_list.close();
            Reader_tmp.close();

            // clear tmp
            FileWriter fwOb2 = new FileWriter("tmp.txt", false);
            PrintWriter pwOb2 = new PrintWriter(fwOb2, false);
            pwOb2.flush();
            pwOb2.close();
            fwOb2.close();

            System.out.println("item Successfully added.");

        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    void by_code() {
        int cd = 0;
        System.out.print("\nEnter code :");
        cd = sc.nextInt();
        try {
            boolean ok = false;
            File list = new File("list.txt");
            Scanner Reader_list = new Scanner(list);

            while (Reader_list.hasNext()) {
                if (Reader_list.hasNextInt()) {

                    code = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (Reader_list.hasNext()) {

                    name = Reader_list.next();
                    // System.out.println(name);

                }
                if (Reader_list.hasNextDouble())

                {

                    rate = Reader_list.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_list.hasNextInt()) {

                    qty = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (cd == code) {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Code\t|\tName\t|\tRate\t|\tQuentity");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(code + "\t|\t" + name + "\t|\t" + rate + "\t|\t" + qty);
                    System.out.println("---------------------------------------------------------");
                    ok = true;
                    break;
                }

            }

            if (!ok) {
                System.out.println("Oops! Item not found.");
            }
            Reader_list.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }

    void by_name() {
        String nm;
        System.out.print("\nEnter name :");
        nm = sc.next();

        try {
            boolean ok = false;
            File list = new File("list.txt");
            Scanner Reader_list = new Scanner(list);
            while (Reader_list.hasNext()) {
                if (Reader_list.hasNextInt()) {

                    code = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (Reader_list.hasNext()) {

                    name = Reader_list.next();
                    // System.out.println(name);

                }
                if (Reader_list.hasNextDouble())

                {

                    rate = Reader_list.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_list.hasNextInt()) {

                    qty = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (name.equals(nm)) {

                    System.out.println("---------------------------------------------------------");
                    System.out.println("Code\t|\tName\t|\tRate\t|\tQuentity");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(code + "\t|\t" + name + "\t|\t" + rate + "\t|\t" + qty);
                    System.out.println("---------------------------------------------------------");
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                System.out.println("Oops! Item not found.");
            }
            Reader_list.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }

    void by_rate() {
        double d = 0;
        System.out.print("\nEnter rate :");
        d = sc.nextDouble();

        try {
            Boolean ok = false;
            File list = new File("list.txt");
            Scanner Reader_list = new Scanner(list);

            while (Reader_list.hasNext()) {
                if (Reader_list.hasNextInt()) {

                    code = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (Reader_list.hasNext()) {

                    name = Reader_list.next();
                    // System.out.println(name);

                }
                if (Reader_list.hasNextDouble()) {

                    rate = Reader_list.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_list.hasNextInt()) {

                    qty = Reader_list.nextInt();
                }
                if (d == rate) {

                    System.out.println("---------------------------------------------------------");
                    System.out.println("Code\t|\tName\t|\tRate\t|\tQuentity");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(code + "\t|\t" + name + "\t|\t" + rate + "\t|\t" + qty);
                    System.out.println("---------------------------------------------------------");
                    code = 0;
                    qty = 0;
                    rate = 0;
                    name = "";
                    ok = true;

                }

            }
            if (!ok) {
                System.out.println("Oops! Item not found.");
            }
            Reader_list.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }

    void viewAll() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Code\t|\tName\t|\tRate\t|\tQuentity");
        System.out.println("---------------------------------------------------------");
        try {
            File list = new File("list.txt");
            Scanner Reader_list = new Scanner(list);
            while (Reader_list.hasNext()) {
                if (Reader_list.hasNextInt()) {

                    code = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (Reader_list.hasNext()) {

                    name = Reader_list.next();
                    // System.out.println(name);

                }
                if (Reader_list.hasNextDouble())

                {

                    rate = Reader_list.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_list.hasNextInt()) {

                    qty = Reader_list.nextInt();
                }
                System.out.println(code + "\t|\t" + name + "\t|\t" + rate + "\t|\t" + qty);

            }
            System.out.println("---------------------------------------------------------");
            Reader_list.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    void del_by_code() {

        int cd = 0;
        System.out.print("\nEnter code :");
        cd = sc.nextInt();
        try {

            File list = new File("list.txt");
            File tmp = new File("tmp.txt");

            Scanner Reader_list = new Scanner(list);
            FileWriter Writer_tmp = new FileWriter("tmp.txt", true);

            while (Reader_list.hasNext()) {
                if (Reader_list.hasNextInt()) {

                    code = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (Reader_list.hasNext()) {

                    name = Reader_list.next();
                    // System.out.println(name);

                }
                if (Reader_list.hasNextDouble())

                {

                    rate = Reader_list.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_list.hasNextInt()) {
                    qty = Reader_list.nextInt();
                }
                if (cd == code) {

                    System.out.println("---------------------------------------------------------");
                    System.out.println("Code\t|\tName\t|\tRate\t|\tQuentity");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(code + "\t|\t" + name + "\t|\t" + rate + "\t|\t" + qty);
                    System.out.println("---------------------------------------------------------");
                    continue;
                } else
                    Writer_tmp.write(code + "\t\t" + name + "\t\t" + rate + "\t\t" + qty + "\n");

            }
            Writer_tmp.close();
            Reader_list.close();

            // clearr list

            FileWriter fwOb = new FileWriter("list.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();

            Scanner Reader_tmp = new Scanner(tmp);
            FileWriter Writer_list = new FileWriter("list.txt", true);

            while (Reader_tmp.hasNext()) {
                if (Reader_tmp.hasNextInt()) {

                    code = Reader_tmp.nextInt();
                    // System.out.println(code);

                }
                if (Reader_tmp.hasNext()) {

                    name = Reader_tmp.next();
                    // System.out.println(name);

                }
                if (Reader_tmp.hasNextDouble())

                {

                    rate = Reader_tmp.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_tmp.hasNextInt()) {
                    qty = Reader_tmp.nextInt();
                }
                Writer_list.write(code + "\t\t" + name + "\t\t" + rate + "\t\t" + qty + "\n");

            }
            Writer_list.close();
            Reader_tmp.close();

            // clear tmp
            FileWriter fwOb2 = new FileWriter("tmp.txt", false);
            PrintWriter pwOb2 = new PrintWriter(fwOb2, false);
            pwOb2.flush();
            pwOb2.close();
            fwOb2.close();

            System.out.println("Item Successfully removed");

        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }

    void del_by_name() {

        String s;
        System.out.print("\nEnter name :");
        s = sc.next();

        try {

            File list = new File("list.txt");
            File tmp = new File("tmp.txt");

            Scanner Reader_list = new Scanner(list);
            FileWriter Writer_tmp = new FileWriter("tmp.txt", true);

            while (Reader_list.hasNext()) {
                if (Reader_list.hasNextInt()) {

                    code = Reader_list.nextInt();
                    // System.out.println(code);

                }
                if (Reader_list.hasNext()) {

                    name = Reader_list.next();
                    // System.out.println(name);

                }
                if (Reader_list.hasNextDouble())

                {

                    rate = Reader_list.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_list.hasNextInt()) {
                    qty = Reader_list.nextInt();
                }
                if (s.equals(name)) {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Code\t|\tName\t|\tRate\t|\tQuentity");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(code + "\t|\t" + name + "\t|\t" + rate + "\t|\t" + qty);
                    System.out.println("---------------------------------------------------------");
                    continue;
                } else
                    Writer_tmp.write(code + "\t\t" + name + "\t\t" + rate + "\t\t" + qty + "\n");

            }
            Writer_tmp.close();
            Reader_list.close();

            // clear list
            FileWriter fwOb = new FileWriter("list.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();

            Scanner Reader_tmp = new Scanner(tmp);
            FileWriter Writer_list = new FileWriter("list.txt", true);

            while (Reader_tmp.hasNext()) {
                if (Reader_tmp.hasNextInt()) {

                    code = Reader_tmp.nextInt();
                    // System.out.println(code);

                }
                if (Reader_tmp.hasNext()) {

                    name = Reader_tmp.next();
                    // System.out.println(name);

                }
                if (Reader_tmp.hasNextDouble())

                {

                    rate = Reader_tmp.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_tmp.hasNextInt()) {
                    qty = Reader_tmp.nextInt();
                }
                Writer_list.write(code + "\t\t" + name + "\t\t" + rate + "\t\t" + qty + "\n");

            }
            Writer_list.close();
            Reader_tmp.close();
            FileWriter fwOb2 = new FileWriter("tmp.txt", false);
            PrintWriter pwOb2 = new PrintWriter(fwOb2, false);
            pwOb2.flush();
            pwOb2.close();
            fwOb2.close();

            System.out.println("Item Successfully removed");

        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }

}

class shop extends inventory {
    String name0;
    int code0, qty0;
    double rate0, total0;

    shop() {
        name0 = null;
        code0 = 0;
        qty0 = 0;
        rate0 = 0;
        total0 = 0;
    }

    void purchase() {
        System.out.println("Enter the item to purchase -> ");
        System.out.print("\nItem name :");
        name0 = sc.next();

        try {
            // FileWriter Writer = new FileWriter("list.txt", true);
            boolean ok = false;
            // File Obj = new File("list.txt");
            // Scanner Reader = new Scanner(Obj);

            File list = new File("list.txt");
            File cart = new File("cart.txt");
            File tmp = new File("tmp.txt");

            Scanner Reader = new Scanner(list);
            FileWriter Writer_cart = new FileWriter(cart, true);
            FileWriter Writer_tmp = new FileWriter(tmp, true);

            while (Reader.hasNext()) {
                String tname = null;
                int tcode = 0, tqty = 0;
                double trate = 0;
                if (Reader.hasNextInt()) {

                    tcode = Reader.nextInt();
                    // System.out.println(code);

                }
                if (Reader.hasNext()) {

                    tname = Reader.next();
                    // System.out.println(name);

                }
                if (Reader.hasNextDouble())

                {

                    trate = Reader.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader.hasNextInt()) {
                    tqty = Reader.nextInt();
                }
                if (tname.equals(name0)) {
                    System.out.println("\nEnter Quentity of item. ");
                    qty0 = sc.nextInt();
                    ok = true;
                    if (tqty >= qty0) {
                        total0 = qty0 * trate;
                        tqty -= qty0;
                        Writer_cart.write(tcode + "\t\t" + tname + "\t\t" + trate + "\t\t" + qty0 + "\t\t" + total0 + "\n");
                        Writer_tmp.write(tcode + "\t\t" + tname + "\t\t" + trate + "\t\t" + tqty + "\n");
                    } else {
                        System.out.println("\nWe don't have enough quentity of required item.");
                        Writer_tmp.write(tcode + "\t\t" + tname + "\t\t" + trate + "\t\t" + tqty + "\n");
                    }
                    continue;
                } else {
                    Writer_tmp.write(tcode + "\t\t" + tname + "\t\t" + trate + "\t\t" + tqty + "\n");
                }

            }
            if (!ok) {
                System.out.println("Oops! Item not found.");
            }
            else{
                System.out.println("Added into cart.");
            }
            Writer_cart.close();
            Writer_tmp.close();
            Reader.close();

            // for clear list
            FileWriter fwOb = new FileWriter("list.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();

            Scanner Reader_tmp = new Scanner(tmp);
            FileWriter Writer_list = new FileWriter("list.txt", true);
            while (Reader_tmp.hasNext()) {
                String tname = null;
                int tcode = 0, tqty = 0;
                double trate = 0;
                if (Reader_tmp.hasNextInt()) {

                    tcode = Reader_tmp.nextInt();
                    // System.out.println(code);

                }
                if (Reader_tmp.hasNext()) {

                    tname = Reader_tmp.next();
                    // System.out.println(name);

                }
                if (Reader_tmp.hasNextDouble())

                {

                    trate = Reader_tmp.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_tmp.hasNextInt()) {
                    tqty = Reader_tmp.nextInt();
                }
                Writer_list.write(tcode + "\t\t" + tname + "\t\t" + trate + "\t\t" + tqty + "\n");
            }
            Writer_list.close();
            Reader_tmp.close();

            // clear tmp
            FileWriter fwOb2 = new FileWriter("tmp.txt", false);
            PrintWriter pwOb2 = new PrintWriter(fwOb2, false);
            pwOb2.flush();
            pwOb2.close();
            fwOb2.close();

           

        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }

    void view_cart() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Code\t|\tName\t|\tRate\t|\tQuentity|\tTotal");
        System.out.println("----------------------------------------------------------------------");
        try {
            File cart = new File("cart.txt");
            Scanner Reader_cart = new Scanner(cart);
            while (Reader_cart.hasNext()) {
                if (Reader_cart.hasNextInt()) {

                    code0 = Reader_cart.nextInt();
                    // System.out.println(code);

                }
                if (Reader_cart.hasNext()) {

                    name0 = Reader_cart.next();
                    // System.out.println(name);

                }
                if (Reader_cart.hasNextDouble())

                {

                    rate0 = Reader_cart.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_cart.hasNextInt()) {

                    qty0 = Reader_cart.nextInt();
                }
                if (Reader_cart.hasNextDouble()) {

                    total0 = Reader_cart.nextDouble();
                    // System.out.println(rate);
                }

                System.out.println(code0 + "\t|\t" + name0 + "\t|\t" + rate0 + "\t|\t" + qty0 + "\t|\t" + total0);

            }
            System.out.println("----------------------------------------------------------------------");
            Reader_cart.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    void generate_bill() {

        String Customer_name = null, address = null, Mobile_no = null, E_mail = null;
        float final_total = 0f;
        System.out.println("Enter customer details...");
        System.out.print("\n\tName :");
        Customer_name = sc.nextLine();
        System.out.print("\n\tAddress (formet: district,state,country,pincode) :");
        address = sc.nextLine();
        System.out.print("\n\tMobile :");
        Mobile_no = sc.nextLine();
        if (Mobile_no.length() != 10) {
            System.out.println("Improper formet!");
        }
        while (Mobile_no.length() != 10) {
            System.out.print("\n\tMobile :");
            Mobile_no = sc.nextLine();
            if (Mobile_no.length() != 10) {
                System.out.println("Improper formet!");
            }
        }
        System.out.print("\n\tE-mail :");
        E_mail = sc.nextLine();
        if (E_mail.indexOf("@") == -1 || E_mail.indexOf(".com") == -1) {
            System.out.println("Improper formet!");
        }
        while (E_mail.indexOf("@") == -1 || E_mail.indexOf(".com") == -1) {
            System.out.print("\n\tE-mail :");
            E_mail = sc.nextLine();
            if (E_mail.indexOf("@") == -1 || E_mail.indexOf(".com") == -1) {
                System.out.println("Improper formet!");
            }

        }
        // System.out.println("----------------------------------------------------------------------");
        // System.out.println("Code\t|\tName\t|\t\tRate\t|\t\tQuentity|\t\tTotal");
        // System.out.println("----------------------------------------------------------------------");
        try {

            // clear bill
            FileWriter fw_bill = new FileWriter("bill.txt", false);
            PrintWriter pw_bill = new PrintWriter(fw_bill, false);
            pw_bill.flush();
            pw_bill.close();
            fw_bill.close();

            File cart = new File("cart.txt");
            File bill = new File("Bill.txt");
            Scanner Reader_cart = new Scanner(cart);
            FileWriter Writer_bill = new FileWriter(bill, true);
            Writer_bill.write(
                    "------------------------------------------------------------------------------------------\n");
            Writer_bill.write("Name       : " + Customer_name + "\n");
            Writer_bill.write("Address    : " + address + "\n");
            Writer_bill.write("Mobile_No. : " + Mobile_no + "\n");
            Writer_bill.write("E-mail     : " + E_mail + "\n");
            Writer_bill.write(
                    "------------------------------------------------------------------------------------------\n");
            Writer_bill.write("\nItem Details : \n");
            Writer_bill.write(
                    "------------------------------------------------------------------------------------------\n");
            Writer_bill.write("Code\t|\t\tName\t\t|\t\tRate\t\t|\t\tQuentity\t\t|\t\tTotal\n");
            Writer_bill.write(
                    "------------------------------------------------------------------------------------------\n");

            while (Reader_cart.hasNext()) {
                if (Reader_cart.hasNextInt()) {

                    code0 = Reader_cart.nextInt();
                    // System.out.println(code);

                }
                if (Reader_cart.hasNext()) {

                    name0 = Reader_cart.next();
                    // System.out.println(name);
                }
                if (Reader_cart.hasNextDouble())

                {

                    rate0 = Reader_cart.nextDouble();
                    // System.out.println(rate);
                }
                if (Reader_cart.hasNextInt()) {

                    qty0 = Reader_cart.nextInt();
                }
                if (Reader_cart.hasNextDouble()) {

                    total0 = Reader_cart.nextDouble();
                    // System.out.println(rate);
                }

                // System.out.println(code0 + "\t|\t" + name0 + "\t|\t" + rate0 + "\t|\t" + qty0
                // + "\t|\t" + total0);
                final_total += total0;
                Writer_bill.write(code0 + "\t\t|\t\t" + name0 + "\t\t|\t\t" + rate0 + "\t\t|\t\t" + qty0 + "\t\t|\t\t"
                        + total0 + "\n");

            }
            // System.out.println("----------------------------------------------------------------------");
            Writer_bill.write(
                    "------------------------------------------------------------------------------------------\n");
            Writer_bill.write("Total amount : " + final_total + " Rupees\n");
            Writer_bill.write(
                    "------------------------------------------------------------------------------------------\n");
            Writer_bill.close();
            Reader_cart.close();

            FileWriter fw_cart = new FileWriter("cart.txt", false);
            PrintWriter pw_cart = new PrintWriter(fw_cart, false);
            pw_cart.flush();
            pw_cart.close();
            fw_cart.close();

        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }

}

class IO {
    public static void PressAnyKey() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nPress any key to go back...");
        try {
            input.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        inventory i = new inventory();
        Scanner sc = new Scanner(System.in);
        outer: while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            int key;
            System.out.println("----------Warehouse Management System----------");
            System.out.println("Enter...");
            System.out.println("\t1 for add Item.");
            System.out.println("\t2 for search Item.");
            System.out.println("\t3 for delete Item.");
            System.out.println("\t4 for view all Items.");
            System.out.println("\t5 for shop.");
            System.out.println("\t0 for exit.");
            System.out.print("--> ");
            key = sc.nextInt();
            switch (key) {
                case 1: {
                    i.add();
                    IO.PressAnyKey();
                    break;
                }
                case 2: {
                    int x;
                    System.out.println("Enter...");
                    System.out.println("\t1 for search Item by code");
                    System.out.println("\t2 for search Item by name");
                    System.out.println("\t3 for search item by rate");
                    System.out.println("--> ");
                    x = sc.nextInt();
                    switch (x) {
                        case 1: {
                            i.by_code();
                            IO.PressAnyKey();
                            break;
                        }
                        case 2: {
                            i.by_name();
                            IO.PressAnyKey();
                            break;
                        }
                        case 3: {
                            i.by_rate();
                            IO.PressAnyKey();
                            break;
                        }
                        default:
                            System.out.print("Please enter a valid key!\n");
                            break;
                    }
                    break;
                }
                case 3: {
                    int x;
                    System.out.println("Enter...");
                    System.out.println("\t1 for delete Item by code");
                    System.out.println("\t2 for delete Item by name");
                    System.out.print("--> ");
                    x = sc.nextInt();
                    switch (x) {
                        case 1: {
                            i.del_by_code();
                            IO.PressAnyKey();
                            break;
                        }
                        case 2: {
                            i.del_by_name();
                            IO.PressAnyKey();
                            break;
                        }
                        default:
                            System.out.println("Please enter a valid key!");
                            break;
                    }
                    break;
                }
                case 4: {
                    i.viewAll();
                    IO.PressAnyKey();
                    break;
                }
                case 5: {
                    outer_purchase: while (true) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        i.viewAll();
                        int x;
                        System.out.println("Enter...");
                        System.out.println("\t1 to purchase.");
                        System.out.println("\t2 to view cart.");
                        System.out.println("\t3 to generate bill.");
                        System.out.println("\t0 to go back. ");

                        System.out.print("--> ");
                        x = sc.nextInt();

                        // shop object
                        shop sp = new shop();

                        switch (x) {
                            case 1: {
                                sp.purchase();
                                IO.PressAnyKey();
                                break;
                            }
                            case 2: {
                                sp.view_cart();
                                IO.PressAnyKey();
                                break;
                            }
                            case 3: {
                                sp.generate_bill();
                                IO.PressAnyKey();
                                break;
                            }
                            case 0: {
                                break outer_purchase;
                            }
                            default:
                                System.out.println("Please enter a valid key!");
                                break;
                        }
                    }
                    break;
                }

                case 0: {
                    break outer;
                }
                default:
                    System.out.println("Please enter the valid key!");
                    break;
            }

        }

    }
}