package com.group.project;

import java.io.Serializable;
import java.util.ArrayList;

public class CityDB implements Serializable {

    private ArrayList<CityModel> cityList = new ArrayList<>();

    public CityDB() {
        // HOT COUNTRIES
        // Dominican Republic
        AddCity(new CityModel("Santo Domingo", "Dominican Republic",
                "Best for sightseeing", "18.483402", "-69.929611",
                "Cheap", "Bugs",
                "Beach", "https://www.godominicanrepublic.com/santo-domingo/", 0));
        AddCity(new CityModel("Punta Cana", "Dominican Republic",
                "Best all inclusive hotels", "18.58182", "-68.40431",
                "Mid", "None",
                "Rural",
                "https://www.godominicanrepublic.com/punta-cana/",
                0));
        AddCity(new CityModel("La Romana", "Dominican Republic",
                "Very upscale area", "18.42733", "-68.97285",
                "Rich", "Crowds",
                "Urban",
                "https://www.godominicanrepublic.com/la-romana/", 0));

        // Jamaica
        AddCity(new CityModel("White House", "Jamaica",
                "Rich luxury spot", "18.0944", "-77.9667",
                "Mid", "Wild Animals",
                "Beach", "https://www.sandals.com/south-coast/", 0));
        AddCity(new CityModel("Kingston", "Jamaica",
                "Cultural spot", "18.0179", "-76.8099", "Mid",
                "Bugs",
                "Urban",
                "https://www.visitjamaica.com/plan-your-trip/explore-the-island/kingston/",
                0));
        AddCity(new CityModel("Montego Bay", "Jamaica",
                "Full of resorts and beaches", "18.4762", "-77.8939",
                "Rich",
                "Wild Animals",
                "Beach",
                "https://www.visitjamaica.com/plan-your-trip/explore-the-island/montego-bay/",
                0));

        // Cuba
        AddCity(new CityModel("Old Havana", "Cuba",
                "Good for your first visit to Cuba", "23.1344", "-82.3533",
                "Cheap",
                "Bugs", "Urban", "https://www.tripcuba.org/old-havana",
                0));
        AddCity(new CityModel("Santa Clara", "Cuba",
                "Low budget, people place", "37.3541", "-121.9552",
                "Cheap",
                "Wild Animals",
                "Rural", "https://www.tripcuba.org/santa-clara-villa-clara", 0));
        AddCity(new CityModel("Centro Habana", "Cuba",
                "Crowded, nightlife area", "23.1351", "-82.3696",
                "Mid",
                "Crowds",
                "Urban", "https://www.tripcuba.org/centro-habana", 0));

        // India
        AddCity(new CityModel("Delhi", "India",
                "Crowded, nightlife area", "28.7041", "77.1025",
                "Mid",
                "Crowds",
                "Urban",
                "https://www.delhitourism.gov.in/delhitourism/aboutus/index.jsp", 0));
        AddCity(new CityModel("Jaipur", "India",
                "Crowded, nightlife area", "26.9124", "75.7873",
                "Rich",
                "Bugs",
                "Urban", "https://www.jaipurtravel.com/", 0));
        AddCity(new CityModel("Agra", "India",
                "Crowded, nightlife area", "27.1767", "78.0081",
                "Cheap",
                "Bugs",
                "Urban", "https://agra.nic.in/tourism/", 0));

        // Mexico
        AddCity(new CityModel("Cancun", "Mexico",
                "Crowded, nightlife area", "21.1619", "-86.8515",
                "Cheap",
                "Bugs",
                "Beach", "https://www.mexicancaribbean.travel/cancun/", 0));
        AddCity(new CityModel("Mexico City", "Mexico",
                "Crowded, nightlife area", "19.4326", "-99.1332",
                "Mid",
                "Crowds",
                "Urban", "https://www.visitmexico.com/en/mexico-city", 0));
        AddCity(new CityModel("San Cristóbal De Las Casas", "Mexico",
                "Crowded, nightlife area", "16.7370", "-92.6376",
                "Cheap",
                "Wild Animals",
                "Rural",
                "https://www.visitmexico.com/en/chiapas/san-cristobal-de-las-casas", 0));

        // WARM COUNTRIES
        // Turkey
        AddCity(new CityModel("Istanbul", "Turkey",
                "Best for sightseeing", "41.0082", "28.9784",
                "Cheap", "None",
                "Urban", "https://visit.istanbul/en/", 0));
        AddCity(new CityModel("Izmir", "Turkey",
                "Best for sightseeing", "38.4237", "27.1428",
                "Cheap", "None",
                "Beach", "https://www.visitizmir.org/en", 0));
        AddCity(new CityModel("Çanakkale", "Turkey",
                "Best for sightseeing", "40.1467", "26.4086",
                "Cheap", "None",
                "Urban",
                "https://turkeytravelplanner.com/go/ThraceMarmara/canakkale/index.html",
                0));

        // France
        AddCity(new CityModel("Paris", "France",
                "Best for sightseeing", "48.8566", "2.3522",
                "Mid", "None",
                "Urban", "https://www.visitparisregion.com/en", 0));
        AddCity(new CityModel("Nice", "France",
                "Best for sightseeing", "43.7102", "7.2620",
                "Cheap", "None",
                "Beach", "http://www.nice-tourism.com/en/", 0));
        AddCity(new CityModel("Lyon", "France",
                "Best for sightseeing", "45.7640", "4.8357",
                "Cheap", "None",
                "Urban", "https://en.lyon-france.com/", 0));

        // Italy
        AddCity(new CityModel("Rome", "Italy",
                "Best for sightseeing", "41.9028", "12.4964",
                "Mid", "Crowds",
                "Urban", "https://romesite.com/", 0));
        AddCity(new CityModel("Venice", "Italy",
                "Best for sightseeing", "45.4408", "12.3155",
                "Mid", "Crowds",
                "Beach", "https://www.veneziaunica.it/en/content/visit-venice-0",
                0));
        AddCity(new CityModel("Florence", "Italy",
                "Best for sightseeing", "43.7696", "11.2558",
                "Cheap", "Crowds",
                "Urban", "https://www.visitflorence.com/", 0));

        // Portugal
        AddCity(new CityModel("Lisbon", "Portugal",
                "Best for sightseeing", "38.7223", "-9.1393",
                "Cheap", "Crowds",
                "Urban", "https://lisbonlisboaportugal.com/index.html", 0));
        AddCity(new CityModel("Porto", "Portugal",
                "Best for sightseeing", "41.1579", "-8.6291",
                "Cheap", "None",
                "Beach", "https://www.introducingporto.com/", 0));
        AddCity(new CityModel("Albufeira", "Portugal",
                "Best for sightseeing", "37.0891", "-8.2479",
                "Cheap", "Bugs",
                "Beach", "https://albufeira.com/", 0));

        // England
        AddCity(new CityModel("London", "England",
                "Best for sightseeing", "51.5072", "-0.1276",
                "Mid", "Crowds",
                "Urban", "https://www.visitlondon.com/", 0));
        AddCity(new CityModel("Oxford", "England",
                "Best for sightseeing", "51.7520", "-1.2577",
                "Cheap", "Crowds",
                "Urban", "https://www.tourismoxford.ca/", 0));
        AddCity(new CityModel("Canterbury", "England",
                "Best for sightseeing", "51.2802", "1.0789",
                "Mid", "None",
                "Rural", "https://www.canterbury.co.uk/", 0));

        // COLD COUNTRIES
        // Canada
        AddCity(new CityModel("Toronto", "Canada",
                "Best for sightseeing", "43.6532", "-79.3832",
                "Mid", "None",
                "Urban", "https://www.destinationtoronto.com/", 0));
        AddCity(new CityModel("Ottawa", "Canada",
                "Best for sightseeing", "45.4215", "-75.6972",
                "Mid", "None",
                "Urban", "https://ottawatourism.ca/en", 0));
        AddCity(new CityModel("Quebec City", "Canada",
                "Best for sightseeing", "46.8139", "-71.2080",
                "Cheap", "None",
                "Urban", "https://www.quebec-cite.com/en", 0));

        // Norway
        AddCity(new CityModel("Oslo", "Norway",
                "Best for sightseeing", "59.9139", "10.7522",
                "Mid", "None",
                "Urban", "https://www.visitoslo.com/en/", 0));
        AddCity(new CityModel("Bergen", "Norway",
                "Best for sightseeing", "60.3913", "5.3221",
                "Cheap", "None",
                "Beach", "https://en.visitbergen.com/", 0));
        AddCity(new CityModel("Ålesund", "Norway",
                "Best for sightseeing", "62.4722", "-6.1495",
                "Cheap", "None",
                "Urban",
                "https://www.fjordtours.com/places-to-visit-in-norway/alesund/", 0));

        // Iceland
        AddCity(new CityModel("Reykjavík", "Iceland",
                "Best for sightseeing", "64.9631", "-19.0208",
                "Rich", "None",
                "Urban", "https://www.visiticeland.com/article/reykjavik/", 0));
        AddCity(new CityModel("Hafnarfjörður", "Iceland",
                "Best for sightseeing", "64.0291", "-21.9685",
                "Mid", "None",
                "Rural", "https://visitreykjavik.is/city-areas/hafnarfjordur",
                0));
        AddCity(new CityModel("Akureyri", "Iceland",
                "Best for sightseeing", "65.6826", "-18.0907",
                "Mid", "None",
                "Rural", "https://www.visitakureyri.is/en", 0));

        // Switzerland
        AddCity(new CityModel("Zurich", "Switzerland",
                "Best for sightseeing", "47.3769", "8.5417",
                "Mid", "Crowds",
                "Urban", "https://www.zuerich.com/en", 0));
        AddCity(new CityModel("Geneva", "Switzerland",
                "Best for sightseeing", "46.2044", "6.1432",
                "Mid", "Crowds",
                "Urban", "http://www.geneva.info/sights/", 0));
        AddCity(new CityModel("Bern", "Switzerland",
                "Best for sightseeing", "46.9480", "7.4474",
                "Mid", "None",
                "Rural", "https://www.bern.com/en/home", 0));

        // China
        AddCity(new CityModel("Mohe City", "China",
                "Best for sightseeing", "52.9721", "122.5386",
                "Cheap", "Wild Animals",
                "Rural", "https://www.chinatravel.com/mohe", 0));
        AddCity(new CityModel("Harbin", "China",
                "Best for sightseeing", "45.7567", "126.6424",
                "Cheap", "Crowds",
                "Urban", "http://www.harbin.gov.cn/col/col16590/index.html", 0));
        AddCity(new CityModel("Yunnan", "China",
                "Best for sightseeing", "25.0453", "102.7097",
                "Cheap", "Bugs",
                "Rural", "https://en.wikipedia.org/wiki/Santo_Domingo", 0));
    }

    public boolean AddCity(CityModel city) {
        if (cityList.contains(city))
            return false;
        else {
            cityList.add(city);
            return true;
        }
    }

    public CityModel[] GetAllCities() {
        return cityList.toArray(new CityModel[cityList.size()]);
    }

    public boolean RemoveCity(CityModel city) {
        if (cityList.contains(city)) {
            cityList.remove(city);
            return true;
        } else
            return false;
    }
}
