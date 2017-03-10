package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;


public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds; // время выполнения заказа, в это время будет показываться реклама

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        List<Advertisement> list = AdvertisementStorage.getInstance().list();

        List<Advertisement> candidates = new ArrayList<>();
        for (Advertisement ad : list)
        {
            if (ad.getHits() > 0 && ad.getDuration() <= timeSeconds)
            {
                candidates.add(ad);
            }
        }

        if (candidates.isEmpty())
        {
            throw new NoVideoAvailableException();
        }


        List<Advertisement> optimal = getOptimalList(candidates, timeSeconds);

        Collections.sort(optimal, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                {
                    return result * -1;
                } else
                {
                    return Double.compare(o1.getAmountPerSecond(), o2.getAmountPerSecond());
                }
            }
        });


        for (Advertisement ad : optimal)
        {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(), ad.getAmountPerOneDisplaying(), (int) (ad.getAmountPerSecond() * 1000)));
            ad.revalidate();
        }
    }

    private List<Advertisement> getOptimalList(List<Advertisement> list, int timeSeconds)
    {
        Set<Advertisement> candidatesSet = new HashSet<>(list);
        Set<Set<Advertisement>> powerSet = getPowerSet(candidatesSet);
        if (powerSet == null || powerSet.size() == 0)
        {
            throw new NoVideoAvailableException();
        }

        /*
        Этот набор должен удовлетворять следующим требованиям:
        1) сумма денег, полученная от показов, максимальная из всех возможных вариантов
        2) общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа
        3) для одного заказа любой видео-ролик показывается не более одного раза
        4) если существуют несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов, то:
        4.1) выбрать тот вариант, у которого суммарное время максимальное
        4.2) если суммарное время у этих вариантов одинаковое, то выбрать вариант с минимальным количеством роликов
        5) количество показов у любого рекламного ролика из набора - положительное число  */
        Set<Advertisement> optimalSet = (Set<Advertisement>)powerSet.toArray()[0];
        int optimalMoney = Integer.MIN_VALUE;    // сумма денег за показ всех роликов из набора
        int optimalDuration = Integer.MAX_VALUE; // общая продолжительность всех роликов из набора
        int optimalSize = Integer.MAX_VALUE;     // количество роликов в наборе
        for (Set<Advertisement> set : powerSet)
        {
            if (set.isEmpty()) continue;

            int moneyOfSet = 0;          // сумма денег за показ всех роликов из набора
            int durationOfSet = 0;       // общая продолжительность всех роликов из набора
            int sizeOfSet = set.size();  // количество роликов в наборе
            // считаем деньги и время для текущего набора
            for (Advertisement ad : set)
            {
                moneyOfSet += ad.getAmountPerOneDisplaying();
                durationOfSet += ad.getDuration();
            }

            // слишком продолжительные наборы отбрасываем
            if (durationOfSet > timeSeconds) continue;

            boolean foundBetter = false;
            if (moneyOfSet > optimalMoney)
            {
                foundBetter = true;
            }
            else if (moneyOfSet == optimalMoney)
            {
                if (durationOfSet > optimalDuration)
                {
                    foundBetter = true;
                }
                if (durationOfSet == optimalDuration && sizeOfSet < optimalSize)
                {
                    foundBetter = true;
                }
            }

            if (foundBetter)
            {
                optimalSet = set;
                optimalMoney = moneyOfSet;
                optimalDuration = durationOfSet;
            }

        }
        return new ArrayList<>(optimalSet);
    }

    public static <T> Set<Set<T>> getPowerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<>();
        if (originalSet.isEmpty())
        {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : getPowerSet(rest))
        {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
