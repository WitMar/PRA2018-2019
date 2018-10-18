package collections;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.SetIterable;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MultiMapExample {

    public static void main(String[] args) throws InterruptedException {

        FastListMultimap<String, String> citiesToPeople = FastListMultimap.newMultimap();

        citiesToPeople.put("Poznan", "Nowak");
        citiesToPeople.put("Poznan", "Kowalski");
        citiesToPeople.put("Poznan", "Abraham");

        citiesToPeople.put("Berlin", "Muller");
        citiesToPeople.put("Berlin", "Nowak");
        citiesToPeople.put("Berlin", "Bond");
        citiesToPeople.put("Berlin", "Tyson");

        citiesToPeople.get("Poznan")
                .forEach(name -> {
                    System.out.println(name);
                });

        System.out.println("Poznan  citizens number:" + citiesToPeople.get("Poznan").size());
        System.out.println("Berlin  citizens number:" + citiesToPeople.get("Berlin").size());

        HashBagMultimap<String, String> citiesToPeopleNoOrder = HashBagMultimap.newMultimap();

        citiesToPeopleNoOrder.put("Poznan", "Nowak");
        citiesToPeopleNoOrder.put("Poznan", "Kowalski");
        citiesToPeopleNoOrder.put("Poznan", "Abraham");

        citiesToPeopleNoOrder.put("Berlin", "Muller");
        citiesToPeopleNoOrder.put("Berlin", "Nowak");
        citiesToPeopleNoOrder.put("Berlin", "Bond");
        citiesToPeopleNoOrder.put("Berlin", "Tyson");

        SetIterable<String> keys = citiesToPeopleNoOrder.keySet();

        MutableList<String> list = keys.toList();

        System.out.println("Poznan  citizens number:" + citiesToPeopleNoOrder.get("Poznan").size());
        System.out.println("Berlin  citizens number:" + citiesToPeopleNoOrder.get("Berlin").size());

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

        list.forEach(name -> {
            System.out.println(name);
            citiesToPeopleNoOrder.get(name).forEach(nameCitizen -> {
                System.out.println(nameCitizen);
            });
        });
    }

}
