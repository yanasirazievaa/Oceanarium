package com.example.turkishsite.objects;

import com.example.turkishsite.Algorithm;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Oceanarium {
    private List<Fish> fishList = new ArrayList<>();
    public void addFish(String... fishNameList) {
        for (String fishName: fishNameList) {
            Fish newFish = new Fish(fishName);
            fishList.add(newFish);
        }
    }

    public boolean exists(String fishName) {
        return Algorithm
                .find(
                        fishList.stream()
                                .map(fish -> fish.getFishName().toLowerCase())
                                .toList(), fishName.toLowerCase());
    }
}
