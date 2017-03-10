package com.javarush.test.level27.lesson15.big01.ad;


import java.util.ArrayList;
import java.util.List;

class AdvertisementStorage
{
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    public static AdvertisementStorage getInstance()
    {
        return ourInstance;
    }

    private AdvertisementStorage()
    {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video 1", 1000, 100, 60));
        add(new Advertisement(someContent, "First Video 2", 3000, 100, 50));
        add(new Advertisement(someContent, "First Video 3", 5000, 100, 150));
        add(new Advertisement(someContent, "Second Video 1", 100, 10, 10));
        add(new Advertisement(someContent, "Second Video 2", 200, 10, 5*60));
        add(new Advertisement(someContent, "Second Video 3", 300, 10, 35));
        add(new Advertisement(someContent, "Third Video 1", 300, 2, 3*60));
        add(new Advertisement(someContent, "Third Video 2", 400, 2, 3*60));
        add(new Advertisement(someContent, "Third Video 3", 800, 2, 3*60));
    }

    private final List<Advertisement> videos = new ArrayList<>();

    public List<Advertisement> list()
    {
        return videos;
    }

    public void add(Advertisement advertisement)
    {
        videos.add(advertisement);
    }
}
