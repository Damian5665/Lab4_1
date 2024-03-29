/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    System.out.print("Wybierz akcje:" + "\n" + "1 - Dodaj studenta." + "\n" + "2 - Wyswitl studentow.\n0 - Zakoncz");
    Scanner wybor = new Scanner(System.in); 
    int x = wybor.nextByte();
    wybor.nextLine();
    switch(x)
      {
        case 0:
          {
            break;
          }
        case 1:
          {
            System.out.println("Podaj imie studenta:");
            String imie = wybor.nextLine();
            System.out.println("Podaj nazwisko studenta:");
            String nazwisko = wybor.nextLine();
            System.out.println("Podaj wiek studenta:");
            int wiek = wybor.nextByte();
            wybor.nextLine();
          try {
            Service s = new Service();
            s.addStudent(new Student(imie, nazwisko, wiek));
            System.out.println("Dodano.");
            //s.addStudent(new Student("Krzysztof", 20));
            //s.addStudent(new Student("Janusz", 40));
            }
            catch (IOException e) {
            }
            break;
          }
        case 2:
          {
            try 
            {
              Service s = new Service();
              var students = s.getStudents();
              for(Student current : students) {
              System.out.println(current.ToString());
            }
            }
            catch (IOException e) {
            }
            break;
          }
        default:
          {
            System.out.println("Zły wybor.");
            break;
          }
        }
      }
  }