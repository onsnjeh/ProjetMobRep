package fr.ons.projectsocket;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import fr.ons.projectsocket.Formulaire;

import fr.ons.projectsocket.MySQLiteOpenHelper;

public class AccessBD {
    private SQLiteDatabase db;
    private MySQLiteOpenHelper DB;
    private String BaseName = "bd";
    private Formulaire formulaire;
    private int version = 1;

    public AccessBD(Context context) {
        DB = new MySQLiteOpenHelper(context, BaseName, null, 1);
    }

    public void ajouter(Formulaire formulaire) {
        db = DB.getWritableDatabase();
        String req = "insert into Formulaire(planyingDate , playerMame1 ,playerMame2) values ";
        req += "(\"" + Formulaire.getId() + "\",\"" + formulaire.getQ1() + "\",\"" + formulaire.getQ2() + "\",\"" + formulaire.getQ3() + "\",\"" + formulaire.getQ4() + "\",\"" + formulaire.getQ5() + "\",\"" + formulaire.getQ6() + "\",\"" + formulaire.getQ7() + "\")";
        db.execSQL(req);
    }

    public Formulaire RécupérerDernier() {
        db = DB.getReadableDatabase();
        Formulaire players = null;
        String req = "select * from Formulaire";
        Cursor curseur =db.rawQuery(req, null);
        curseur.moveToLast();

        if (!curseur.isAfterLast()) {
            String id= curseur.getString(1);
            String Q1= curseur.getString(2);
            String Q2 = curseur.getString(3);
            String Q3= curseur.getString(4);
            String Q4= curseur.getString(5);
            String Q5= curseur.getString(6);
            String Q6= curseur.getString(7);
            String Q7= curseur.getString(8); 

            formulaire=new Formulaire(id,Q1,Q2,Q3,Q4,Q5,Q6,Q7);
        }
        curseur.close();
        return formulaire;
    }

}
