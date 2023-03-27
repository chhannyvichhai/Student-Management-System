import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String gender;
    int age;
    String className;
    float score;

    void outputInformation() {
        System.out.println("ID: "+id + "\t\t" +"Name: "+ name + "\t\t\t\t" +"Gender: "+ gender + "\t\t\t" +"Age: "+ age + "\t\t" +"ClassName: "+ className + "\t\t\t" +"Score: "+ score);
        }
    void inputInformation(Scanner input) {
        boolean isIDValid = false;
        do {
            String strId;
            System.out.println("Enter ID : ");
            try {
                strId = input.next();
                id = Integer.parseInt(strId);
                isIDValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid ID format!! (Integer only! )");
            }
        } while (!isIDValid);

        System.out.println("Enter Name : ");
        input.nextLine();
        name = input.nextLine();
        System.out.println("Enter Gender : ");
        gender = input.nextLine();

        boolean isAgeValid = false;
        do {
            String strAge;
            System.out.println("Enter Age : ");
            try {
                strAge = input.next();
                age = Integer.parseInt(strAge);
                isAgeValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid AGE format!! (Integer only! )");
            }
        } while (!isAgeValid);

        System.out.println("Enter ClassName : ");
        input.nextLine();
        className = input.nextLine();

        boolean isScorevalid = false;
        do {
            String strSc;
            System.out.println("Enter Score : ");
            try {
                strSc = input.next();
                score = Integer.parseInt(strSc);
                isScorevalid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid Score format!! (Integer only! )");
            }
        } while (!isScorevalid);
    }
}

public class Main {
    static void promptEnterKey(){
        System.out.println(" ==> Press Enter to continue..........");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("--------------- Student Management System ------------------");
            System.out.println("1. Insert Student To System ");
            System.out.println("2. Edit Student Information ");
            System.out.println("3. Search Student Information");
            System.out.println("4. Delete Student Information");
            System.out.println("5. Show Student Information ");
            System.out.println("6. Exit");

            String strOption;
            System.out.print(">>> Choose your option from (1 -> 6) : ");
            strOption = input.nextLine();
            try {
                option = Integer.parseInt(strOption);
            } catch (Exception ex) {
                option = 0;
                System.out.println("Invalid Input !!!");
            }

            switch (option) {
                case 1:
                    System.out.println("------------- Add New Student Informaion ------------- ");
                    Student newStudnet = new Student();
                    newStudnet.inputInformation(input);
                    students.add(newStudnet);
                    System.out.println("Successfully added.....!");
                    input.nextLine();
                    break;

                case 2 :
                    System.out.println("----------- Edit Student Information ------------");
                    int editId = 0;
                    boolean isIdValid = false;
                    do {
                        System.out.println("Enter Student's ID to Edit: ");
                        String strId;
                        try{
                            strId = input.nextLine();
                            editId = Integer.parseInt(strId);
                            isIdValid = true;
                        }catch (Exception ex){
                            System.out.println("Invalid ID (Integer only)!!");
                        }
                    } while (!isIdValid);
                    for (Student student : students){
                        if (student.id == editId){
                            System.out.println("Enter New Name: ");
                            student.name = input.nextLine();
                            System.out.println("Enter New Gender: ");
                            student.gender = input.nextLine();

                            boolean isAgeValid = false;
                            do {
                                System.out.println("Enter New Age: ");
                                String strAge;
                                try {
                                    strAge = input.nextLine();
                                    student.age = Integer.parseInt(strAge);
                                    isAgeValid = true;
                                }catch (Exception ex){
                                    System.out.println("Invalid Age (Integer only!!)");
                                }
                            }while (!isAgeValid);

                            System.out.println("Enter New ClassName: ");
                            student.className = input.nextLine();

                            boolean isScoreValid = false;
                            do {
                                System.out.println("Enter New Score: ");
                                String strScore;
                                try{
                                    strScore = input.nextLine();
                                    student.score = Integer.parseInt(strScore);
                                    isScoreValid = true;
                                }catch (Exception ex){
                                    System.out.println("Invalid Score (Integer only!!");
                                }
                            }while (!isScoreValid);
                            }
                    break;
             }
                break;


                case 3 :
                    int searchOption;

                        System.out.println("-------------- Search Student Information ---------------");
                        System.out.println("1. Search By ID ");
                        System.out.println("2. Search By Name ");
                        System.out.println("3. Exit....");

                        String strSearch;
                        System.out.print("Choose option 1 - 3 : ");
                        strSearch = input.nextLine();
                        try {
                            searchOption = Integer.parseInt(strSearch);
                        } catch (Exception ex) {
                            searchOption = 0;
                            System.out.println("Invalid Input !!!");
                        }

                        switch(searchOption){
                            case 1 :
                                int searchID;
                                boolean isStudentExist = false;
                                System.out.println("----------- Search By ID ----------- ");
                                System.out.println("Enter ID to search : ");
                                searchID = input.nextInt();

                                for(int i = 0; i < students.size(); i++){
                                    if(searchID== students.get(i).id){
                                        // worker exist
                                        isStudentExist = true;
                                        students.get(i).outputInformation();
                                    }
                                }
                                if(!isStudentExist){
                                    System.out.println("Student with ID = "+searchID+" doesn't exist !!!");
                                }
                                promptEnterKey();
                                break;
                            case 2 :
                                System.out.println("*********** Search By Name *********** ");
                                String searchName ;
                                boolean stuName = false;
                                System.out.println("Enter name to search : ");
                                searchName = input.nextLine();

                                for(int i =0; i < students.size(); i++){
                                    if(searchName.equals(students.get(i).name)){
                                        // user exist
                                        stuName = true;
                                        students.get(i).outputInformation();
                                    }
                                }
                                if(!stuName){
                                    System.out.println("Student with Name = "+ searchName+ " doesn't exist !!!");
                                }
                        }
                        input.nextLine();
                        break;

                case 4:
                    System.out.println("------------- Delete Student Information -------------");

                    int deleteId = 0;
                    System.out.println("Enter Student's Id to Delete: ");
                    deleteId = input.nextInt();
                    for (int i = 0; i < students.size(); i++){
                        Student student = students.get(i);
                            if (student.id == deleteId){
                                students.remove(student);

                            }else
                                System.out.println("Student's Id : "+deleteId + " Not Found...!");
                    }
                    promptEnterKey();
                    break;

                case 5:
                    System.out.println("------------- Show Student Information ---------------");
                    for (int i = 0; i < students.size(); i++) {
                       students.get(i).outputInformation();
                    }
                    break;

                case 6:
                    System.out.println("Exit the program...!!");
                    break;
            }
        } while (option != 6);

    }
}
