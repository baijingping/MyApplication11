package soexample.umeng.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DaoSession daoSession;
    private int index;
    private PersonDao personDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoSession = DaoManager.getInstance(this).getDaoSession();
        personDao = daoSession.getPersonDao();
    }
    public void query(View view) {
        List<Person> list = personDao.queryBuilder()
                .where(PersonDao.Properties.Age.lt(500))
                .orderDesc(PersonDao.Properties.Age)
                .build()
                .list();
        for (Person person : list) {
            Log.e("tag", "query   " + person.toString());
        }
    }

    public void add(View view) {
        index++;
        Person person = new Person(null, "name" + index, index * 10);
        personDao.insert(person);
    }

    public void update(View view) {
        List<Person> list = personDao.queryBuilder()
                .where(PersonDao.Properties.Age.lt(500))
                .orderDesc(PersonDao.Properties.Age)
                .build()
                .list();
        for (Person person : list) {
            if (person.age == 20) {
                person.age = 100;
                personDao.update(person);
            }
        }
    }

    public void delete(View view) {
        Person person = personDao.queryBuilder()
                .where(PersonDao.Properties.Id.eq(2))
                .build()
                .unique();
        if (person != null) {
            personDao.delete(person);
        }
    }
}
