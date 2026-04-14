package com.academy.five;

import com.academy.third.country.persistence.Country;
import com.academy.third.show.persistence.Show;
import com.academy.third.show.persistence.ShowDao;

public class Demo {
    public static void main(String[] args) {
        //Dao pattern
//        Show show = new Show();
//        show.setShowTitle("Vlak u snijegu");
//        show.setInitialYear((short) 1980);
//        show.setNumSeasons((short) 1);
//
//        ShowDao showDao = new ShowDao();
//        showDao.save(show);

        //Active Record - dizajn šablon u kojem entitetska klasa ima metode za snimi, pro

//        Show show2 = new Show();
//        show2.setShowTitle("Družba Sinjega ");
//        show2.setInitialYear((short) 1990);
//        show2.setNumSeasons((short) 2);
//        show2.save();

        Country country = new Country();
        country.setCountry("Crna Gora");
        country.save();
    }
}
