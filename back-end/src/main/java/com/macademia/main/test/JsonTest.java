package com.macademia.main.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.macademia.main.*;
import com.macademia.main.auth.User;
import com.macademia.main.db.DBHandler;

enum per {
    SPRING, SUMMER1, SUMMER2, EXT_SUMMER, FALL;
}

public class JsonTest {

    public DBHandler db;

    //--[Real Value]---------------------------------------------------------------------------------------------------------------

    public MatriculaPeriod Period1 = new MatriculaPeriod(2021, "FALL");
    public MatriculaPeriod Period2 = new MatriculaPeriod(2021, "SPRING");
    public MatriculaPeriod Period3 = new MatriculaPeriod(2022, "FALL");
    public List<Section> testList = new ArrayList<Section>();
    public Matricula Matricula2 = new Matricula(Period2);
    public Matricula Matricula3 = new Matricula(Period3);

    //---[Departments]-----------------------------------------------------------------------------------------------------------

    public Department CIIC = new Department("Department of Computer Science and Engineering", "CIIC", "#bb8fce ");
    public Department INSO = new Department("Department of Software Engineering", "INSO", "#85c1e9");
    public Department INGE = new Department("Department of Engineering", "INGE", "#f1948a");
    public Department ININ = new Department("Department of Industrial Engineering", "ININ", "#f4d03f");
    public Department INGL = new Department("Department of English", "INGL", "#ffd5cd");

    //---[User Info]-------------------------------------------------------------------------------------------------------------

    public User user = new User("JohnSmitch82", "1234");
    public Student student = new Student(user, "John Smitch", "841-17-8204", CIIC);

    //---[Courses]---------------------------------------------------------------------------------------------------------------

    public Course CIIC3015 = new Course("Intro. to Programming", CIIC, "3015", 3, "FALL, SPRING, SUMMER");
    public Course CIIC3015L = new Course("Intro. to Programming Lab.", CIIC, "3015L", 1, "FALL, SPRING, SUMMER");
    public Course CIIC3075 = new Course("Foundations of Computing", CIIC, "3075", 3, "FALL, SPRING");
    public Course CIIC4010 = new Course("Advanced Programming", CIIC, "4010", 4, "FALL, SPRING");
    public Course CIIC4010L = new Course("Advanced Programming Lab.", CIIC, "4010L", 0, "FALL, SPRING");
    public Course CIIC4020 = new Course("Data Structures", CIIC, "4020", 4, "FALL, SPRING");
    public Course CIIC4020L = new Course("Data Structures Lab.", CIIC, "4020L", 0, "FALL, SPRING");
    public Course CIIC4030 = new Course("Programming Languages", CIIC, "4030", 3, "FALL, SPRING");
    public Course CIIC4050 = new Course("Operating Systems", CIIC, "4050", 4, "FALL, SPRING");
    public Course CIIC4050L = new Course("Operating Systems Lab.", CIIC, "4050L", 0, "FALL, SPRING");
    public Course CIIC4060 = new Course("Database Systems", CIIC, "4060", 3, "SPRING");
    public Course CIIC4070 = new Course("Computer Networks", CIIC, "4070", 3, "SPRING");
    public Course CIIC3081 = new Course("Computer Architecture I", CIIC, "3081", 3, "FALL");
    public Course CIIC4082 = new Course("Computer Architecture II", CIIC, "4082", 3, "SPRING");

    public Course INSO4101 = new Course("Intro. to Software Engineering",          INSO, "4101", 3, "FALL, SPRING");
    public Course INSO4115 = new Course("Software Requirements",                   INSO, "4115", 3, "SPRING");
    public Course INSO4116 = new Course("Software Design",                         INSO, "4116", 3, "FALL");
    public Course INSO4117 = new Course("Software Testing",                        INSO, "4117", 3, "SPRING");
    public Course INSO4151 = new Course("Software Engineering Project (Capstone)", INSO, "4151", 3, "FALL, SPRING");

    public Course INGE3011  = new Course("Engineering Graphics",             INGE, "3011", 4, "FALL, SPRING");
    public Course INGE3035 = new Course("Engineering Mechanics",            INGE, "3035", 3, "FALL, SPRING, SUMMER");
    public Course INGE3045 = new Course("Electrical Engineering Materials", INGE, "3045", 2, "FALL, SPRING");

    public Course ININ4010 = new Course("Engineering Probability and Statistics", ININ, "4010", 4, "FALL, SPRING, SUMMER");
    public Course ININ4015 = new Course("Engineering Economics",                  ININ, "4015", 3, "FALL, SPRING, SUMMER");

    public Course INGL3211 = new Course("Advanced English 1", INGL, "3211", 3, "FALL, SPRING, SUMMER");
    public Course INGL3212 = new Course("Advanced English 2", INGL, "3212", 3, "FALL, SPRING, SUMMER");
    public Course INGL3101 = new Course("Basic English 1", INGL, "3101", 3, "FALL, SPRING, SUMMER");
    public Course INGL3102 = new Course("Basic English 2", INGL, "3102", 3, "FALL, SPRING, SUMMER");
    public Course INGL3103 = new Course("Intermediate English 1", INGL, "3103", 3, "FALL, SPRING, SUMMER");
    public Course INGL3104 = new Course("Intermediate English 2", INGL, "3014", 3, "FALL, SPRING, SUMMER");
    public Course INGL3289 = new Course("Conversational English", INGL, "3289", 3, "FALL, SPRING, SUMMER");
    public Course INGL3345 = new Course("Movie Themes", INGL, "3345", 3, "FALL, SPRING, SUMMER");
    //---[Sections]--------------------------------------------------------------------------------------------------------------

    public Section testSection1A1 = new Section("096", "MJ", "3:30PM-4:45PM", "Heidy Sierra Gil", "S424",   CIIC3015, 1, 100);

    public Section testSection1B1 = new Section("070", "W", "1:30PM-3:20PM", "Estefania Alfaro", "S-121",   CIIC3015L, 1, 28);
    public Section testSection1B2 = new Section("071", "W", "1:30PM-3:20PM", "Maria Ramos", "S-105c",   CIIC3015L, 1, 28);
    public Section testSection1B3 = new Section("090", "W", "3:30PM-5:20PM", "Estefania Alfaro", "S-121", CIIC3015L, 1, 28);
    public Section testSection1B4 = new Section("091", "LWV", "3:30PM-5:20PM", "Maria Ramos", "S-105c", CIIC3015L, 1, 28);

    public Section testSection1C1 = new Section("030", "LWV", "9:30AM-10:20AM", "Kejie Lu", "S-114a", CIIC3075, 1, 15);
    public Section testSection1C2 = new Section("040", "LWV", "10:30AM-11:20AM", "Kejie Lu", "S-113", CIIC3075, 1, 15);
    public Section testSection1C3 = new Section("050", "LWV", "11:30AM-12:20PM", "Kejie Lu", "S-114a",  CIIC3075, 1, 15);
    public Section testSection1C4 = new Section("070", "LWV", "1:30PM-2:20PM", "Kejie Lu", "S-114a",  CIIC3075, 1, 15);
    public Section testSection1C5 = new Section("100", "LW", "4:30PM-5:45PM", "Dong Wang", "S-114a",  CIIC3075, 1, 15);

    public Section testSection1D1 = new Section("100", "LW", "4:30PM-5:45PM", "Jose Cruz", "S-113", CIIC4010, 1, 50);
    public Section testSection1D2 = new Section("100H", "LW", "4:30PM-5:45PM", "Jose Cruz", "S-113",  CIIC4010, 1, 50);

    public Section testSection1E1 = new Section("030L", "V", "9:30AM-11:20AM", "Jose Cruz", "S-121", CIIC4010L, 1, 16);
    public Section testSection1E2 = new Section("031L", "V", "9:30AM-11:20AM",  "Jose Cruz", "S-105c", CIIC4010L, 1, 16);
    public Section testSection1E3 = new Section("050L", "V", "11:30AM-1:20PM",   "Jose Cruz", "S-121", CIIC4010L, 1, 16);
    public Section testSection1E4 = new Section("051L", "V", "11:30AM-1:20PM",   "Jose Cruz", "S-105c", CIIC4010L, 1, 16);
    public Section testSection1E5 = new Section("070L", "V", "1:30PM-3:20PM",   "Jose Cruz", "S-121", CIIC4010L, 1, 16);
    public Section testSection1E6 = new Section("070L", "V", "1:30PM-3:20PM",   "Jose Cruz", "S-105c", CIIC4010L, 1, 16);

    public Section testSection1F1 = new Section("01", "MJ", "5:00PM-6:15PM", "Manuel Rodriguez", "S-113", CIIC4020, 1, 70);

    public Section testSection1G1 = new Section("030L", "L", "9:30AM-11:20AM",  "Chhaya Katiyar", "S-121", CIIC4020L, 1, 16);
    public Section testSection1G2 = new Section("050L", "L", "11:30AM-1:20PM", "Manuel Rodriguez", "S-121", CIIC4020L, 1, 16);
    public Section testSection1G3 = new Section("051L", "L", "11:30AM-1:20PM", "Chhaya Katiyar", "S-121", CIIC4020L, 1, 16);
    public Section testSection1G5 = new Section("070L", "L", "1:30PM-3:20PM",  "Gretchen Bonilla", "S-121", CIIC4020L, 1, 16);
    public Section testSection1G6 = new Section("071L", "L", "1:30PM-3:20PM",  "Manuel Rodriguez", "S-105c", CIIC4020L, 1, 16);

    public Section testSection1H1 = new Section("036", "MJ", "9:00AM-10:15AM", "Wilson Rivera", "S-113", CIIC4030, 1, 60);
    
    public Section testSection1I1 = new Section("086", "MJ", "2:00PM-3:15PM", "Emmanuel Arzuaga", "S-113", CIIC4050, 1, 60);
   
    public Section testSection1J1 = new Section("010L", "W", "7:30AM-10:20AM", "David Tatis", "S-121", CIIC4050L, 1, 16);
    public Section testSection1J2 = new Section("011L", "W", "7:30AM-10:20AM",  "Carlos Velez", "S-105c", CIIC4050L, 1, 16);
    public Section testSection1J3 = new Section("040L", "W", "10:30AM-1:20PM",   "David Tatis", "S-121", CIIC4050L, 1, 16);
    public Section testSection1J4 = new Section("041L", "W", "10:30AM-1:20PM",   "Carlos Velez", "S-105c", CIIC4050L, 1, 16);
    
    public Section testSection1M1 = new Section("096", "MJ", "3:30PM-4:45PM", "Jose Navarro", "S-114a", CIIC3081, 1, 70);
    
    public Section testSection2A1 = new Section("080", "LWV", "2:30PM-3:20PM", "Marko Schutz", "S-113",   INSO4101, 1, 80);

    public Section testSection2C1 = new Section("070", "LWV", "1:30PM-2:20PM", "Marko Schutz", "S-113", INSO4116, 1, 80);
    
    public Section testSection3A1 = new Section("030H", "LW", "9:30AM-11:20AM", "Carmen Castaneyra", "S-316",   INGE3011, 1, 30);
    public Section testSection3A2 = new Section("050H", "LW", "11:30AM-1:20PM", "Beatriz Camacho", "S-316",   INGE3011, 1, 30);
    public Section testSection3A3 = new Section("090H", "LW", "3:30PM-5:20PM", "Carmen Castaneyra", "S-316",   INGE3011, 1, 30);

    public Section testSection3B1 = new Section("010", "LWV", "7:30AM-8:20AM", "Marek Rysz", "S-308", INGE3035, 1, 30);
    public Section testSection3B2 = new Section("020", "LWV", "8:30AM-9:20AM", "Marek Rysz", "S-308",  INGE3035, 1, 30);
    public Section testSection3B3 = new Section("060", "LWV", "12:30PM-1:20PM", "Marek Rysz", "S-308",   INGE3035, 1, 30);
    public Section testSection3B4 = new Section("070", "LWV", "1:30PM-2:20PM", "Marek Rysz", "S-308",   INGE3035, 1, 30);

    public Section testSection3C1 = new Section("030H", "LWV", "9:30AM-10:20AM", "Agnes Padovani", "S-307", INGE3045, 1, 30);
    public Section testSection3C2 = new Section("040H", "LWV", "10:30AM-11:20AM", "Agnes Padovani", "S-307", INGE3045, 1, 30);
    public Section testSection3C3 = new Section("066", "MJ", "12:30PM-1:45PM", "Yang Li", "S-307",  INGE3045, 1, 30);
    public Section testSection3C4 = new Section("086", "MJ", "2:00PM-3:15PM", "Yang Li", "S-307",  INGE3045, 1, 30);
    public Section testSection3C5 = new Section("096", "MJ", "3:30PM-4:45PM", "Yang Li", "S-307",  INGE3045, 1, 30);

    public Section testSection4A1 = new Section("010", "LW", "7:30AM-9:20AM", "Noel Artiles", "II-114",   ININ4010, 1, 50);
    public Section testSection4A2 = new Section("026", "MJ", "8:30AM-10:20AM", "Hector Colon", "II-114",   ININ4010, 1, 50);
    public Section testSection4A3 = new Section("030", "LW", "9:30AM-11:20AM", "Noel Artiles", "II-114",   ININ4010, 1, 50);
    public Section testSection4A4 = new Section("060", "LW", "12:30PM-2:20PM", "Saylisse Davila", "II-114", ININ4010, 1, 50);
    public Section testSection4A5 = new Section("066", "MJ", "12:30PM-2:20PM", "Hector Colon", "II-114", ININ4010, 1, 50);
    public Section testSection4A6 = new Section("090", "LW", "3:30PM-5:20PM", "Saylisse Davila", "II-114", ININ4010, 1, 50);

    public Section testSection4B1 = new Section("016", "MJ", "7:30AM-8:45AM", "Mayra Mendez", "II-201", ININ4015, 1, 35);
    public Section testSection4B2 = new Section("020", "LWV", "8:30AM-9:20AM", "Vancy Mendez", "II-201",  ININ4015, 1, 35);
    public Section testSection4B3 = new Section("030", "LWV", "9:30AM-10:20AM", "Griselle Toro", "II-201",   ININ4015, 1, 35);
    public Section testSection4B4 = new Section("036", "MJ", "9:00AM-10:15AM", "Mayra Mendez", "II-201",   ININ4015, 1, 35);
    public Section testSection4B5 = new Section("040", "LWV", "10:30AM-11:20AM", "Nancy Mendez", "II-201",   ININ4015, 1, 35);
    public Section testSection4B6 = new Section("070", "LWV", "1:30PM-2:30PM", "Griselle Toro", "II-201", ININ4015,1, 35);

    
    public Section testSection5A1 = new Section("066", "MJ", "12:30PM-1:45PM", "Maria C. Quintero", "CH-224", INGL3211, 1, 33);
    public Section testSection5A2 = new Section("086", "MJ", "2:00PM-3:15PM",  "Maria C. Quintero", "CH-005",INGL3211, 1, 32);
    public Section testSection5A3 = new Section("096", "MJ", "3:30PM-4:45PM",   "Lawrence Chott", "CH-005", INGL3211, 1, 31);
    public Section testSection5A4 = new Section("100", "LW", "4:30PM-5:45PM",   "Stephania Uwakweh Evuleocha", "CH-319", INGL3211, 1, 30);
    public Section testSection5A5 = new Section("101", "LW", "4:30PM-5:45PM",   "Lawrence Chott", "CH-125", INGL3211, 1, 32);
    public Section testSection5A6 = new Section("116", "MJ", "5:00PM-6:15PM", "Lawrence Chott", "CH-005", INGL3211, 1,31);
    public Section testSection5A7 = new Section("120", "LW", "6:00PM-7:15PM", "Lawrence Chott", "CH-125", INGL3211,1, 32);
    
    public Section testSection5B1 = new Section("120", "LW", "6:00PM-7:15PM", "Stephania Uwakweh Evuleocha", "CH-325", INGL3212, 1, 31);

    public Section testSection5C1 = new Section("010", "LMV", "7:30AM-8:20AM", "Laura Buitrago Garcia", "CH-224", INGL3101, 1, 30);
    public Section testSection5C2 = new Section("016", "MJ", "7:30AM-8:20AM", "Myrna Rivera Montijo", "CH-318", INGL3101, 1, 30);
    public Section testSection5C3 = new Section("017", "MJ", "7:30AM-8:20AM", "Waleska Morciglio Quintana", "CH-221", INGL3101, 1, 30);
    public Section testSection5C4 = new Section("018", "MJ", "7:30AM-8:20AM", "Iris Toro Manzano", "CH-123", INGL3101, 1, 30);
    public Section testSection5C5 = new Section("020", "LWV", "8:30AM-9:20AM", "Laura Buitrago Garcia", "CH-224", INGL3101, 1, 30);
    public Section testSection5C6 = new Section("030", "LWV", "9:30AM-10:20AM", "Maria Orejarena Torres", "CH-224", INGL3101, 1, 30);
    public Section testSection5C7 = new Section("036", "MJ", "9:00AM-10:15AM", "Myrna Rivera Montijo", "CH-318", INGL3101, 1, 30);
    public Section testSection5C8 = new Section("037", "MJ", "9:00AM-10:15AM", "Waleska Morciglio Quintana", "CH-221", INGL3101, 1, 30);
    public Section testSection5C9 = new Section("038", "MJ", "9:00AM-10:15AM", "Iris Toro Manzano", "CH-123", INGL3101, 1, 30);
    public Section testSection5C10 = new Section("040", "LWV", "10:30AM-11:20AM", "Maria Orejarena Torres", "CH-224", INGL3101, 1, 30);
    public Section testSection5C11 = new Section("041", "LWV", "10:30AM-11:20AM", "Rosita Rivera", "CH-324", INGL3101, 1, 30);
    public Section testSection5C12 = new Section("050", "LWV", "11:30AM-12:20PM", "William Carrero Vale", "CH-224", INGL3101, 1, 30);
    public Section testSection5C13 = new Section("051", "LWV", "11:30AM-12:20PM", "Rosita Rivera", "CH-324", INGL3101, 1, 30);
    public Section testSection5C14 = new Section("060", "LWV", "12:30PM-1:20PM", "William Carrero Vale", "CH-224", INGL3101, 1, 30);
    public Section testSection5C15 = new Section("061", "LWV", "12:30PM-1:20PM", "Ambar Rivera Beede", "CH-324", CIIC4010L, 1, 30);
    public Section testSection5C16 = new Section("070", "LWV", "1:30PM-2:20PM", "Ambar Rivera Beede", "CH-224", CIIC4010L, 1, 30);
    public Section testSection5C17 = new Section("086", "MJ", "2:00PM-3:15PM", "Myrna Rivera Montijo", "CH-318", INGL3101, 1, 30);
    public Section testSection5C18 = new Section("096", "MJ", "3:30PM-4:45PM", "Myrna Rivera Montijo", "CH-318", INGL3101, 1, 30);
    public Section testSection5C19 = new Section("100", "LW", "4:30PM-5:45PM", "Iris Toro Manzano", "CH-221", INGL3101, 1, 30);
    public Section testSection5C20 = new Section("100L", "V", "4:30PM-5:20PM", "Rosita Rivera", "CH-325", INGL3101, 1, 30);
    public Section testSection5C21 = new Section("116", "MJ", "5:00PM-6:15PM", "Iris Toro Manzano", "CH-222", INGL3101, 1, 30);
    public Section testSection5C22 = new Section("117", "MJ", "5:00PM-6:15PM", "Javier I Fabre Quiñones", "CH-223", INGL3101, 1, 30);
    public Section testSection5C23 = new Section("120", "LW", "6:00PM-7:15PM", "Javier I Fabre Quiñones", "CH-221", INGL3101, 1, 30);
    public Section testSection5C24 = new Section("130L", "V", "7:30PM-8:20PM", "Rosita Rivera", "CH-221", INGL3101, 1, 30);


    public Section testSection5D1 = new Section("010", "LWV", "12:30PM-1:45PM", "Javier I Fabre Quiñones", "CH-223", INGL3102, 1, 30);
    public Section testSection5D2 = new Section("020", "LWV", "2:00PM-3:15PM", "Javier I Fabre Quiñones", "CH-221", INGL3102, 1, 30);
    public Section testSection5D3 = new Section("060", "V", "3:30PM-4:45PM", "Rosita Rivera", "CH-221", INGL3102, 1, 60);


    public Section testSection5F1 = new Section("020", "LWV", "8:30AM-9:20AM", "Diego Zaragoza Padilla", "CH-222", INGL3104, 1, 31);
    public Section testSection5F2 = new Section("030", "LWV", "9:30AM-10:20AM", "Diego Zaragoza Padilla", "CH-222", INGL3104, 1, 30);



    public Section testSection5G1 = new Section("070", "LWV", "1:30PM-2:20PM", "Dariana Alicea Torres", "CH-324", INGL3289, 1, 30);
    public Section testSection5G2 = new Section("096", "MJ", "3:30PM-4:45PM", "Dariana Alicea Torres", "CH-319", INGL3289, 1, 30);



    public Section testSection5H1 = new Section("070", "LWV", "1:30PM-2:20PM", "Gabriel E. Romaguera Rodriguez", "CH-005", INGL3345, 1, 31);
    public Section testSection5H2 = new Section("080", "LWV", "2:30PM-3:20PM", "Nicholas Haydock", "CH-005", INGL3345, 1, 30);
    public Section testSection5H3 = new Section("100", "LW", "4:30PM-5:45PM", "Linda Rodriguez", "CH-124", INGL3345, 1, 66);
    public Section testSection5H4 = new Section("116", "MJ", "5:00PM-6:15PM", "Gabriel E. Romaguera Rodriguez", "CH-324", INGL3345, 1, 45);
    public Section testSection5H5 = new Section("120", "LW", "6:00PM-7:15PM", "Linda Rodriguez", "CH-124", INGL3345, 1, 64);
        

    public JsonTest() {

        CIIC3015.setDescription("");
        CIIC3015L.setDescription("");
        CIIC3075.setDescription("");
        CIIC4010.setDescription("");
        CIIC4010L.setDescription("");
        CIIC4020.setDescription("");
        CIIC4020L.setDescription("");
        CIIC4030.setDescription("");
        CIIC4050.setDescription("");
        CIIC4050L.setDescription("");
        CIIC4060.setDescription("");
        CIIC4070.setDescription("");
        CIIC3081.setDescription("");
        CIIC4082.setDescription("");

        INSO4101.setDescription("");
        INSO4115.setDescription("");
        INSO4116.setDescription("");
        INSO4117.setDescription("");
        INSO4151.setDescription("");

        INGE3011.setDescription("");
        INGE3035.setDescription("");
        INGE3045.setDescription("");

        ININ4010.setDescription("");
        ININ4015.setDescription("");

        INGL3211.setDescription("");
        INGL3212.setDescription("");
        INGL3101.setDescription("");
        INGE3011.setDescription("");
        INGE3011.setDescription("");
        INGE3011.setDescription("");
        INGE3011.setDescription("");
        INGE3011.setDescription("");

        testList.add(testSection1A1);
        testList.add(testSection1B1);
        testList.add(testSection1C1);
        testList.add(testSection1D1);

        student.addMatricula(Matricula2);
        student.addMatricula(Matricula3);
        student.SetTurn(new Turn("12/25/2020 15:00-12/25/2020 15:30"));

        Matricula2.addSection(testSection1A1,CIIC3015);
        Matricula2.addSection(testSection1B2,CIIC3015L);
        Matricula2.addSection(testSection1C2,CIIC3075);
        Matricula2.addSection(testSection1D2,CIIC4010);

        Matricula3.addSection(testSection1A1,CIIC3015);
        Matricula3.addSection(testSection1B3,CIIC3015L);
        Matricula3.addSection(testSection1C3,CIIC3075);

        student.addPriority(INSO4101);
        student.addPriority(INGE3011);
        student.addPriority(ININ4010);

        try {

            db = new DBHandler();
            
            db.SaveDepartment(CIIC);
            db.SaveDepartment(INSO);
            db.SaveDepartment(INGE);
            db.SaveDepartment(ININ);
            db.SaveDepartment(INGL);
            
            db.SaveUser(user);
            db.SaveStudent(student);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
