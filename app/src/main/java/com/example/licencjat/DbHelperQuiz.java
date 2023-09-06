package com.example.licencjat;import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.licencjat.QuizContract.Entry.KEY_ANSWER;
import static com.example.licencjat.QuizContract.Entry.KEY_ID;
import static com.example.licencjat.QuizContract.Entry.KEY_OPTA;
import static com.example.licencjat.QuizContract.Entry.KEY_OPTB;
import static com.example.licencjat.QuizContract.Entry.KEY_OPTC;
import static com.example.licencjat.QuizContract.Entry.KEY_QUES;
import static com.example.licencjat.QuizContract.Entry.KEY_IMAGE; //do wywalenia moze
import static com.example.licencjat.QuizContract.Entry.TABLE_QUEST;

//import static com.example.licencjat.quizcontract2test.Entry.TABLE_NAME;
//import static com.example.licencjat.quizcontract2test.Entry.COLUMN_COLUMN;
//import static com.example.licencjat.quizcontract2test.Entry.COLUMN_FOREIGN_KEY;
//import static com.example.licencjat.quizcontract2test.Entry.COLUMN_ID;




public class DbHelperQuiz extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 24;

    private static final String DATABASE_NAME = "Quiz";

    private SQLiteDatabase dbase;
    public DbHelperQuiz(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
//        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
//                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
//                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
//                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_IMAGE+ " INTEGER)";

//        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
//                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + COLUMN_FOREIGN_KEY + " INTEGER, "
//                + COLUMN_COLUMN + " TEXT, "
//                + "FOREIGN KEY (" + COLUMN_FOREIGN_KEY + ") REFERENCES " + TABLE_QUEST + "(" + KEY_ID + "))";


        db.execSQL(sql);
//        db.execSQL(sql2);
        addQuestions();
//        db.close();
    }
    private void addQuestions()
    {
//        Questions q1=new Questions("Do czego służy przedstawiony na powyższym obrazku przedmiot?","Jest to pilot, umożliwiający uruchomienie robota", "Jest to pad do sterowania komputerami", "Przenośny stół rzemieślniczy umożliwiający tworzenie przedmiotów", "Jest to pilot, umożliwiający uruchomienie robota", R.drawable.pilot_crafting);
//        this.addQuestions(q1);
//        Questions q2=new Questions("Jak nazywa się modyfikacja umożliwiająca programowanie w Minecraft?", "SQLCraft", "ComputerCraft", "LuckyBlock", "ComputerCraft", R.drawable.questionmark);
//        this.addQuestions(q2);
//        Questions q3=new Questions("Jakiego elementu brakuje w powyższym programie?","Rep", "Do","End", "Do",R.drawable.repeat1);
//        this.addQuestions(q3);
        Questions q4=new Questions("Jakiego elementu brakuje w powyższym programie", "Then", "Do", "If","Do",R.drawable.repeat2);
        this.addQuestions(q4);
//        Questions q5=new Questions("Jaka jest najnowsza wersja Minecrafta umożliwiająca instalację modyfikacji ComputerCraft?","1.7.10","1.8.9","1.15.3","1.8.9",R.drawable.questionmark);
//        this.addQuestions(q5);
//        Questions q6=new Questions("Jaki język programowania jest używany w modyfikacji Computercraft?","Python","Lua","Java","Lua",R.drawable.questionmark);
//        this.addQuestions(q6);
//        Questions q7=new Questions("Co to jest API w modyfikacji Computercraft?","Skrót od \"All Programs Installed\"","Zestaw narzędzi programistycznych","Interfejs programowania aplikacji","Interfejs programowania aplikacji",R.drawable.questionmark);
//        this.addQuestions(q7);
//        Questions q8=new Questions("Jakie komputery są dostępne w modyfikacji Computercraft?","Komputery stacjonarne i laptopy","Komputery centralne i serwery","Komputery wirtualne i roboty","Komputery wirtualne i roboty",R.drawable.questionmark);
//        this.addQuestions(q8);
//        Questions q10=new Questions("Co to jest Turtle w modyfikacji Computercraft?","Zwierzę w grze Minecraft","Robot programowalny","Przedmiot, który można skonstruować","Robot programowalny",R.drawable.questionmark);
//        this.addQuestions(q10);
//        Questions q11=new Questions("Jakie są podstawowe składniki programowania w modyfikacji Computercraft?","Zmienne, funkcje, tablice","Bloki, przewody, kable","Maszyny, linie produkcyjne, roboty","Zmienne, funkcje, tablice",R.drawable.questionmark);
//        this.addQuestions(q11);
//        Questions q12=new Questions("Jakie są podstawowe komendy używane do programowania Turtles w modyfikacji Computercraft?","forward(), back(), turnLeft(), turnRight()","jump(), run(), fly(), swim()","shoot(), attack(), defend(), heal()","forward(), back(), turnLeft(), turnRight()",R.drawable.questionmark);
//        this.addQuestions(q12);
//        Questions q13=new Questions("Jakie są podstawowe operatory w języku Lua?","+, -, *, /","&&, ||, !","==, <, >","+, -, *, /",R.drawable.questionmark);
//        this.addQuestions(q13);
//        Questions q14=new Questions("Co to jest \"floppy disk\" w modyfikacji Computercraft?","Nośnik danych","Klawiatura komputerowa","Urządzenie do drukowania","Nośnik danych",R.drawable.questionmark);
//        this.addQuestions(q14);
//        Questions q15=new Questions("Jakie są podstawowe typy komputerów w modyfikacji Computercraft?","Desktop, laptop, tablet","Basic, advanced, mining","Copper, iron, gold","Basic, advanced, mining",R.drawable.questionmark);
//        this.addQuestions(q15);
//        Questions q16=new Questions("Co to jest \"monitor\" w modyfikacji Computercraft?","Urządzenie wyświetlające obraz","Program służący do zapisywania plików","Typ turtla","Urządzenie wyświetlające obraz",R.drawable.questionmark);
//        this.addQuestions(q16);
//        Questions q17=new Questions("Co to jest \"Lua\"?","Język programowania","Mod w modyfikacji Computercraft","Typ turtla","Język programowania",R.drawable.questionmark);
//        this.addQuestions(q17);
//        Questions q18=new Questions("Co to jest \"sleep\" w języku Lua?","Funkcja służąca do zatrzymania wykonania programu na określony czas","Komenda służąca do przemieszczania turtla do przodu","Polecenie służące do wyświetlania komunikatu na ekranie","Funkcja służąca do zatrzymania wykonania programu na określony czas",R.drawable.questionmark);
//        this.addQuestions(q18);
//        Questions q19=new Questions("Jakie są dwa podstawowe typy danych w języku Lua?","Czas i ilość","Tekst i liczby","Obrazy i dźwięki","Tekst i liczby",R.drawable.questionmark);
//        this.addQuestions(q19);
//        Questions q20=new Questions("Co to jest zmienna w programowaniu?","Urządzenie wejścia/wyjścia w komputerze","Nazwa pamięci, w której przechowywane są dane","Nazwa katalogu, w którym zapisywane są pliki","Nazwa pamięci, w której przechowywane są dane",R.drawable.questionmark);
//        this.addQuestions(q20);
//        Questions q21=new Questions("Jak nazywa się powyższa bramka logiczna?","AND","OR","NOT","AND",R.drawable.and);
//        this.addQuestions(q21);
//        Questions q22=new Questions("Jak nazywa się powyższa bramka logiczna?","AND","OR","NOT","OR",R.drawable.or);
//        this.addQuestions(q22);
        Questions q23=new Questions("Dodanie której funkcji nie spowoduje błędu w programie?","Dig","Drop Items Down","End","Drop Items Down",R.drawable.q23);
        this.addQuestions(q23);
//        Questions q24=new Questions("Jakie wartości należy wpisać w pętlach REP aby uzyskać kształt z powyższego obrazka?","Kolejno 4 oraz 3","Kolejno 3 oraz 4","Kolejno 4 oraz 4","Kolejno 4 oraz 3",R.drawable.q24);
//        this.addQuestions(q24);
        Questions q25=new Questions("Jaką wartość należy wpisać w pętli REP aby uzyskać kształt z powyższego obrazka?","4","5","3","3",R.drawable.q25);
        this.addQuestions(q25);
//        Questions q26=new Questions("Czy powyższe funkcje zadziałają tak samo?","Tak, obie wylosują liczbę od 1 do 6","Nie, ponieważ jedna z funkcji posiada przypisanie do zmiennej","Nie, ponieważ jedna wylosuje maksymalnie liczbę 1,6","Nie, ponieważ jedna z funkcji posiada przypisanie do zmiennej",R.drawable.q26);
//        this.addQuestions(q26);
        Questions q27=new Questions("Jak nazywa się powyższa funkcja?","Move Forward","Move Up","Move Back","Move Forward",R.drawable.q27);
        this.addQuestions(q27);
//        Questions q28=new Questions("Jak nazywa się powyższa funkcja?","Move Forward","Move Up","Move Back","Move Up",R.drawable.q28);
//        this.addQuestions(q28);
//        Questions q29=new Questions("Jak nazywa się powyższa funkcja?","Move Forward","Move Up","Move Back","Move Back",R.drawable.q29);
//        this.addQuestions(q29);
//        Questions q30=new Questions("Co to jest programowanie?","Zmienianie kanału telewizyjnego","Tworzenie programów komputerowych","Odkrywanie nowych planet","Tworzenie programów komputerowych",R.drawable.questionmark);
//        this.addQuestions(q30);
//        Questions q31=new Questions("Co to jest funkcja w programowaniu?","Wartość, która zawsze pozostaje stała","Zbiór instrukcji, które można wywołać wielokrotnie","Nazwa zmiennej","Zbiór instrukcji, które można wywołać wielokrotnie",R.drawable.l10);
//        this.addQuestions(q31);
//        Questions q32=new Questions("Co to jest interfejs użytkownika (UI) w programowaniu?","Część programu odpowiedzialna za przechowywanie danych","Część programu odpowiedzialna za interakcję z użytkownikiem","Część programu odpowiedzialna za wykonanie obliczeń","Część programu odpowiedzialna za interakcję z użytkownikiem",R.drawable.questionmark);
//        this.addQuestions(q32);
        Questions q33=new Questions("Co to jest debugowanie w programowaniu?","Testowanie aplikacji przed udostępnieniem jej użytkownikom","Usuwanie błędów i usterek w kodzie programu","Aktualizacja programu w celu wprowadzenia nowych funkcji","Usuwanie błędów i usterek w kodzie programu",R.drawable.l4w);
        this.addQuestions(q33);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        onCreate(db);
    }
    // Dodaj nowy question
    public void addQuestions(Questions quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTIONS());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_IMAGE, quest.getIMAGE());
        // Dodaj Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Questions> getAllQuestions() {
        List<Questions> quesList = new ArrayList<Questions>();
        // Query wybierające pytania
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST + " ORDER BY RANDOM() LIMIT 5";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        //przejście po wszystkich wierszach i dodanie ich do listy
        if (cursor.moveToFirst()) {
            do {
                Questions quest = new Questions();
                quest.setID(cursor.getInt(0));
                quest.setQUESTIONS(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setIMAGE(cursor.getInt(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        cursor.close();
        dbase.close();
        // zwrócenie listy pytań
        return quesList;
    }
    public int rowcount()
    {
        int row;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        cursor.close();
        return row;
    }
}
