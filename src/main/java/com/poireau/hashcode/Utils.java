package com.poireau.hashcode;

import com.poireau.hashcode.entity.Photo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static Map<String, Integer> getTagsNbOccurences(List<Photo> photos) {
        HashMap<String, Integer> retVal = new HashMap<>();
        photos.forEach(p -> {
            p.getTags().forEach(t -> {
                if(retVal.containsKey(t))
                    retVal.put(t, retVal.get(t)+1);
                else
                    retVal.put(t, 1);
            });
        });
        return retVal;
    }
}
